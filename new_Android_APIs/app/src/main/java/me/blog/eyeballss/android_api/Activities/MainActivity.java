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
}
