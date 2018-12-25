package com.example.kevin.vale.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.kevin.vale.ListView_primerFragment.Menu_Matematicas;
import com.example.kevin.vale.R;
import com.example.kevin.vale.Ventanas_menú.Calculo_Activity;
import com.example.kevin.vale.Ventanas_menú.Fisica_Activity;
import com.example.kevin.vale.Ventanas_menú.MateActivity;
import com.example.kevin.vale.Ventanas_menú.Quimica_Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrimerFragment extends Fragment {

    GridLayout mainGri;
    ImageButton btn1;
    ImageButton btn2;
    ImageButton btn3;
    ImageButton btn4;
    public PrimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_primer, container, false);
        mainGri = (GridLayout)view.findViewById(R.id.mainGrid);
        btn1 = (ImageButton)view.findViewById(R.id.btn_mate);
        btn2 = (ImageButton)view.findViewById(R.id.btn_quimica);
        btn3 = (ImageButton)view.findViewById(R.id.btn_calculo);
        btn4 = (ImageButton)view.findViewById(R.id.btn_fisica);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Menu_Matematicas.class);
                getActivity().startActivity(intent);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Quimica_Activity.class);
                getActivity().startActivity(intent);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Calculo_Activity.class);
                getActivity().startActivity(intent);
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Fisica_Activity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;



        }
        }
