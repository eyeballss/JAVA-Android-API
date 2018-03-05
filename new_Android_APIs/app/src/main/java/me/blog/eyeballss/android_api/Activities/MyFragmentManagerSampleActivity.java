package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.blog.eyeballss.android_api.Fragments.MyFragmentManagerSmapleFragment;
import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyFragmentManager;

public class MyFragmentManagerSampleActivity extends AppCompatActivity {

    private MyFragmentManager myFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment_manager_sample);

        myFragmentManager = new MyFragmentManager(this);
        MyFragmentManagerSmapleFragment fragment = new MyFragmentManagerSmapleFragment();
        myFragmentManager.setFragment(R.id.fragment_container, fragment);
    }
}
