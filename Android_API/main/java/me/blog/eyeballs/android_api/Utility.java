package me.blog.eyeballs.android_api;

import android.util.Log;

/**
 * Created by eye on 17. 7. 18.
 */

public class Utility {
    private static final Utility ourInstance = new Utility();
    static Utility getInstance() {
        return ourInstance;
    }
    private Utility() {}

    public static void Log(String key, String value) {
        Log.d(key, "-----------------------------------------------------------------------------");
        Log.d(key, value);
        Log.d(key, "-----------------------------------------------------------------------------");
    }
}
