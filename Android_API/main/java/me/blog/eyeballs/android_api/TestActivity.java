package me.blog.eyeballs.android_api;

import android.os.Bundle;
import android.os.Handler;

public class TestActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Utility.Log("TestActivity","이런 식으로 로그를 씁니다.");
        testDialog();
    }


    //로딩을 2초간 보여준 후 에러 메세지를 띄운다.
    private void testDialog(){
        showPD("loading...");
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                stopPD();
                showErrorDialog("Error!!", "This is an error message.");
            }
        }, 2000);

    }
}
