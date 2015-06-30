package com.BasicApp;

import java.util.Calendar;

public class CalendarTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar cal=Calendar.getInstance();
        
        System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        
    }

}
