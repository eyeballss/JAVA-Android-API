package me.blog.eyeballss.android_api.Utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by david on 18. 3. 5.
 */

public class MyFragmentManager {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public MyFragmentManager(AppCompatActivity activity){
        fragmentManager = activity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    public void setFragment(int containerViewId, Fragment fragment){
        if(fragmentTransaction!=null) {
            fragmentTransaction.replace(containerViewId, fragment);
            fragmentTransaction.commit();
        }
        else {
            MyLogger.e(this, "fragmentTransaction가 없습니다. MyFragmentManager 인스턴스를 생성하세요.");
        }
    }
}
