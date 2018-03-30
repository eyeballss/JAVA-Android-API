package me.blog.eyeballss.android_api.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.blog.eyeballss.android_api.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myFragmentManager(View view){
        startActivity(new Intent(this, MyFragmentManagerSampleActivity.class));
    }

    public void myLogger(View view) {
        startActivity(new Intent(this, MyLoggerSampleActivity.class));
    }

    public void myCalendar(View view) {
        startActivity(new Intent(this, MyCalendarSampleActivity.class));
    }

    public void myRecyclerView(View view) {
        startActivity(new Intent(this, MyRecyclerViewSampleActivity.class));
    }

    public void myCustomView(View view){
        startActivity(new Intent(this, MyCustomViewSampleActivity.class));
    }

    public void myDataPasser(View view){
        startActivity(new Intent(this, MyDataPasserSenderSampleActivity.class));
    }

    public void myFileManager(View view){
        startActivity(new Intent(this, MyFileManagerSampleActivity.class));
    }

    public void myLoader(View view){
        startActivity(new Intent(this, MyLoaderSampleActivity.class));
    }

    public void myCamera(View view){
        startActivity(new Intent(this, MyCameraSampleActivity.class));
    }

    public void myViewPager(View view){
        startActivity(new Intent(this, MyViewPagerSampleActivity.class));
    }

    public void myMap(View view){
        startActivity(new Intent(this, MyMapSampleActivity.class));
    }
}
