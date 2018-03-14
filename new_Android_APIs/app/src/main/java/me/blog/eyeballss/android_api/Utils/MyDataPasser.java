package me.blog.eyeballss.android_api.Utils;

import java.util.HashMap;

/**
 * Created by david on 18. 3. 7.
 */

public class MyDataPasser {
    public final static String MY_DATA_PASSER_SAMPLE = "MY_DATA_PASSER_SAMPLE";

    private static final MyDataPasser ourInstance = new MyDataPasser();
    private HashMap<String, Object> dataMap;

    public static MyDataPasser getInstance() {
        return ourInstance;
    }

    private MyDataPasser() {
        dataMap = new HashMap<String, Object>();
    }

    public boolean setData(String key, Object data) {
        if (dataMap.containsKey(key)) return false;

        dataMap.put(key, data);
        return true;
    }

    public Object getData(String key) {
        Object temp = dataMap.get(key);
        dataMap.remove(key);
        return temp;
    }
}
