package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewManager;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewAdapter;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewAdapter2;


public class MyRecyclerViewSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view_sample);

        setRecyclerViewSample();
        setRecyclerViewSample2();

    }

    private void setRecyclerViewSample2() {
        RecyclerView recyclerViewSample = findViewById(R.id.my_recycler_view2);
        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<30; i++){
            data.add("이것은");
            data.add("샘플");
            data.add("입니다");
        }

        MyRecyclerViewAdapter2 mAdapter = new MyRecyclerViewAdapter2(R.layout.my_recycler_view_sample_layout2);
        MyRecyclerViewManager myRecyclerView = new MyRecyclerViewManager(this).on(recyclerViewSample).layout(0, true).with(mAdapter);
        mAdapter.add(data);
    }

    private void setRecyclerViewSample() {

        RecyclerView recyclerViewSample = findViewById(R.id.my_recycler_view);
        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<30; i++){
            data.add("이것은");
            data.add("샘플");
            data.add("입니다");
        }

        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(R.layout.my_recycler_view_sample_layout);
        MyRecyclerViewManager myRecyclerView = new MyRecyclerViewManager(this).on(recyclerViewSample).layout(1).with(mAdapter);
        mAdapter.add(data);
    }
}