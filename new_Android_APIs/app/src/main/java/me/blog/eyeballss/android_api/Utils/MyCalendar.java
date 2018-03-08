package me.blog.eyeballss.android_api.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by david on 18. 3. 6.
 */

public class MyCalendar {

    private static final MyCalendar myCalendar= new MyCalendar();
    private Calendar calendar;
    private Locale locale;

    public static MyCalendar getInstance(){
        return myCalendar;
    }

    private MyCalendar(){
        locale = Locale.getDefault();
        calendar = new GregorianCalendar(locale);
    }

    //1 : 일
    //2 : 월
    //3 : 화
    //4 : 수
    //5 : 목
    //6 : 금
    //7 : 토
    public int getWeekday(){
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public String getCurrentSomething(String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(calendar.getTime());
        }catch(IllegalStateException e){
            return null;
        }catch(Exception e){
            return null;
        }
    }

    public String getCurrentDateAndTime(){
        return getCurrentSomething("yyyy.MM.dd HH:mm");
    }

    public String getCurrentTime(){
        return getCurrentSomething("HH:mm");
    }

}
