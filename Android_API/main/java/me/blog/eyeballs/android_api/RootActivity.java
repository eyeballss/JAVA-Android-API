package me.blog.eyeballs.android_api;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;

import java.util.Set;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by eye on 17. 7. 18.
 */

public class RootActivity extends AppCompatActivity {

    //Dialog-------------------------------------------------------
    private SweetAlertDialog pDialog;
    protected void showPD(String msg)
    {
        if( pDialog  == null ){
            pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
            pDialog .setCancelable(false); // 임의 취소 불가
            pDialog .setTitleText(msg);
        }
        pDialog.show();
    }

    protected void stopPD(){
        if( pDialog  != null && pDialog .isShowing() ){
            pDialog.dismiss();
        }
    }

    protected void showErrorDialog(String msg){
        showErrorDialog("ERROR", msg);
    }

    protected void showErrorDialog(String title, String msg){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(msg)
                .show();
    }

    //네트워크 연결 확인
    protected int isNetworkConnected(){
        int isConnected = 0;

        ConnectivityManager manager =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobile = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mobile.isConnected()){
            isConnected = 1;
        }else if(wifi.isConnected()){
            isConnected = 2;
        }else{
            isConnected = 0;
        }
        return isConnected;
    }



    //SharedPreferences 메소드들
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    protected  void savePreferences(String fileName, String key, String value){
        initPreferences(fileName);
        editor.putString(key, value);
        editor.commit();
    }
    protected  void savePreferences(String fileName, String key, boolean value){
        initPreferences(fileName);
        editor.putBoolean(key, value);
        editor.commit();
    }
    protected  void savePreferences(String fileName, String key, int value){
        initPreferences(fileName);
        editor.putInt(key, value);
        editor.commit();
    }
    protected  void savePreferences(String fileName, String key, float value){
        initPreferences(fileName);
        editor.putFloat(key, value);
        editor.commit();
    }
    protected  void savePreferences(String fileName, String key, long value){
        initPreferences(fileName);
        editor.putLong(key, value);
        editor.commit();
    }
    protected  void savePreferences(String fileName, String key, Set<String> value){
        initPreferences(fileName);
        editor.putStringSet(key, value);
        editor.commit();
    }

    protected String readStringPreferences(String fileName, String key){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        return preferences.getString(key, null);
    }
    protected int readIntPreferences(String fileName, String key){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        return preferences.getInt(key, 0);
    }
    protected boolean readBooleanPreferences(String fileName, String key){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
    protected float readFloatPreferences(String fileName, String key){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        return preferences.getFloat(key, 0.0f);
    }
    protected long readLongPreferences(String fileName, String key){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        return preferences.getLong(key, 0);
    }
    public  Set<String> readStingSetPreferences(String fileName, String key){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        return preferences.getStringSet(key, null);
    }

    protected void removeAllPreferences(String fileName){
        initPreferences(fileName);
        editor.clear();
        editor.commit();
    }

    protected void removePreferences(String fileName, String key){
        initPreferences(fileName);
        editor.remove(key);
        editor.commit();
    }

    private void initPreferences(String fileName){
        preferences = getSharedPreferences(fileName, MODE_PRIVATE);
        editor = preferences.edit();
    }
}
