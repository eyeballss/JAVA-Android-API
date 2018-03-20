package me.blog.eyeballss.android_api.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by eye on 18. 3. 12.
 */

public class MyRecyclerViewManager {
    private Context context;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private StaggeredGridLayoutManager mStaggeredGridLayout;

    public MyRecyclerViewManager(Context context){
        this.context = context;
    }

    public MyRecyclerViewManager on(View view){
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setHasFixedSize(true);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerViewManager linearLayout(int orientation){
        linearLayout(orientation, false);
        return this;
    }

    //H : 0 V : 1
    public MyRecyclerViewManager linearLayout(int orientation, boolean reverse){
        if(mRecyclerView==null) return null;
        mLinearLayoutManager = new LinearLayoutManager(context, orientation, reverse);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        return this;
    }


    public MyRecyclerViewManager gridLayout(int num){
        if(mRecyclerView==null) return null;
        mGridLayoutManager = new GridLayoutManager(context, num);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        return this;
    }

    public MyRecyclerViewManager staggeredGridLayout(int num){
        return staggeredGridLayout(num, 1);
    }

    //H : 0 V : 1
    public MyRecyclerViewManager staggeredGridLayout(int num, int orientation){
        if(mRecyclerView==null) return null;
        mStaggeredGridLayout = new StaggeredGridLayoutManager(num, orientation);
        mRecyclerView.setLayoutManager(mStaggeredGridLayout);
        return this;
    }


    public RecyclerView with(RecyclerView.Adapter adapter){
        if(mRecyclerView==null) return null;
        if(mLinearLayoutManager ==null && mGridLayoutManager ==null && mStaggeredGridLayout ==null) return null;

        mRecyclerView.setAdapter(adapter);
        return this.mRecyclerView;
    }
}