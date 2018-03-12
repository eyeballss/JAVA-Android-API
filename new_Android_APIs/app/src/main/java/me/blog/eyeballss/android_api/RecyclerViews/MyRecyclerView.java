package me.blog.eyeballss.android_api.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by eye on 18. 3. 12.
 */

public class MyRecyclerView {
    private Context context;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyRecyclerViewAdapter mAdapter;

    public MyRecyclerView(Context context){
        this.context = context;
    }

    public MyRecyclerView on(View view){
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setHasFixedSize(true);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerView layout(int orientation){
        layout(orientation, false);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerView layout(int orientation, boolean reverse){
        if(mRecyclerView==null) return null;
        mLayoutManager = new LinearLayoutManager(context, orientation, reverse);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return this;
    }

    public void add(ArrayList<String> data){
        mAdapter.add(data);
    }

    public MyRecyclerView with(int resource){
        if(mRecyclerView==null || mLayoutManager==null) return null;

        mAdapter = new MyRecyclerViewAdapter(resource);
        mRecyclerView.setAdapter(mAdapter);
        return this;
    }
}