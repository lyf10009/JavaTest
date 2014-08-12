package BasicApp;

import java.util.Calendar;

public class CalendarTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calendar cal=Calendar.getInstance();
        
//        System.out.println(cal.HOUR_OF_DAY);
//        System.out.println(Calendar.HOUR_OF_DAY);
//        System.out.println(cal.AM_PM);
        System.out.println(cal.DAY_OF_MONTH);
        System.out.println(cal.DAY_OF_WEEK);
        System.out.println(cal.DAY_OF_WEEK_IN_MONTH);
        System.out.println(cal.DAY_OF_YEAR);
//        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
    }

}
