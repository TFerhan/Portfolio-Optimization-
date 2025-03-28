package com.kafmongo.kafmongo.Repo;

import com.kafmongo.kafmongo.model.DailyPriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kafmongo.kafmongo.model.DailyPrice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.kafmongo.kafmongo.utils.DailyMetrics;
@Repository
public interface DailyPriceRepo extends JpaRepository<DailyPrice, DailyPriceId> {

    @Modifying
    @Transactional
    @Query(value = "DO $$ BEGIN " +
            "IF NOT EXISTS (SELECT 1 FROM timescaledb_information.hypertables WHERE hypertable_name = 'daily_price') THEN " +
            "PERFORM create_hypertable('daily_price', 'created', migrate_data => true); " +
            "END IF; " +
            "END $$;", nativeQuery = true)
    void ensureHypertableExists();
    
    
    
    @Query(value = """
    	    WITH weekly_returns AS (
    SELECT 
        ticker, 
        DATE_TRUNC('week', created) + INTERVAL '1 day' AS week_start,  -- Ensures week starts on Monday
        LOG(
            LAST_VALUE(closing_price) OVER (PARTITION BY ticker, DATE_TRUNC('week', created) ORDER BY created RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) /
            FIRST_VALUE(closing_price) OVER (PARTITION BY ticker, DATE_TRUNC('week', created) ORDER BY created)
        ) AS weekly_log_return
    FROM daily_price
    WHERE created >= :date_start AND created <= :date_end
      AND EXTRACT(DOW FROM created) BETWEEN 1 AND 5 
	  AND ticker = :ticker
)
SELECT DISTINCT
    ticker, 
    week_start, 
    weekly_log_return, 
    STDDEV(weekly_log_return) OVER (PARTITION BY ticker) AS std_weekly,
	AVG(weekly_log_return) OVER (PARTITION BY ticker) as avg_weekly
FROM weekly_returns
WHERE weekly_log_return IS NOT NULL
ORDER BY ticker, week_start;

    	""", nativeQuery = true)
    	List<DailyMetrics> getWeeklyReturns(@Param("ticker") String ticker, @Param("date_start") String date_start, @Param("date_end") String date_end);
    	
    @Query(value = """ 
    		WITH monthly_prices AS (
		    SELECT 
		        ticker, 
		        DATE_TRUNC('month', created) AS month_start,  -- Ensure Monday as week start
		       LOG(
		        (LAST_VALUE(closing_price) OVER (PARTITION BY ticker, DATE_TRUNC('month', created) ORDER BY created RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS friday_close)/
		        (FIRST_VALUE(closing_price) OVER (PARTITION BY ticker, DATE_TRUNC('month', created) ORDER BY created) AS monday_open)) AS monthly_log_return
		    FROM daily_price
		    WHERE created >= :date_start AND created <= :date_end
              AND ticker = :ticker
			  
		)
		SELECT DISTINCT 
		    ticker, 
		    month_start, 
		    monthly_log_return,
		    STDDEV(monthly_log_return) OVER (PARTITION BY ticker) AS std_monthly,
		    AVG(monthly_log_return) OVER (PARTITION BY ticker) as avg_monthly 
		FROM monthly_prices
		WHERE monday_open IS NOT NULL AND friday_close IS NOT NULL
		ORDER BY ticker, month_start;

    		""")
        List<DailyMetrics> getMonthlyReturns(@Param("ticker") String ticker, @Param("date_start") String date_start, @Param("date_end") String date_end);
        
        @Query(value = """
        		WITH daily_returns AS (
			    SELECT 
			        ticker, 
			        created, 
			        ABS(LOG(closing_price / LAG(closing_price) OVER (PARTITION BY ticker ORDER BY created))) AS abs_return
			    FROM daily_price
			    WHERE created >= :date_start AND created <= :date_end
                  AND ticker = :ticker
			)
			SELECT 
			    d.ticker, 
			    d.created, 
			    d.abs_return / p.volume AS illiquidity_ratio
			FROM daily_returns d
			JOIN daily_price p ON d.ticker = p.ticker AND d.created = p.created
			WHERE d.abs_return IS NOT NULL AND p.volume IS NOT NULL;

        		""")
        List<DailyMetrics> getIlliquidityRatio(@Param("ticker") String ticker, @Param("date_start") String date_start, @Param("date_end") String date_end);
        
        
        @Query("""
        		with daily_stock_log_returns as (Select ticker, created, LOG(closing_price / LAG(closing_price, :num_lags) OVER(PARTITION By ticker ORDER BY created)) AS daily_returns 
From daily_price where ticker = :ticker and created >= :date_start and created <= :date_end)
select ticker , created, daily_returns, AVG(daily_returns) OVER (PARTITION BY ticker) as avg_returns, STDDEV(daily_returns) OVER (PARTITION BY ticker) as std_returns
from daily_stock_log_returns where daily_returns is not NULL
        		""")
        List<DailyMetrics> getDailyReturns(@Param("ticker") String ticker, @Param("date_start") String date_start, @Param("date_end") String date_end, @Param("num_lags") int num_lags);
        
        @Query("""
        		Select * from daily_price where ticker = :ticker and created >= :date_start and created <= :date_end
        		""")
        List<DailyPrice> getDailyPrices(@Param("ticker") String ticker, @Param("date_start") String date_start, @Param("date_end") String date_end);

}