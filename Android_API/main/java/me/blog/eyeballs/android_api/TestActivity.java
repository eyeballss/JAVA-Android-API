package me.blog.eyeballs.android_api;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends RootActivity {

    private EditText TestAct_input;
    private final String FILENAME = "FILENAME";
    private final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Utility.Log("TestActivity","이런 식으로 로그를 씁니다.");
        testPreference();
//        testDialog();
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

    //네트워크가  연결되어 있다면
    public void isNetworkAvailable(View view){
        int status = isNetworkConnected();
        String result=null;
        switch(status){
            case 0:
                result="Network is connected!";
                break;
            case 1:
                result="Network is connected with mobile data!";
                break;
            case 2:
                result="Network is connected with wifi!";
                break;
        }
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }


    private void testPreference() {
        TestAct_input = (EditText) findViewById(R.id.TestAct_input);
        String result = readStringPreferences(FILENAME, KEY);
        if(result != null){
            TestAct_input.setText(result);
            Toast.makeText(this, "불러왔습니다.", Toast.LENGTH_SHORT).show();
        }
    }
    public void saveData(View view){
        savePreferences(FILENAME, KEY, TestAct_input.getText().toString());
        Toast.makeText(this, "저장했습니다.", Toast.LENGTH_SHORT).show();
    }
    public void deleteData(View view){
        removeAllPreferences(FILENAME);
        Toast.makeText(this, "저장된 데이터를 모두 지웠습니다.", Toast.LENGTH_SHORT).show();
    }
}
