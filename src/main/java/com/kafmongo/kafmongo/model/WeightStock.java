package com.kafmongo.kafmongo.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WeightStock {
	
	private float weight;
	private String ticker;
	private Date time;
	
	WeightStock(){
		
	}
	
	public float getWeight() {
		return this.weight;}
	
	public String getTicker() {
		return this.ticker;
	}
	
	public Date getTime() {
		return this.time;
	}
	
	public void setWeight(CharSequence c) {
		this.weight = Float.parseFloat(c.toString());	
	}
	
	public void setTicker(CharSequence c) {
		this.ticker = c.toString();
	}
	
	public void setTime(CharSequence charSequence) {
    	
    	String dateString = charSequence.toString();

        // Define the date format for ISO 8601
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date;
		try {
			date = isoFormat.parse(dateString);
			this.time = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	
    }
	
	

}
