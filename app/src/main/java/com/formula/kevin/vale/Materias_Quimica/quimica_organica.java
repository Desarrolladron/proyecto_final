package com.formula.kevin.vale.Materias_Quimica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.formula.kevin.vale.Activitis.Menu_principal;
import com.formula.kevin.vale.Materias_Quimica.quimicaOrganica.Tipos_carbonos;
import com.formula.kevin.vale.Materias_Quimica.quimicaOrganica.alcano_alqueno_alquino;
import com.formula.kevin.vale.Materias_Quimica.quimicaOrganica.cadenaCarbonada_children;
import com.formula.kevin.vale.Materias_Quimica.quimicaOrganica.halogenos;
import com.formula.kevin.vale.Materias_Quimica.quimicaOrganica.hidrocarburo_aroman;
import com.formula.kevin.vale.Materias_Quimica.quimicaOrganica.hidrocarburos_cicli;
import com.formula.kevin.vale.Quimica_children.Estequiometria_children.disoluciones_children;
import com.formula.kevin.vale.Quimica_children.Estequiometria_children.numAvogadro_children;
import com.formula.kevin.vale.R;
import com.formula.kevin.vale.listview_children.CustomAdapter3;
import com.formula.kevin.vale.listview_children.lista2;
import com.formula.kevin.vale.resolver.quimica.analitica;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class quimica_organica extends AppCompatActivity {
    private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quimica_organica);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
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
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.quimico_sd),getString(R.string.cadenaCarbo)));
        listItems.add(new lista2((R.drawable.quimico_sd),getString(R.string.cadenaCarbo)));
        listItems.add(new lista2((R.drawable.quimico_sd),getString(R.string.alcanos)));
        listItems.add(new lista2((R.drawable.quimico_sd),getString(R.string.hidrocarburos_ciclico)));
        listItems.add(new lista2((R.drawable.quimico_sd),getString(R.string.hidrocarburos_aromantic)));
        listItems.add(new lista2((R.drawable.quimico_sd),getString(R.string.halogenos)));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(quimica_organica.this, cadenaCarbonada_children.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(quimica_organica.this, Tipos_carbonos.class);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(quimica_organica.this, alcano_alqueno_alquino.class);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Intent intent = new Intent(quimica_organica.this, hidrocarburos_cicli.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(quimica_organica.this, hidrocarburo_aroman.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(quimica_organica.this, halogenos.class);
                    startActivity(intent);
                }
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(quimica_organica.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }
    }

