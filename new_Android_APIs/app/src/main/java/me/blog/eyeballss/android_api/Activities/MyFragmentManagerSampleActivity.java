package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.blog.eyeballss.android_api.Fragments.MyFragmentManagerSmaple1Fragment;
import me.blog.eyeballss.android_api.Fragments.MyFragmentManagerSmaple2Fragment;
import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyFragmentManager;

public class MyFragmentManagerSampleActivity extends AppCompatActivity {

    private MyFragmentManager myFragmentManagerSample1;
    private MyFragmentManager myFragmentManagerSample2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment_manager_sample);

        myFragmentManagerSample1 = new MyFragmentManager(this);
        MyFragmentManagerSmaple1Fragment fragmentSample1 = new MyFragmentManagerSmaple1Fragment();
        myFragmentManagerSample1.setFragment(R.id.fragment_sample1_container, fragmentSample1);

        myFragmentManagerSample2 = new MyFragmentManager(this);
        MyFragmentManagerSmaple2Fragment fragmentSample2 = new MyFragmentManagerSmaple2Fragment();
        myFragmentManagerSample2.setFragment(R.id.fragment_sample2_container, fragmentSample2);
    }
}
