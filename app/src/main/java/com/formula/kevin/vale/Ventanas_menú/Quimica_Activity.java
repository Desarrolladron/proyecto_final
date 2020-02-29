package com.formula.kevin.vale.Ventanas_menú;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.formula.kevin.vale.ListView_primerFragment.CustomAdapter2;
import com.formula.kevin.vale.ListView_primerFragment.lista;
import com.formula.kevin.vale.Materias_Quimica.Estequiometria;
import com.formula.kevin.vale.Materias_Quimica.gases;
import com.formula.kevin.vale.R;

import java.util.ArrayList;

public class Quimica_Activity extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quimica_);

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
        listItems.add(new lista((R.drawable.chemistry), "Quimica Analitica"));
        listItems.add(new lista((R.drawable.gasesx), "Gases"));
        listItems.add(new lista((R.drawable.gasesx), "Quimica Organica"));



        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent intent = new Intent(Quimica_Activity.this, Estequiometria.class);
                    startActivity(intent);
                }
               else  if(i == 1){
                    Intent intent = new Intent(Quimica_Activity.this, gases.class);
                    startActivity(intent);
                }
            }
        });

    }
}
