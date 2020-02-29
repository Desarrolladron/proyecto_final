package com.formula.kevin.vale.juego;

import android.os.Bundle;
import androidx.annotation.Nullable;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.formula.kevin.vale.R;

/**
 * Created by AnshumanTripathi on 10/9/16.
 */

public class QuestionFragment extends Fragment {


    public QuestionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.question,container,false);
        return view;
    }

}
