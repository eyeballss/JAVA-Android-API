package me.blog.eyeballss.android_api.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import me.blog.eyeballss.android_api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyViewPagerSample3Fragment extends Fragment {


    public MyViewPagerSample3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_view_pager_sample3, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        TextView firstText = view.findViewById(R.id.viewpager_third_text);
        firstText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "세번째 눌렀습니다!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
