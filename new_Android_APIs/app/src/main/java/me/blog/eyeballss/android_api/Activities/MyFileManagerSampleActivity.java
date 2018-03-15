package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.blog.eyeballss.android_api.R;
import me.blog.eyeballss.android_api.Utils.MyFileManager;

public class MyFileManagerSampleActivity extends AppCompatActivity {

    private final String TAG = "MY_FILE_MANAGER_SAMPLE";
    private EditText data;
    private Button save;
    private Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_file_manager_sample);

        data = findViewById(R.id.fileData);
        save = findViewById(R.id.saveButton);
        read = findViewById(R.id.readButton);

        assert data!=null;
        assert save!=null;
        assert read!=null;

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String saveData = data.getText().toString();
                assert saveData!=null;
                if(saveData==null || saveData.trim().length()==0){
                    Toast.makeText(MyFileManagerSampleActivity.this, "최소 한 글자 이상 입력하세요.", Toast.LENGTH_SHORT).show();
                }else{
                    String result = MyFileManager.getInstance().save(MyFileManagerSampleActivity.this, TAG, saveData);

                    String toast = "저장하는 동안 문제가 발생했습니다.";
                    if(result!=null) toast = result+" 에 저장되었습니다.";
                    Toast.makeText(MyFileManagerSampleActivity.this, toast, Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String readData = MyFileManager.getInstance().read(MyFileManagerSampleActivity.this, TAG);
                if(readData==null){
                    Toast.makeText(MyFileManagerSampleActivity.this, "저장된 데이터가 없습니다.", Toast.LENGTH_SHORT).show();
                }else {
                    data.setText(readData);
                    Toast.makeText(MyFileManagerSampleActivity.this, "불러왔습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
