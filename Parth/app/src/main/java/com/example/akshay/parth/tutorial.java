package com.example.akshay.parth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.example.akshay.parth.R.id.container;

/**
 * Created by akshay on 11/9/17.
 */

public class tutorial extends Fragment{

    public tutorial(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_tutorial,container,false);

return rootView;

    }

}



