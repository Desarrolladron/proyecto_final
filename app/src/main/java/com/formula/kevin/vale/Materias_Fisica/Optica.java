package com.formula.kevin.vale.Materias_Fisica;

 import android.content.Intent;

 import com.formula.kevin.vale.Fisica_children.optica_children.energia_fotonica_children;
 import com.formula.kevin.vale.Fisica_children.optica_children.espectro_electromag_children;
 import com.formula.kevin.vale.Fisica_children.optica_children.factor_magnificacion_children;
 import com.formula.kevin.vale.Fisica_children.optica_children.indice_refraccion_children;
 import com.formula.kevin.vale.Fisica_children.optica_children.interferencias_children;
 import com.formula.kevin.vale.Fisica_children.optica_children.ley_reflexion_children;
 import com.formula.kevin.vale.Fisica_children.optica_children.ley_snell_children;
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
import com.formula.kevin.vale.resolver.fisica.optica;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

 import java.util.ArrayList;

public class Optica extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optica);

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
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.espectro_electromagnetico)));
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.snell_refraccion)));
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.refraccion)));
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.interferencias)));
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.ley_reflexion)));
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.factor_magnificacion)));
        listItems.add(new lista2((R.drawable.dispersion), getString(R.string.energia_fotonica)));


        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(Optica.this, espectro_electromag_children.class);
                    startActivity(intent);
                } else if (i == 1) {
                    Intent intent = new Intent(Optica.this, ley_snell_children.class);
                    startActivity(intent);
                } else if (i == 2) {
                    Intent intent = new Intent(Optica.this, indice_refraccion_children.class);
                    startActivity(intent);
                } else if (i == 3) {
                    Intent intent = new Intent(Optica.this, interferencias_children.class);
                    startActivity(intent);
                } else if (i == 4) {
                    Intent intent = new Intent(Optica.this, ley_reflexion_children.class);
                    startActivity(intent);
                } else if (i == 5) {
                    Intent intent = new Intent(Optica.this, factor_magnificacion_children.class);
                    startActivity(intent);
                } else if (i == 6) {
                    Intent intent = new Intent(Optica.this, energia_fotonica_children.class);
                    startActivity(intent);
                }
            }
        });

        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Optica.this, optica.class);
                MainActivity main = new MainActivity();

                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Optica.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }


}

