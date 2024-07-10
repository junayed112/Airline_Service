package com.airline.service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.apache.tomcat.util.http.FastHttpDateFormat.getCurrentDate;

public class SystemDateFormatter {
    public static Date setTicketPurchaseDate() throws ParseException{
        String currentDateStr = getCurrentDate();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
            Date currentDate = sdf.parse(currentDateStr);
            return currentDate;
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
            return null;
        }
    }
}
