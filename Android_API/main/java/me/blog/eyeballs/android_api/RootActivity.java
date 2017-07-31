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

}
