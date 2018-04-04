package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.blog.eyeballss.android_api.Interfaces.MyDialogInterface;
import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyDialog;

public class MyDialogSampleActivity extends AppCompatActivity implements MyDialogInterface{

    private EditText title, content, okay, cancel;
    private Button type1, type2, type3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog_sample);

        title = findViewById(R.id.dialog_title);
        content = findViewById(R.id.dialog_content);
        okay = findViewById(R.id.dialog_okay);
        cancel = findViewById(R.id.dialog_cancel);

        type1 = findViewById(R.id.dialog_type1);
        type2 = findViewById(R.id.dialog_type2);
        type3 = findViewById(R.id.dialog_type3);


        type1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleStr = title.getText().toString();
                String contentStr = content.getText().toString();
                MyDialog.show(MyDialogSampleActivity.this, titleStr, contentStr);
            }
        });

        type2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleStr = title.getText().toString();
                String contentStr = content.getText().toString();
                String okayStr = okay.getText().toString();
                MyDialog.show(MyDialogSampleActivity.this, MyDialogSampleActivity.this, titleStr, contentStr, okayStr, null);
            }
        });

        type3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleStr = title.getText().toString();
                String contentStr = content.getText().toString();
                String okayStr = okay.getText().toString();
                String cancelStr = cancel.getText().toString();
                MyDialog.show(MyDialogSampleActivity.this, MyDialogSampleActivity.this, titleStr, contentStr, okayStr, cancelStr);
            }
        });
    }

    @Override
    public void okay() {
        Toast.makeText(this, "okay 누름", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cancel() {
        Toast.makeText(this, "cancel 누름", Toast.LENGTH_SHORT).show();
    }
}
