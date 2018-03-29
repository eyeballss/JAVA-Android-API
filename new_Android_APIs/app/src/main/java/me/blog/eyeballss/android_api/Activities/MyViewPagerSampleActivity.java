package me.blog.eyeballss.android_api.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import me.blog.eyeballss.android_api.Fragments.MyViewPagerSample1Fragment;
import me.blog.eyeballss.android_api.Fragments.MyViewPagerSample2Fragment;
import me.blog.eyeballss.android_api.Fragments.MyViewPagerSample3Fragment;
import me.blog.eyeballss.android_api.R;

public class MyViewPagerSampleActivity extends AppCompatActivity {

    public static final int MAX = 3;

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private Button mLeft, mRight, mGo;
    private EditText mNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_pager_sample);


        //대문 뷰페이저
        mViewPager = findViewById(R.id.viewpager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mLeft = findViewById(R.id.viewpager_left);
        mRight = findViewById(R.id.viewpager_right);
        mGo = findViewById(R.id.viewpager_go);
        mNum = findViewById(R.id.viewpager_num);

        mLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int go = mViewPager.getCurrentItem()-1;
                if(go<0) go=MAX;

                mViewPager.setCurrentItem(go);
            }
        });

        mRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int go = mViewPager.getCurrentItem()+1;
                if(go>=MAX) go=0;

                mViewPager.setCurrentItem(go);
            }
        });

        mGo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int go =0 ;
                try {
                    go = Integer.valueOf(mNum.getText().toString())-1;
                } catch (Exception e) {
                }

                if(go<0 || go>=MAX) return;

                mViewPager.setCurrentItem(go);
            }
        });

    }



    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            switch(position){
                case 0:{
                    fragment = new MyViewPagerSample1Fragment();
                    break;
                }
                case 1:{
                    fragment = new MyViewPagerSample2Fragment();
                    break;
                }
                case 2:{
                    fragment = new MyViewPagerSample3Fragment();
                    break;
                }
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return MAX;
        }
    }
}
