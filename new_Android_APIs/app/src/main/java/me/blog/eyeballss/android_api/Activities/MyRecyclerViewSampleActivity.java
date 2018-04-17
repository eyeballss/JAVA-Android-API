package me.blog.eyeballss.android_api.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewAdapter;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewAdapter2;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewAdapter3;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewManager;
import me.blog.eyeballss.android_api.RecyclerViews.SimpleSectionedRecyclerViewAdapter;


public class MyRecyclerViewSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view_sample);

        setRecyclerViewSample();
        setRecyclerViewSample2();
        setRecyclerViewSample3();

    }


    private void setRecyclerViewSample() {

        RecyclerView recyclerViewSample = findViewById(R.id.my_recycler_view);
        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<30; i++){
            data.add("김개똥");
            data.add("스누피");
            data.add("눈가락");
        }
        MyRecyclerViewAdapter mAdapter = new MyRecyclerViewAdapter(R.layout.my_recycler_view_sample_layout);
        mAdapter.add(data);


        //세션을 위한 리사이클러뷰 세팅
        List<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<>();
        //세션들을 넣음.
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"1등부터 10등까지 명단"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(10,"그 외"));

        //세션 어댑터를 만들고 세션에 표시될 레이아웃을 세팅함.
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];

        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(this, R.layout.my_recycler_view_sample_section_cell, R.id.textView, mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));


        recyclerViewSample = new MyRecyclerViewManager(this).on(recyclerViewSample).linearLayout(1).with(mAdapter);
        //세션 어댑터를 다시 장착
        recyclerViewSample.setAdapter(mSectionedAdapter);

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
        recyclerViewSample = new MyRecyclerViewManager(this).on(recyclerViewSample).gridLayout(5).with(mAdapter);
        mAdapter.add(data);
    }


    private void setRecyclerViewSample3() {
        RecyclerView recyclerViewSample = findViewById(R.id.my_recycler_view3);
        ArrayList<String> data = new ArrayList<String>();

        for(int i=0; i<30; i++){
            data.add("");
            data.add("검은 바탕 이미지를");
            data.add("클릭해보세요");
        }

        MyRecyclerViewAdapter3 mAdapter = new MyRecyclerViewAdapter3(R.layout.my_recycler_view_sample_layout3);
        mAdapter.setRecyclerView(recyclerViewSample);
        recyclerViewSample = new MyRecyclerViewManager(this).on(recyclerViewSample).staggeredGridLayout(3).with(mAdapter);
        mAdapter.add(data);
    }
}