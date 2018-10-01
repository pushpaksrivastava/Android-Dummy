package com.example.pushpaksrivastava.slideapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pushpaksrivastava.slideapp.R;

/**
 * Created by Pushpak Srivastava on 08-07-2017.
 */
public class FragCalls extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragcall, container, false);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
