package me.blog.eyeballss.android_api.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.blog.eyeballss.android_api.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentManagerSmaple1Fragment extends Fragment {

    private View view;
    public MyFragmentManagerSmaple1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_my_fragment_manager_smaple1, container, false);
        return view;
    }

}
