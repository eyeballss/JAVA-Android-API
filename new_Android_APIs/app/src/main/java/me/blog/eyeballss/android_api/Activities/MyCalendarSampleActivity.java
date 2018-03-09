package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyCalendar;

public class MyCalendarSampleActivity extends AppCompatActivity {

    TextView today, result;
    EditText to;

    TextView result2;
    EditText to2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar_sample);

         today = findViewById(R.id.today);
         to = findViewById(R.id.convert_to);
         result = findViewById(R.id.convert_result);

        to2 = findViewById(R.id.convert_to2);
        result2 = findViewById(R.id.convert_result2);

        int weekday = MyCalendar.getInstance().getWeekday();
        String todayResult = "";
        switch(weekday){
            case 1: todayResult="일"; break;
            case 2: todayResult="월"; break;
            case 3: todayResult="화"; break;
            case 4: todayResult="수"; break;
            case 5: todayResult="목"; break;
            case 6: todayResult="금"; break;
            default: todayResult="토";
        }

        todayResult=MyCalendar.getInstance().getCurrentDateAndTime()+" "+todayResult+"요일";
        today.setText(todayResult);

    }

    public void convert(View view){

        String to = this.to.getText().toString();

        String result = MyCalendar.getInstance().getCurrentSomething(to);
        if(result==null) result = "에러!";
        this.result.setText(result);

    }

    public void convert2(View view){

        String to = this.to2.getText().toString();

        MyCalendar.DateDifference dateDifference = MyCalendar.getInstance().getDifferenceDaysBetween(to);

        String result = "에러";
        if(dateDifference!=null){

            long diff = dateDifference.getDifference();
            String unit = dateDifference.getUnit();
            result=diff+unit+" 지났습니다.";
        }
        this.result2.setText(result);

    }
}
