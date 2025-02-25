package com.kafmongo.kafmongo.kafka.producer;

import com.kafmongo.kafmongo.api.DataFetchService;
import com.kafmongo.kafmongo.api.IndexRealTimeData;
import com.kafmongo.kafmongo.Service.DailyPriceService;
import com.kafmongo.kafmongo.api.DailyBourseData;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Map;

@Service
public class KafkaScheduledProducer {

    @Autowired
    private DataProducerService producerService;

    @Autowired
    private DataFetchService dataFetchService;

    @Autowired
    private DailyPriceService dailyPriceService;

    @Autowired
    private DailyBourseData dailyBourseData;

    @Autowired
    private IndexRealTimeData indexRealTimeData;

    @Scheduled(fixedRate = 15000)  // Runs every 1 minute (60,000 ms)
    public void fetchDataAndSendToKafka() {
    	
    	LocalTime now = LocalTime.now();
        LocalTime marketOpen = LocalTime.of(9, 0);
        LocalTime marketClose = LocalTime.of(23, 0);
        if (now.isAfter(marketOpen) && now.isBefore(marketClose)) {
	        try {
	            //JSONArray bourseData = dataFetchService.aralya_data();
	            //producerService.sendBourseDataToKafka(bourseData, "intraday-stock-prices");
	
	            //Map<String, JSONArray> dailyPrices = dailyBourseData.getAllDataSymbols(null, null, 1);
	            //producerService.sendDailyPriceDataToKafka(dailyPrices, "daily-prices");
	
	            JSONArray indexData = indexRealTimeData.aralya_data();
	            producerService.sendIndexRTData(indexData, "intraday-index-prices");
	
	            System.out.println("Data successfully sent to Kafka at: " + System.currentTimeMillis());
	
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.err.println("Failed to fetch or process data from API");
	        }
	              } else {
	            	  System.out.println("Market is closed. Skipping Kafka data push.");
	              }
    }
}
