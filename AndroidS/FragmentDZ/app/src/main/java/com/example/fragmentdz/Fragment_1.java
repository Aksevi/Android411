package com.example.fragmentdz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment_1 extends Fragment {

    View view; // переменная типа View куда будем помещать фрагмент. нужна чтобы можно было реализовать код внутри фрагмента. без нее будут все работать кроме кода

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_1, container, false);



        return view;
    }
}