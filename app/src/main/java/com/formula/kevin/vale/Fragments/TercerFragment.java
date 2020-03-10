package com.formula.kevin.vale.Fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.formula.kevin.vale.Activitis.MainActivity;
import com.formula.kevin.vale.AreayVolumen.Principales;
import com.formula.kevin.vale.ListView_primerFragment.CustomAdapter2;
import com.formula.kevin.vale.ListView_primerFragment.lista;
import com.formula.kevin.vale.R;
import com.formula.kevin.vale.TercerFragmento.Prefijos;
import com.formula.kevin.vale.TercerFragmento.constantes;
import com.formula.kevin.vale.TercerFragmento.glosario_matematico;
import com.formula.kevin.vale.TercerFragmento.tablaPeriodica;
import com.formula.kevin.vale.TercerFragmento.tabla_equivalencia;
import com.formula.kevin.vale.TercerFragmento.toxicidad;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TercerFragment extends Fragment {
    private ListView list;
    private CustomAdapter2 adaptador;
    private InterstitialAd mInterstitialAd;

    public TercerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tercer, container, false);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/3391564183");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        //ca-app-pub-3940256099942544/1033173712  prueba
        list = (ListView) view.findViewById(R.id.listaHerramientas);

        final ArrayList<lista> listItems = new ArrayList<>();
        listItems.add(new lista((R.drawable.presentation), getString(R.string.tabla_peri)));
        listItems.add(new lista((R.drawable.note), getString(R.string.alfabeto_griego)));
        listItems.add(new lista((R.drawable.notes), getString(R.string.prefijos)));


        listItems.add(new lista((R.drawable.artboard), getString(R.string.constantes_universale)));
        listItems.add(new lista((R.drawable.cuboo), getString(R.string.calcular_area)));
        listItems.add(new lista((R.drawable.note), getString(R.string.terminos_matematicos)));
        listItems.add(new lista((R.drawable.presentation), "Tabla de Equivalencias"));

        adaptador = new CustomAdapter2(getActivity(), listItems);

        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MainActivity main = new MainActivity();
        if(i == 0){
            Intent k = new Intent(getActivity(),tablaPeriodica.class);
                startActivity(k);

        }


    else if(i == 1){
            Intent k = new Intent(getActivity(),toxicidad.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }            startActivity(k);

        }
        else if(i == 6) {
            Intent k = new Intent(getActivity(), tabla_equivalencia.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            startActivity(k);
        }
        else if(i == 4) {
            Intent k = new Intent(getActivity(), Principales.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            startActivity(k);
        }
        else if(i == 5){
            Intent k = new Intent(getActivity(), glosario_matematico.class);
            startActivity(k);

        }

        else if(i == 3){
            Intent k = new Intent(getActivity(),constantes.class);
            startActivity(k);

        }
        else if(i == 2){

            Intent k = new Intent(getActivity(), Prefijos.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }

            else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            startActivity(k);

        }

            }
});



        return view;
    }

}
