package me.blog.eyeballss.android_api.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.blog.eyeballss.android_api.R;

/**
 * Created by david on 18. 3. 8.
 */

public class MyCustomView extends RelativeLayout{

    private ImageView icon;
    private TextView infoText;
    private TextView descText;

    public MyCustomView(Context context) {
        super(context);
        init(context);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        getAttrs(attrs);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        getAttrs(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
        getAttrs(attrs, defStyleRes);
    }

    private void init(Context context) {
        String inflaterService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(inflaterService);
        layoutInflater.inflate(R.layout.customview_detail_page_more_info, MyCustomView.this);

        infoText = findViewById(R.id.info);
        descText = findViewById(R.id.desc);
        icon = findViewById(R.id.icon);
    }

    private void getAttrs(AttributeSet attrs, int defStyleRes){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyCustomViewStyleable, defStyleRes, 0);
        setTypeArray(typedArray);
    }

    private void getAttrs(AttributeSet attrs){
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,R.styleable.MyCustomViewStyleable);
        setTypeArray(typedArray);
    }

    private void setTypeArray(TypedArray typedArray) {
        //xml에서 app: .. 한 값을 여기서 가져온다.
        String infoTextStr = typedArray.getString(R.styleable.MyCustomViewStyleable_setInfoText);
        infoText.setText(infoTextStr);

        String descTextStr = typedArray.getString(R.styleable.MyCustomViewStyleable_setDescText);
        descText.setText(descTextStr);

        //앞의 파라미터는 xml에서 지정한 이미지, 뒤의 파라미터는 기본 이미지
        int iconImg = typedArray.getResourceId(R.styleable.MyCustomViewStyleable_setIcon, R.mipmap.ic_launcher_round);
        icon.setImageResource(iconImg);

        typedArray.recycle();
    }

    //public 인 이유는, 다른 activity에서 접근할 수 있도록 하기 위함.
    //즉, 코드로써 뷰에 속성을 제어할 때 아래의 메소드를 쓴다.
    public void setInfoText(String str){
        infoText.setText(str);
    }

    public String getInfoText(){
        return infoText.getText().toString();
    }

    public void setDescText(String str){
        descText.setText(str);
    }

    public String getDescText(){
        return descText.getText().toString();
    }

    public void setIcon(int img) {
        icon.setImageResource(img);
    }
}






