package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyLogger;

public class MyLoggerSampleActivity extends AppCompatActivity {

    EditText logMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_logger_sample);

        logMessage = (EditText) findViewById(R.id.log_message);
        MyLogger.getInstance().i(this, "MyLoggerr 는 이렇게 씁니다.");
    }

    public void showILog(View view){
        MyLogger.getInstance().i(this, logMessage.getText().toString());
    }


    public void showDLog(View view){
        MyLogger.getInstance().d(this, logMessage.getText().toString());
    }


    public void showELog(View view){
        MyLogger.getInstance().e(this, logMessage.getText().toString());
    }

    public void turnOn(View view){
        MyLogger.getInstance().setLogSwitch(true);
    }

    public void turnOff(View view){
        MyLogger.getInstance().setLogSwitch(false);
    }
}
