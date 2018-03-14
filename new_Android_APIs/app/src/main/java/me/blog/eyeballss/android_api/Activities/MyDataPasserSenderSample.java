package me.blog.eyeballss.android_api.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import me.blog.eyeballss.android_api.Models.MyDataPasserModel;
import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyDataPasser;
import me.blog.eyeballss.android_api.Utils.MyLogger;

public class MyDataPasserSenderSample extends AppCompatActivity {

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_passer_sender_sample);

        input = findViewById(R.id.input);
        Button send = findViewById(R.id.input_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDataPasserModel data = getData(input.getText().toString());
                if(data!=null){
                    MyDataPasser.getInstance().setData(MyDataPasser.MY_DATA_PASSER_SAMPLE, data);
                    startActivity(new Intent(MyDataPasserSenderSample.this, MyDataPasserReceiverSample.class));
                }
            }
        });

    }

    private MyDataPasserModel getData(String data){
        if(data.trim().length()==0) {
            Toast.makeText(this, "최소 한 글자 이상 입력하세요.", Toast.LENGTH_SHORT).show();
            return null;
        }

        try{
            //string
            MyDataPasserModel model = new MyDataPasserModel();
            model.setStringValue(data);

            //integer
            int leng = data.length();
            model.setIntegerValue(leng);

            //double
            double div = (double)leng/ 7.0;
            model.setDoubleValue(div);

            //char[]
            model.setCharValue(data.toCharArray());
            return model;
        }catch(Exception e){
            MyLogger.getInstance().e(this, "MyDataPasserModel 값을 채우는 데 에러가 났습니다.");
            return null;
        }
    }
}
