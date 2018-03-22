package me.blog.eyeballss.android_api.Utils;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import me.blog.eyeballss.android_api.RecyclerViews.GalleryRecyclerViewAdapter;


/**
 * Created by david on 18. 3. 22.
 */

public class MyLoader implements LoaderManager.LoaderCallbacks<Cursor>{

    private Context context;
    private GalleryRecyclerViewAdapter mAdapter;
    private static final int URL_LOADER = 0;

    private static final Uri uri = MediaStore.Files.getContentUri("external");
    private static final String selection = MediaStore.Files.FileColumns.MEDIA_TYPE + "="
            + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE
            + " OR "
            + MediaStore.Files.FileColumns.MEDIA_TYPE + "="
            + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO;
    private static final String sortOrder = MediaStore.Files.FileColumns.DATA + " DESC";
    public static String[] projections =
            {
                    MediaStore.Files.FileColumns._ID,
                    MediaStore.Files.FileColumns.DATA,
                    MediaStore.Files.FileColumns.MEDIA_TYPE
            };

    public MyLoader(Context context, GalleryRecyclerViewAdapter mAdapter){
        this.context = context;
        this.mAdapter = mAdapter;
    }

    public void restart(LoaderManager loaderManager){
        loaderManager.restartLoader(URL_LOADER, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(context,
                uri,
                projections,
                selection,
                null,
                sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.setData(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
