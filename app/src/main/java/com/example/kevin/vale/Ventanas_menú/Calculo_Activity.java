package com.example.kevin.vale.Ventanas_menú;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.kevin.vale.ListView_primerFragment.CustomAdapter2;
import com.example.kevin.vale.ListView_primerFragment.lista;
import com.example.kevin.vale.R;

import java.util.ArrayList;

public class Calculo_Activity extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_);

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
        listItems.add(new lista((R.drawable.longitud), "CÁLCULO VECTORIAL"));
        listItems.add(new lista((R.drawable.longitud), "CÁLCULO DIFERENCIAL E INTEGRAL" ));


        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);
    }
}
