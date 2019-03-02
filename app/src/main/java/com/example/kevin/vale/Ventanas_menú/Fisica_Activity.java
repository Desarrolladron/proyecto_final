package com.example.kevin.vale.Ventanas_menú;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kevin.vale.ListView_primerFragment.CustomAdapter2;
import com.example.kevin.vale.ListView_primerFragment.lista;
import com.example.kevin.vale.Materias_Fisica.Dinamica;
import com.example.kevin.vale.Materias_Fisica.Electricidad_Mag;
import com.example.kevin.vale.Materias_Fisica.Mecanica_fluidos;
import com.example.kevin.vale.Materias_Fisica.Mecanicaa;
import com.example.kevin.vale.Materias_Fisica.Optica;
import com.example.kevin.vale.Materias_Fisica.Termodinamica_fisi;
import com.example.kevin.vale.R;

import java.util.ArrayList;

public class Fisica_Activity extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica_);
        //METODO DEL TOOLBAR PARA QUE REGRESE AL MENU PRINCIPAL
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                finish();
            }
        });

        list = (ListView) findViewById(R.id.item2);

        final ArrayList<lista> listItems = new ArrayList<>();

        listItems.add(new lista((R.drawable.gravity),  getString(R.string.dinamica) ));
        listItems.add(new lista((R.drawable.innovacion), getString(R.string.mecanica)));
        listItems.add(new lista((R.drawable.eyedropper), "Mecanica de Fluidos"));

        listItems.add(new lista((R.drawable.termometro),"TERMODINÁMICA"));
        listItems.add(new lista((R.drawable.magnet),  getString(R.string.Electricidad)));
        listItems.add(new lista((R.drawable.longitud),  getString(R.string.optica)));

        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 4){
                    Intent intent = new Intent(Fisica_Activity.this, Electricidad_Mag.class);
                    startActivity(intent);
                }
               else if(i == 2){
                    Intent intent = new Intent(Fisica_Activity.this, Mecanica_fluidos.class);
                    startActivity(intent);
                }
                else if(i == 1){
                    Intent intent = new Intent(Fisica_Activity.this, Mecanicaa.class);
                    startActivity(intent);
                }
                else if(i == 0){
                    Intent intent = new Intent(Fisica_Activity.this, Dinamica.class);
                    startActivity(intent);
                }
                else if(i == 5){
                    Intent intent = new Intent(Fisica_Activity.this, Optica.class);
                    startActivity(intent);
                }
                else if(i == 3){
                    Intent intent = new Intent(Fisica_Activity.this, Termodinamica_fisi.class);
                    startActivity(intent);
                }
            }
        });


    }
}
