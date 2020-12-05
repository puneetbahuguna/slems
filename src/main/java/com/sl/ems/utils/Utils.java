package com.sl.ems.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static Date getFormattedDate(String dateString){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date getDOBFormattedDate(Date inputDate){
        Date formatDate=null;
        try {
            String dateString = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(inputDate);
            formatDate=new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        }catch (Exception e){}
        return formatDate;
    }
    public static String getBase64Encoding(String plainText){
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }
    public static Date getCurrentDate(){
        Date currentDate = null;
        try {
            String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //LocalDate today = LocalDate.now();

            currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(modifiedDate);
            /*String modifiedDate= new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            currentDate = new SimpleDateFormat("dd-MM-yyyy").parse(modifiedDate);*/
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }
}
