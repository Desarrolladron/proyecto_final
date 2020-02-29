package com.formula.kevin.vale.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.formula.kevin.vale.ListView_primerFragment.Menu_Matematicas;
import com.formula.kevin.vale.R;
import com.formula.kevin.vale.Ventanas_menú.Calculo_Activity;
import com.formula.kevin.vale.Ventanas_menú.Fisica_Activity;
import com.formula.kevin.vale.Ventanas_menú.Quimica_Activity;


public class Fragment_Kitkat extends Fragment {
    Button boton1,boton2,boton3,boton4;

    public Fragment_Kitkat() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_fragment__kitkat, container, false);
        boton1 = (Button)view.findViewById(R.id.mate1);
        boton2 = (Button)view.findViewById(R.id.fisica1);
        boton3 = (Button)view.findViewById(R.id.calculo1);
        boton4 = (Button)view.findViewById(R.id.quimica1);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Menu_Matematicas.class);
                getActivity().startActivity(intent);


            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Quimica_Activity.class);
                getActivity().startActivity(intent);

            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Calculo_Activity.class);
                getActivity().startActivity(intent);
            }
        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Fisica_Activity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }


}
