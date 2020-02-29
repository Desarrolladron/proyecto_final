package com.formula.kevin.vale.Materias_mate;

import android.content.Intent;

import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.anguloOpuesto_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.angulosComplementarios_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.angulosSuplementarios_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.clasificacionSegunAngulo_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.razonesSumaDif_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.relacionTrigonometria_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.senoCosenoTan_children;
import com.formula.kevin.vale.Matematicas_children.Trigonometria_children.teoremaPitagoras_children;
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
import com.formula.kevin.vale.resolver.matematicas.trigonometria_ejer;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class Trigonometria extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometria);



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

        MainActivity main = new MainActivity();
        if  (main.bandera == true){
            mAdView.setVisibility(View.GONE);
        }
        list = (ListView) findViewById(R.id.item2_2);

        final ArrayList<lista2> listItems = new ArrayList<>();
        listItems.add(new lista2((R.drawable.angle),getString(R.string.angulos_c)));
        listItems.add(new lista2((R.drawable.angle),getString(R.string.angulos_s)));
        listItems.add(new lista2((R.drawable.angle), "Teorema de Pitagoras"));
        listItems.add(new lista2((R.drawable.angle), getString(R.string.angulos_o)));
        listItems.add(new lista2((R.drawable.angle), getString(R.string.relaciones_trigo)));
        listItems.add(new lista2((R.drawable.angle), getString(R.string.clasificacion_triangulos)));
         listItems.add(new lista2((R.drawable.angle), getString(R.string.razones_angulo)));
        listItems.add(new lista2((R.drawable.angle), "Seno,Coseno y Tangente"));


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Trigonometria.this, angulosComplementarios_children.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(Trigonometria.this, angulosSuplementarios_children.class);
                    startActivity(intent);
                }
               else if (i == 2) {
                    Intent intent = new Intent(Trigonometria.this, teoremaPitagoras_children.class);
                    startActivity(intent);

                }

                else if (i == 3) {
                    Intent intent = new Intent(Trigonometria.this, anguloOpuesto_children.class);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Intent intent = new Intent(Trigonometria.this, relacionTrigonometria_children.class);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Intent intent = new Intent(Trigonometria.this, clasificacionSegunAngulo_children.class);
                    startActivity(intent);
                }

                else if (i == 6) {
                    Intent intent = new Intent(Trigonometria.this, razonesSumaDif_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(Trigonometria.this, senoCosenoTan_children.class);
                    startActivity(intent);
                }
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Trigonometria.this, trigonometria_ejer.class);

                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Trigonometria.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }


}