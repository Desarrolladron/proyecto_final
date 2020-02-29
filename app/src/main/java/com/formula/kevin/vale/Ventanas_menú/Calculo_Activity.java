package com.formula.kevin.vale.Ventanas_menú;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.formula.kevin.vale.Activitis.MainActivity;
import com.formula.kevin.vale.ListView_primerFragment.CustomAdapter2;
import com.formula.kevin.vale.ListView_primerFragment.lista;
import com.formula.kevin.vale.Materias_Calculo.Diferencial_Integral;
import com.formula.kevin.vale.Materias_Calculo.Vectorial;
import com.formula.kevin.vale.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class Calculo_Activity extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    private InterstitialAd mInterstitialAd;


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
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/3391564183");
        //original  ca-app-pub-8882667917768463/3391564183

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });



        list = (ListView) findViewById(R.id.item2);

        final ArrayList<lista> listItems = new ArrayList<>();
        listItems.add(new lista((R.drawable.vector_icon),  getString(R.string.calculo_vectorial)));
        listItems.add(new lista((R.drawable.diferencialicon),  getString(R.string.calculo_difrencial)));


        adaptador = new CustomAdapter2(this, listItems);
        list.setAdapter(adaptador);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity main = new MainActivity();

                if(i == 1) {
                    Intent intent = new Intent(Calculo_Activity.this, Diferencial_Integral.class);
                    startActivity(intent);

                if  (main.bandera == false) {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                    }
                   else if  (main.bandera == true){


                    }else   {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");

                    }

                }
                else if(i == 0) {
                    Intent intent = new Intent(Calculo_Activity.this, Vectorial.class);
                    startActivity(intent);

                }
            }
        });


    }
}

