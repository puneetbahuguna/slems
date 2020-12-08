package com.sl.ems.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
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
    public static String getFormattedDateString(Date inputDate){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(inputDate);
        }catch (Exception e){return null;}
    }
    public static String getBase64Encoding(String plainText){
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }
    public static String getBase64Decoding(String encryptedString){
        byte[] decodesString = Base64.getDecoder().decode(encryptedString);
        return new String(decodesString);
    }
    public static Date getCurrentDate(){
        Date currentDate = null;
        try {
            String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(modifiedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return currentDate;
    }
}
