package com.water.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestConvert {

	@Test
	public void LongToDate() throws Exception {
		long time = 2018040213;
	}
	
	public Date getNextDay(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, 1);  
        date = calendar.getTime();  
        return date;  
    }
	
	@Test
	public void getDate(){
		
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(fomat.format(getNextDay(new Date())));
		
	}
}
