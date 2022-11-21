package com.martweb.ticketful.api.utils;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateFormat {
    public static Date dateFormatter(String date) throws  ParseException{
        Date dateObj = new SimpleDateFormat("dd-mm-yyyy hh:mm").parse(String.valueOf(date));
        return dateObj;
    }

}
