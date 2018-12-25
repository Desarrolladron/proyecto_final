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
        listItems.add(new lista((R.drawable.longitud), "Tabla Periódica"));
        listItems.add(new lista((R.drawable.cuboo), "Alfabeto Griego y Prefijos Importantes"));
        listItems.add(new lista((R.drawable.parabolic), "Calcular Área y Volúmenes"));

        listItems.add(new lista((R.drawable.parabolic), "Constantes Universales"));



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
            }
});

        return view;
    }

}
