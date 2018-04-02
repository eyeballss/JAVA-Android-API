package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import me.blog.eyeballss.android_api.Interfaces.GestureListenerInterface;
import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyCalendar;
import me.blog.eyeballss.android_api.Utils.MyGestureDetector;

public class MyGuestureDetectorSampleActivity extends AppCompatActivity {

    private TextView gestureBox;
    private LinearLayout gestureLog;
    private ScrollView scroll;
    private GestureDetector mTextBoxGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_guesture_detector_sample);

        scroll = findViewById(R.id.gesture_scroll);

        gestureBox = findViewById(R.id.gesture_box);
        gestureLog = findViewById(R.id.gesture_log);

        setGestureListener();
        gestureBox.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mTextBoxGestureDetector.onTouchEvent(motionEvent);

                return false;
            }
        });





    }


    private TextView getTextView(String text){
        TextView textView = new TextView(MyGuestureDetectorSampleActivity.this);
        textView.setText(text);
        return textView;
    }

    //여기서 제스쳐를 정한다.
    private void setGestureListener() {

        GestureListenerInterface gestureListener = new GestureListenerInterface() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 한 번 눌렀다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 두 번 눌렀다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : on double tap 이벤트가 발생했다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
                return false;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 눌렀다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 조금 길게 눌렀다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 한 번 터치하고 떼었다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

                if(e1==null || e2==null) return false;

                if(e1.getY() > e2.getY()) {
                    gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 위로 스크롤했다!"));
                }else{
                    gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 아래로 스크롤했다!"));
                }
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.

                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 아주 길게 눌렀다!"));
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if(e1==null || e2==null) return false;

                if(e1.getY() > e2.getY()) {
                    gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 위로 튕겼다!"));
                }else{
                    gestureLog.addView(getTextView(MyCalendar.getInstance().getCurrentTime()+" : 아래로 튕겼다!"));
                }
                scroll.fullScroll(View.FOCUS_DOWN); //로그가 계속 보이도록 강제로 스크롤을 아래로 내림.

                    return false;
            }
        };


        MyGestureDetector myGestureDetector = new MyGestureDetector(gestureListener);
        mTextBoxGestureDetector = new GestureDetector(this, myGestureDetector);

    }
}
