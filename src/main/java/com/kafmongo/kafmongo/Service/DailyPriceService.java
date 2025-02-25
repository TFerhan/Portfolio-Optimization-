package com.kafmongo.kafmongo.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.kafmongo.kafmongo.Repo.DailyPriceRepo;
import com.kafmongo.kafmongo.model.DailyPrice;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
	
	
	
	
	
	

}