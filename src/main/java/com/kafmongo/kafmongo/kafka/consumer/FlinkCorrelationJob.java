package com.kafmongo.kafmongo.kafka.consumer;

import java.util.Properties;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.formats.avro.AvroDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import com.kafmongo.kafmongo.utils.DailyPriceStock;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.kafka.clients.consumer.ConsumerRecord;


public class FlinkCorrelationJob {
	
	public static void main(String[] args) throws Exception {
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		
		AvroDeserializationSchema<DailyPriceStock> avroSchema = new AvroDeserializationSchema<>(DailyPrice.class);
		
		Properties kafkaProps = new Properties();
		kafkaProps.setProperty("bootstrap.servers", "localhost:9092");
		kafkaProps.setProperty("group.id", "flink-correlation-group");
		
		FlinkKafkaConsumer<DailyPriceStock> consumer = new FlinkKafkaConsumer<>(
				"daily-prices", avroSchema, kafkaProps
				);
		consumer.setStartFromEarliest();
		
		DataStream<DailyPriceStock> stockPriceStream = env.addSource(consumer)
				.map(new MapFunction<DailyPriceStock, StockPrice> {
					@Override
					public StockPrice map(DailyPriceStock value) throws Exception {
						return new StockPrice(
								value.getTicker(),
                                value.getCreated(),
                                value.getClosingPrice(),
                                );
					}
				});
		
		DataStream<CorrelationResult> correlationStream = stockPriceStream
				.keyBy(stock -> stock.ticker)
				.window(TumblingProcessingTimeWindows.of(Time.minutes(60)))
				.aggregate(new CorrelationAggregator());
		
		
		FlinkKafkaProducer<>
		
		
		
		
	}

}
