package me.blog.eyeballss.android_api.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import me.blog.eyeballss.android_api.CustomViews.MyCustomView;
import me.blog.eyeballss.android_api.R;

public class MyCustomViewSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view_sample);

        MyCustomView myCustomView = findViewById(R.id.custom_View);
        String info = myCustomView.getInfoText().toString();
        String desc = myCustomView.getDescText().toString();

        myCustomView.setInfoText(info+" "+desc);
        myCustomView.setDescText("그리고 코드에서도 바꿨습니다. 아이콘을 눌러보세요.");
        myCustomView.setIcon(R.mipmap.ic_launcher_round);

        ImageView iconView = myCustomView.getIconView();
        iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyCustomViewSampleActivity.this, "아이콘을 누르셨네요!", Toast.LENGTH_SHORT).show();
            }
        });

        /*

        커스텀뷰를 위해 만든 것들:

        CustomViews.MyCustomView.java
        res.layout.customview_detail_page_more_info.xml
        res.values.attrs.xml

         */

    }
}
