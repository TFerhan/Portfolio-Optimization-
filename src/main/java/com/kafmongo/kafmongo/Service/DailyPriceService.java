package com.kafmongo.kafmongo.Service;

import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.kafmongo.kafmongo.Repo.DailyPriceRepo;
import com.kafmongo.kafmongo.model.DailyPrice;
import com.kafmongo.kafmongo.utils.DailyMetrics;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class DailyPriceService {
	
	@Autowired
	private DailyPriceRepo dailyPriceRepo;



	@Transactional
	public DailyPrice saveDailyPrice(DailyPrice dailyPrice) {
		// Ensure the table is a hypertable before saving
		dailyPriceRepo.ensureHypertableExists();

		// Save the entity
		return dailyPriceRepo.save(dailyPrice);
	}
	
	
	
	public void saveAll(Iterable<DailyPrice> dailyPrices) {
		dailyPriceRepo.saveAll(dailyPrices);
	}
	
	public JSONObject getWeeklyDataReturns(String ticker, String start, String finish) {
		
		List<DailyMetrics> data = dailyPriceRepo.getWeeklyReturns(ticker, start, finish);
		JSONObject json = new JSONObject();
		for (DailyMetrics metrics : data) {
			JSONObject obj = new JSONObject();
			obj.put("ticker", metrics.getTicker());
			obj.put("week_start", metrics.getDate());
			obj.put("weekly_log_return", metrics.getWeeklyLogReturn());
			obj.put("std_weekly", metrics.getStdWeekly());
			obj.put("avg_weekly", metrics.getAvgWeekly());
			json.put(metrics.getDate().toString(), obj);
		}
		return json;
		
		
	}
	
	public JSONObject getMonthlyDataReturns(String ticker, String start, String finish) {

		List<DailyMetrics> data = dailyPriceRepo.getMonthlyReturns(ticker, start, finish);
		JSONObject json = new JSONObject();
		for (DailyMetrics metrics : data) {
			JSONObject obj = new JSONObject();
			obj.put("ticker", metrics.getTicker());
			obj.put("month_start", metrics.getDate());
			obj.put("monthly_log_return", metrics.getMonthlyLogReturn());
			obj.put("std_monthly", metrics.getStdMonthly());
			obj.put("avg_monthly", metrics.getAvgMonthly());
			json.put(metrics.getDate().toString(), obj);
		}
		return json;

	}
	
	public JSONObject getAllDailyPrices() {
		List<DailyPrice> data = dailyPriceRepo.findAll();
		JSONObject json = new JSONObject();
		for (DailyPrice price : data) {
			JSONObject obj = new JSONObject();
			obj.put("ticker", price.getTicker());
			obj.put("created", price.getCreated());
			obj.put("closingPrice", price.getClosingPrice());
			obj.put("highPrice", price.getHighPrice());
			obj.put("lowPrice", price.getLowPrice());
			obj.put("cumulTitresEchanges", price.getCumulTitresEchanges());
			obj.put("capitalisation", price.getCapitalisation());
			obj.put("cumulVolumeEchange", price.getCumulVolumeEchange());
			json.put(price.getCreated().toString(), obj);
		}
		return json;
	
	}
	
	public List<DailyPrice> getByTicker(String ticker, String start, String finish){
		return dailyPriceRepo.getDailyPrices(ticker, start, finish);
    }
	
	public List<>
	
	
	
	
	
	

}