package me.blog.eyeballss.android_api.Activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.RecyclerViews.GalleryRecyclerViewAdapter;
import me.blog.eyeballss.android_api.RecyclerViews.MyRecyclerViewManager;
import me.blog.eyeballss.android_api.Utils.MyLoader;

public class MyLoaderSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loader_sample);


        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            finish();
        }

        GalleryRecyclerViewAdapter mAdapter = new GalleryRecyclerViewAdapter(R.layout.my_loader_sample);
        RecyclerView mRecyclerView = new MyRecyclerViewManager(this).on(findViewById(R.id.recycler_view)).gridLayout(4).with(mAdapter);

        MyLoader myLoader = new MyLoader(this, mAdapter);
        myLoader.restart(getLoaderManager());

    }
}
