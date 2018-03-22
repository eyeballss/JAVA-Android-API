package me.blog.eyeballss.android_api.RecyclerViews;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import me.blog.eyeballss.android_api.R;

import static me.blog.eyeballss.android_api.Utils.MyLoader.projections;


/**
 * Created by david on 18. 3. 5.
 */

public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> images;
    private int resource;

    public void setData(Cursor data){

        while(data.moveToNext()){
            String imagePath = data.getString(data.getColumnIndex(projections[1]));
            if(!images.contains(imagePath)){
                images.add(imagePath);
            }
        }

        notifyDataSetChanged();
    }

    public GalleryRecyclerViewAdapter(int resource) {
        this.resource = resource;
        images= new ArrayList<String>();
    }

    @Override
    public GalleryRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.text.setText(cursor.get(position));

        RequestOptions options = new RequestOptions().centerCrop();
        Glide.with(holder.img.getContext()).load(images.get(position)).apply(options).into(holder.img);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.gallery_cell_img);
        }

    }
}