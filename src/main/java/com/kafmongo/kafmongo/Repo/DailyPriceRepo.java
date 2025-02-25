package com.kafmongo.kafmongo.Repo;

import com.kafmongo.kafmongo.model.DailyPriceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kafmongo.kafmongo.model.DailyPrice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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
}