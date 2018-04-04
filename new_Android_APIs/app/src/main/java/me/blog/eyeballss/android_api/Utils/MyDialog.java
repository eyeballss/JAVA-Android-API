package me.blog.eyeballss.android_api.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;

import me.blog.eyeballss.android_api.Interfaces.MyDialogInterface;


/**
 * Created by david on 18. 4. 3.
 */

public class MyDialog {

    public static void show(Context context, String title, String message){
        show(context, null, title, message, null, null);
    }

    public static void show(Context context, final MyDialogInterface myDialogInterface, String title, String message, String okay, String cancel){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if(title!=null) builder.setTitle(title);
        if(message!=null) builder.setMessage(message);

        if(myDialogInterface!=null && okay!=null){
            if(TextUtils.isEmpty(okay)) okay="okay";
            builder.setPositiveButton(okay, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    myDialogInterface.okay();
                }
            });
        }

        if(myDialogInterface!=null && cancel!=null){
            if(TextUtils.isEmpty(cancel)) cancel="cancel";
            builder.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    myDialogInterface.cancel();
                }
            });
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
