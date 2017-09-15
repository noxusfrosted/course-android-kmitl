package com.example.student.lab05_workshop1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    String msg="";

    public static BlankFragment newInstance(String msg) {

        Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
        args.putString("msg", msg);
        fragment.setArguments(args);
        return fragment;
    }
    public BlankFragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        msg = getArguments().getString("msg");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_blank, container, false);
        TextView fragmentTextView = (TextView) rootView.findViewById(R.id.fragmentTextView);

        if(!msg.isEmpty()){
            fragmentTextView.setText(msg);
        }


        return rootView;
    }


}
