package me.blog.eyeballss.android_api.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by eye on 18. 3. 12.
 */

public class MyRecyclerView2 {
    private Context context;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyRecyclerViewAdapter2 mAdapter;

    public MyRecyclerView2(Context context){
        this.context = context;
    }

    public MyRecyclerView2 on(View view){
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setHasFixedSize(true);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerView2 layout(int orientation){
        layout(orientation, false);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerView2 layout(int orientation, boolean reverse){
        if(mRecyclerView==null) return null;
        mLayoutManager = new LinearLayoutManager(context, orientation, reverse);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return this;
    }

    public void add(ArrayList<String> data){
        mAdapter.add(data);
    }

    public MyRecyclerView2 with(int resource){
        if(mRecyclerView==null || mLayoutManager==null) return null;

        mAdapter = new MyRecyclerViewAdapter2(resource);
        mRecyclerView.setAdapter(mAdapter);
        return this;
    }
}