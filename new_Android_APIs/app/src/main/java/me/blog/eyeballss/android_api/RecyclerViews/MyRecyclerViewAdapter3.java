package me.blog.eyeballss.android_api.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.blog.eyeballss.android_api.R;

/**
 * Created by eye on 18. 3. 12.
 */

public class MyRecyclerViewAdapter3 extends RecyclerView.Adapter<MyRecyclerViewAdapter3.ViewHolder> {
    private ArrayList<String> mDataset;
    private int resource;

    public void add(ArrayList<String> data){
        mDataset.addAll(data);
        notifyDataSetChanged();
    }

    public MyRecyclerViewAdapter3(int resource) {
        this.resource = resource;
        mDataset = new ArrayList<String>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));

        if(position%2==0){
            holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        }else{
            holder.mImageView.setImageResource(R.mipmap.ic_launcher_round);
        }

        if(position%3==0) {
            holder.mImageView.setBackgroundResource(R.color.black);
            holder.mTextView.setText("길\n어\n져\n라\n!");
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.textView3);
            mImageView = (ImageView) view.findViewById(R.id.imageView);
            mImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mImageView.setBackgroundResource(R.color.white);
        }
    }
}