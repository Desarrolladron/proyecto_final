package com.formula.kevin.vale.Materias_mate;

import android.content.Intent;

import com.formula.kevin.vale.ListView_primerFragment.lista;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.binomioNewton_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.conjugadoComplejo_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.formulaGeneral_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.leyExponentes_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.leySignos_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.numerosComplejos_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.numerosReales_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.operacionesComplejos_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.productosnotables_children;

import com.formula.kevin.vale.Matematicas_children.Algebra_children.sumatoria_children;
import com.formula.kevin.vale.Matematicas_children.Algebra_children.valorAbsoluto_children;
import com.formula.kevin.vale.listview_children.CustomAdapter3;
import com.formula.kevin.vale.listview_children.lista2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
 import android.widget.ExpandableListView;
import android.widget.ListView;

import com.formula.kevin.vale.Activitis.MainActivity;
import com.formula.kevin.vale.Activitis.Menu_principal;
import com.formula.kevin.vale.R;
import com.formula.kevin.vale.resolver.matematicas.algebra_ejer;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class algebra extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algebra);



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

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/3391564183");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MainActivity main = new MainActivity();
        if  (main.bandera == true){
            mAdView.setVisibility(View.GONE);
        }

        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.parabolic),"Ley de los Exponentes"));
        listItems.add(new lista2((R.drawable.parabolic),"Productos Notables"));
        listItems.add(new lista2((R.drawable.parabolic), "Valor Absoluto"));
        listItems.add(new lista2((R.drawable.parabolic), "Binomio de Newton"));
        listItems.add(new lista2((R.drawable.parabolic), "Números Reales"));
        listItems.add(new lista2((R.drawable.parabolic), "Números Complejos"));
        listItems.add(new lista2((R.drawable.parabolic), "Ley de Signos"));
        listItems.add(new lista2((R.drawable.parabolic), "Formula General"));
        listItems.add(new lista2((R.drawable.parabolic), "Formulas de Sumatoria"));
        listItems.add(new lista2((R.drawable.parabolic), "Operaciones con Números Complejos"));
        listItems.add(new lista2((R.drawable.parabolic), "Conjugado de un Número Complejo"));
        listItems.add(new lista2((R.drawable.parabolic), "Representacion de un Número Complejo"));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   if (i == 0) {
                    Intent intent = new Intent(algebra.this, leyExponentes_children.class);
                    startActivity(intent);
                }
                    else if (i == 1) {
                    Intent intent = new Intent(algebra.this,productosnotables_children.class);
                     startActivity(intent);
                }
                   else if (i == 2) {
                       Intent intent = new Intent(algebra.this, valorAbsoluto_children.class);
                       startActivity(intent);
                   }
                   else if (i == 3) {
                       Intent intent = new Intent(algebra.this, binomioNewton_children.class);
                       startActivity(intent);
                   }
                   else if (i == 4) {
                       Intent intent = new Intent(algebra.this, numerosReales_children.class);
                       startActivity(intent);
                   }
                   else if (i == 5) {
                       Intent intent = new Intent(algebra.this, numerosComplejos_children.class);
                       startActivity(intent);
                   }
                   else if (i == 6) {
                       Intent intent = new Intent(algebra.this, leySignos_children.class);
                       startActivity(intent);
                   }
                   else if (i == 7) {
                       Intent intent = new Intent(algebra.this, formulaGeneral_children.class);
                       startActivity(intent);
                   }
                   else if (i == 8) {
                       Intent intent = new Intent(algebra.this, sumatoria_children.class);
                       startActivity(intent);
                   }
                   else if (i == 9) {
                       Intent intent = new Intent(algebra.this, operacionesComplejos_children.class);
                       startActivity(intent);
                   }
                   else if (i == 10) {
                       Intent intent = new Intent(algebra.this, conjugadoComplejo_children.class);
                       startActivity(intent);
                   }
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(algebra.this, algebra_ejer.class);

                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(algebra.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });

    }

}
