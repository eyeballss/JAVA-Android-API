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


    public Date convertStringToDate(String str, String format){
        Date date=null;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        }catch(Exception e){
            MyLogger.getInstance().e(this, "string을 date로 변환하는 과정에서 문제가 생겼습니다.");
            return null;
        }

        return date;
    }

    public DateDifference getDifferenceDaysBetween(String toDate){
        String format = "yyyy.MM.dd HH:mm:ss";
        return getDifferenceDaysBetween(getCurrentSomething(format) ,toDate, format);
    }

    public DateDifference getDifferenceDaysBetween(String toDate, String fromDate){
        String format = "yyyy.MM.dd HH:mm:ss";
        return getDifferenceDaysBetween(fromDate, toDate, format);
    }

    public DateDifference getDifferenceDaysBetween(String toDate, String fromDate, String format){
        long diff = 0;
        String unit = "";
        DateDifference dateDifference = new DateDifference();

        try{
            Date from = convertStringToDate(fromDate, format);
            Date to = convertStringToDate(toDate, format);

            long difference = to.getTime() - from.getTime();

            if(difference<(60*1000)) {
                diff = difference / (1000);
                unit = "초";
                dateDifference.setDifference(diff);
                dateDifference.setUnit(unit);

            }else if((60*1000)<= difference && difference<(60*60*1000)) {
                diff = difference / (60*1000);
                unit = "분";
                dateDifference.setDifference(diff);
                dateDifference.setUnit(unit);

            }else if((60*60*1000)<= difference && difference<(24*60*60*1000)) {
                diff = difference / (60*60*1000);
                unit = "시간";
                dateDifference.setDifference(diff);
                dateDifference.setUnit(unit);

            }else {
                diff = (difference / (24 * 60 * 60 * 1000));
                unit = "일";
                dateDifference.setDifference(diff);
                dateDifference.setUnit(unit);
            }


        }catch(Exception e){
            MyLogger.getInstance().e(this, "두 날짜간 차이를 구하는 데 에러가 발생하였습니다.", e);
            return null;
        }

        return dateDifference;

    }

    //제대로 된 생년 월 일이 들어갔는지 체크
    public boolean checkBirthday(int year, int month, int day){

        //년 자체가 잘못 되어있다면. 1800은 단지 기준값일 뿐.
        if(year<1800) return false;

        //달 자체가 잘못 되어있다면
        if(month<=0 || month>12) return false;

        //일 자체가 잘못 되어있다면
        if(day<=0 || day>31) return false;

        int extra = 0;
        if( (0 == (year % 4) && 0 != (year %100)) || 0 == year%400 ) extra=1; //윤년이면 +1

        int days[] = {31, 28+extra, 31,30,31,30,31,31,30,31,30,31};

        if(day>days[month-1]) return false;

        return true;
    }

    public class DateDifference{
        private String unit;
        private long difference;

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public long getDifference() {
            return difference;
        }

        public void setDifference(long difference) {
            this.difference = difference;
        }
    }

}
