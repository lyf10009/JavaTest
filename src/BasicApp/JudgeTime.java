package BasicApp;

import java.util.Calendar;
import java.util.Date;

public class JudgeTime {
    //��ȡ��ǰʱ��
    public static void main(String[] args) {
        long time=System.currentTimeMillis()+129600000;
        Calendar calendar=Calendar.getInstance();
//        calendar.setTimeInMillis(time);
//        System.out.println(calendar.get(Calendar.HOUR));
        
        Date date=new Date(time);
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }
}
