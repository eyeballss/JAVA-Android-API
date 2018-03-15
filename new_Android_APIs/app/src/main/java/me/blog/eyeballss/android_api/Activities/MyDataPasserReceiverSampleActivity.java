package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.blog.eyeballss.android_api.Models.MyDataPasserModel;
import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyDataPasser;

public class MyDataPasserReceiverSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data_passer_receiver_sample);

        MyDataPasserModel result = (MyDataPasserModel) MyDataPasser.getInstance().getData(MyDataPasser.MY_DATA_PASSER_SAMPLE);
        if(result==null) return;

        TextView data = findViewById(R.id.data);
        TextView data_size = findViewById(R.id.data_size);
        TextView divide_data = findViewById(R.id.divide_data);
        TextView middle_of_data = findViewById(R.id.middle_of_data);

        setData(data, result);
        setDataSize(data_size, result);
        setDivideData(divide_data, result);
        setMiddleOfData(middle_of_data, result);
    }

    private void setData(TextView view, MyDataPasserModel result) {
        view.setText(result.getStringValue());
    }

    private void setDataSize(TextView view, MyDataPasserModel result) {
        int size = result.getIntegerValue();
        view.setText(String.valueOf(size));
    }

    private void setDivideData(TextView view, MyDataPasserModel result) {
        double value = result.getDoubleValue();
        view.setText(String.valueOf(value));
    }

    private void setMiddleOfData(TextView view, MyDataPasserModel result) {
        char[] array = result.getCharValue();
        int middle = array.length/2;
        view.setText(String.valueOf(array[middle]));
    }
}
