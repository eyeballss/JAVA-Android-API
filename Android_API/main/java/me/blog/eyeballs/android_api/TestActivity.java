package me.blog.eyeballs.android_api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends RootActivity {

    private EditText TestAct_input;
    private final String FILENAME = "FILENAME";
    private final String KEY = "KEY";

    private Vibrator vibrator;
    private EditText TestAct_duration;
    private EditText TestAct_even_duration;
    private EditText TestAct_odd_duration;
    private CheckBox TestAct_infinite;
    private Button startPatternVibrationButton;
    private Button stopVibrationButton;
    private Button startVibrationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Utility.Log("TestActivity","이런 식으로 로그를 씁니다.");
        testPreference();
        testVibration();
    }

    private void testVibration() {
        TestAct_duration = (EditText) findViewById(R.id.TestAct_duration);
        TestAct_even_duration = (EditText) findViewById(R.id.TestAct_even_duration);
        TestAct_odd_duration = (EditText) findViewById(R.id.TestAct_odd_duration);
        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        TestAct_infinite= (CheckBox) findViewById(R.id.TestAct_infinite);
        startPatternVibrationButton = (Button) findViewById(R.id.startPatternVibrationButton);
        startPatternVibrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 짝수 인덱스 : 대기시간
                // 홀수 인덱스 : 진동시간
                // 3회 이상 늘리고 싶다면 pattern 의 뒤에 값을 더 붙이면 된다.
                int odd =1, even=1;
                try{
                    odd = Integer.parseInt(TestAct_odd_duration.getText().toString()) * 1000;
                    even = Integer.parseInt(TestAct_even_duration.getText().toString()) * 1000;
                }catch(NumberFormatException e){return;}

                //infi가 0이면 무한 반복. -1이면 반복 없음. 양의 정수라면 패턴의 해당 인덱스부터 무한 반복.
                int infi=-1;
                if(TestAct_infinite.isChecked()) infi=0;
                else infi=-2;

                startPatternVibration(odd,even,infi);
            }
        });
        stopVibrationButton = (Button) findViewById(R.id.stopVibrationButton);
        stopVibrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopVibration();
            }
        });
        startVibrationButton = (Button) findViewById(R.id.startVibrationButton);
        startVibrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int duration = 1;
                try{
                    duration = Integer.parseInt(TestAct_duration.getText().toString());
                }catch(NumberFormatException e){return;}
                startVibration(duration);
            }
        });
    }

    public void startVibration(int duration){
        if(vibrator==null) return;
        vibrator.vibrate(1000*duration);
    }

    public void startPatternVibration(int odd, int even, int infi){
        if(vibrator==null) return;

        // 짝수 인덱스 : 대기시간
        // 홀수 인덱스 : 진동시간
        // 3회 이상 늘리고 싶다면 pattern 의 뒤에 값을 더 붙이면 된다.
        long[] pattern = {even,odd,even,odd,even,odd};
        vibrator.vibrate(pattern, infi);

    }

    public void stopVibration(){
        if(vibrator==null) return;
        vibrator.cancel();
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

    public void onGPSTest(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
