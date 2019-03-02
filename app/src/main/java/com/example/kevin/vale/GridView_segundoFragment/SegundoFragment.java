package com.example.kevin.vale.GridView_segundoFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import com.example.kevin.vale.R;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private CustomAdapter adaptador;

    private GridView grid;

    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_segundo, container, false);


        grid = (GridView) view.findViewById(R.id.item);

        final ArrayList<Spacecraft> listItems = new ArrayList<>();
        listItems.add(new Spacecraft((R.drawable.longitud), getString(R.string.lon_titu)));
        listItems.add(new Spacecraft((R.drawable.volumen), getString(R.string.vol_titu)));
        listItems.add(new Spacecraft((R.drawable.balanza), getString(R.string.masa_titu)));
        listItems.add(new Spacecraft((R.drawable.area), getString(R.string.area)));
        listItems.add(new Spacecraft((R.drawable.corredor_en_silueta_corriendo_rapido), getString(R.string.velo_titu)));
        listItems.add(new Spacecraft((R.drawable.velocidad), getString(R.string.pres_titu)));
        listItems.add(new Spacecraft((R.drawable.frec), getString(R.string.fre_titu)));
        listItems.add(new Spacecraft((R.drawable.termometro), getString(R.string.Tempera)));
        listItems.add(new Spacecraft((R.drawable.innovacion), getString(R.string.ene_titu)));
        listItems.add(new Spacecraft((R.drawable.angulo), getString(R.string.ang_titul)));

        listItems.add(new Spacecraft((R.drawable.tiemp), getString(R.string.tiempo_titu)));
        listItems.add(new Spacecraft((R.drawable.resistencia), getString(R.string.res_titu)));

        listItems.add(new Spacecraft((R.drawable.gas), getString(R.string.cons_titu)));






        adaptador = new CustomAdapter(getActivity(), listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), Longitud_activity.class);
                    startActivity(intent);
                }
                else if(position ==1){
                    Intent intent = new Intent(getActivity(), Volumen_activity.class);
                    startActivity(intent);
                }

                else if (position == 2){
                    Intent intent = new Intent(getActivity(), Masa.class);
                    startActivity(intent);
                }
                else if (position == 3){
                    Intent intent = new Intent(getActivity(), Area.class);
                    startActivity(intent);
                }
                else if (position == 4){
                    Intent intent = new Intent(getActivity(), Velocidad.class);
                    startActivity(intent);
                }
                else if (position == 5){
                    Intent intent = new Intent(getActivity(), presion.class);
                    startActivity(intent);
                }
                else if (position == 6){
                    Intent intent = new Intent(getActivity(), Frecuencia.class);
                    startActivity(intent);
                }
                else if (position == 7){
                    Intent intent = new Intent(getActivity(), Temperatura.class);
                    startActivity(intent);
                }
                else if (position == 8){
                    Intent intent = new Intent(getActivity(), Energia.class);
                    startActivity(intent);
                }
                else if (position == 9){
                    Intent intent = new Intent(getActivity(), potencia.class);
                    startActivity(intent);
                }

                else if (position == 10){
                    Intent intent = new Intent(getActivity(), Tiempo.class);
                    startActivity(intent);
                }
                else if (position == 11){
                    Intent intent = new Intent(getActivity(), Resistencia.class);
                    startActivity(intent);
                }
                else if (position == 12){
                    Intent intent = new Intent(getActivity(), combustible.class);
                    startActivity(intent);
                }

            }
        });
        return view;
    }




}

