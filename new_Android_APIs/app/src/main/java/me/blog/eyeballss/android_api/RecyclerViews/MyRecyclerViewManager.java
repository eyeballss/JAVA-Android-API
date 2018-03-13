package me.blog.eyeballss.android_api.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by eye on 18. 3. 12.
 */

public class MyRecyclerViewManager {
    private Context context;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    public MyRecyclerViewManager(Context context){
        this.context = context;
    }

    public MyRecyclerViewManager on(View view){
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setHasFixedSize(true);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerViewManager layout(int orientation){
        layout(orientation, false);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerViewManager layout(int orientation, boolean reverse){
        if(mRecyclerView==null) return null;
        mLayoutManager = new LinearLayoutManager(context, orientation, reverse);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return this;
    }

    public MyRecyclerViewManager with(RecyclerView.Adapter adapter){
        if(mRecyclerView==null || mLayoutManager==null) return null;
        mRecyclerView.setAdapter(adapter);
        return this;
    }
}