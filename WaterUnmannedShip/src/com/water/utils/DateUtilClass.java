package com.water.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtilClass {

	public static Date getDay(Date date, int num) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, num);  
        date = calendar.getTime();  
        return date;  
    }
}
