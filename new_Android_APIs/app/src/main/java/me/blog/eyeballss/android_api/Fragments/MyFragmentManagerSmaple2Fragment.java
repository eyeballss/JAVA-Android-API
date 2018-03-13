package me.blog.eyeballss.android_api.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.blog.eyeballss.android_api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentManagerSmaple2Fragment extends Fragment {

    private View view;
    public MyFragmentManagerSmaple2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_fragment_manager_smaple2, container, false);
        return view;
    }

    @Override
    public void onStart() {
        if(view==null) return;

        TextView text1 = view.findViewById(R.id.fragment_sample1_text);
        TextView text2 = view.findViewById(R.id.fragment_sample2_text);

        text1.setText("참");
        text2.setText("쉽죠잉");

        super.onStart();
    }
}
