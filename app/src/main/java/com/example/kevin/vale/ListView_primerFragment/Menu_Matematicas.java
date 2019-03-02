package com.example.kevin.vale.ListView_primerFragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kevin.vale.GridView_segundoFragment.Longitud_activity;
import com.example.kevin.vale.Materias_mate.Probabilidad_estadistica;
import com.example.kevin.vale.Materias_mate.Trigonometria;
import com.example.kevin.vale.Materias_mate.algebra;
import com.example.kevin.vale.Materias_mate.algebra_lineal;
import com.example.kevin.vale.Materias_mate.aritmetica;
import com.example.kevin.vale.Materias_mate.geometria;
import com.example.kevin.vale.R;

import java.util.ArrayList;

public class Menu_Matematicas extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__matematicas);

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
        listItems.add(new lista((R.drawable.longitud), getString(R.string.arit)));
        listItems.add(new lista((R.drawable.cuboo), getString(R.string.geometria)));
        listItems.add(new lista((R.drawable.parabolic), getString(R.string.algebra)));
        listItems.add(new lista((R.drawable.angle), getString(R.string.trigonometria)));
        listItems.add(new lista((R.drawable.longitud), getString(R.string.algebralineal)));
        listItems.add(new lista((R.drawable.bar_chart), getString(R.string.proba)));

        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(Menu_Matematicas.this,aritmetica.class);
                    startActivity(intent);
                }
                else if (position == 2) {
                    Intent intent = new Intent(Menu_Matematicas.this,algebra.class);
                    startActivity(intent);
                }
                else if (position == 4) {
                    Intent intent = new Intent(Menu_Matematicas.this,algebra_lineal.class);
                    startActivity(intent);
                }
                else if (position == 5) {
                    Intent intent = new Intent(Menu_Matematicas.this,Probabilidad_estadistica.class);
                    startActivity(intent);
                }
                else if (position == 1) {
                    Intent intent = new Intent(Menu_Matematicas.this,geometria.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(Menu_Matematicas.this, Trigonometria.class);
                    startActivity(intent);
                }

            }
        });
    }
    }
