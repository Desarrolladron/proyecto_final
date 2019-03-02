package com.example.kevin.vale.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kevin.vale.ListView_primerFragment.CustomAdapter2;
import com.example.kevin.vale.ListView_primerFragment.lista;
import com.example.kevin.vale.R;
import com.example.kevin.vale.TercerFragmento.Prefijos;
import com.example.kevin.vale.TercerFragmento.constantes;
import com.example.kevin.vale.TercerFragmento.tablaPeriodica;
import com.example.kevin.vale.TercerFragmento.toxicidad;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TercerFragment extends Fragment {
    private ListView list;
    private CustomAdapter2 adaptador;

    public TercerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tercer, container, false);

        list = (ListView) view.findViewById(R.id.listaHerramientas);

        final ArrayList<lista> listItems = new ArrayList<>();
        listItems.add(new lista((R.drawable.presentation), getString(R.string.tabla_peri)));
        listItems.add(new lista((R.drawable.note), getString(R.string.alfabeto_griego)));
        listItems.add(new lista((R.drawable.notes), "Prefijos Importantes"));


        listItems.add(new lista((R.drawable.artboard), getString(R.string.constantes_universale)));
        listItems.add(new lista((R.drawable.cuboo), getString(R.string.calcular_area)+" (Proximamente)"));



        adaptador = new CustomAdapter2(getActivity(), listItems);

        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i == 0){
            Intent k = new Intent(getActivity(),tablaPeriodica.class);
            startActivity(k);
        }

        else if(i == 1){
            Intent k = new Intent(getActivity(),toxicidad.class);
            startActivity(k);
    }

        else if(i == 3){
            Intent k = new Intent(getActivity(),constantes.class);
            startActivity(k);
        }
        else if(i == 2){
            Intent k = new Intent(getActivity(), Prefijos.class);
            startActivity(k);
        }
            }
});

        return view;
    }

}
