package me.blog.eyeballss.android_api.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerView;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerView2;

public class MyRecyclerViewSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view_sample);

        setRecyclerViewSample();
        setRecyclerViewSample2();

    }

    private void setRecyclerViewSample2() {
        RecyclerView recyclerViewSample2 = (RecyclerView) findViewById(R.id.my_recycler_view2);
        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<30; i++){
            data.add("이것은");
            data.add("샘플");
            data.add("입니다");
        }

        MyRecyclerView2 myRecyclerView = new MyRecyclerView2(this).on(recyclerViewSample2).layout(0, true).with(R.layout.my_recycler_view_sample_layout2);
        myRecyclerView.add(data);
    }

    private void setRecyclerViewSample() {

        RecyclerView recyclerViewSample = (RecyclerView) findViewById(R.id.my_recycler_view);
        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<30; i++){
            data.add("이것은");
            data.add("샘플");
            data.add("입니다");
        }

        MyRecyclerView myRecyclerView = new MyRecyclerView(this).on(recyclerViewSample).layout(1).with(R.layout.my_recycler_view_sample_layout);
        myRecyclerView.add(data);
    }
}
