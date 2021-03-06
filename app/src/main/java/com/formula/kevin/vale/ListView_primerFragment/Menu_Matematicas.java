package com.formula.kevin.vale.ListView_primerFragment;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.formula.kevin.vale.Materias_mate.Probabilidad_estadistica;
import com.formula.kevin.vale.Materias_mate.Trigonometria;
import com.formula.kevin.vale.Materias_mate.algebra;
import com.formula.kevin.vale.Materias_mate.algebra_lineal;
import com.formula.kevin.vale.Materias_mate.aritmetica;
import com.formula.kevin.vale.Materias_mate.geometria;
import com.formula.kevin.vale.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class Menu_Matematicas extends AppCompatActivity {
    private ListView list;
    private CustomAdapter2 adaptador;
    private InterstitialAd mInterstitialAd;

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
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-8882667917768463/3391564183");
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
        listItems.add(new lista((R.drawable.longitud), getString(R.string.arit)));
        listItems.add(new lista((R.drawable.cuboo), getString(R.string.geometria)));
        listItems.add(new lista((R.drawable.parabolic), getString(R.string.algebra)));
        listItems.add(new lista((R.drawable.angle), getString(R.string.trigonometria)));
        listItems.add(new lista((R.drawable.longitud), getString(R.string.algebralineal)));
        listItems.add(new lista((R.drawable.bar_chart), getString(R.string.proba)));

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
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 0) {
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                    Intent intent = new Intent(Menu_Matematicas.this,aritmetica.class);
                    startActivity(intent);



                }
                else if (position == 2) {
                    Intent intent = new Intent(Menu_Matematicas.this,algebra.class);
                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
                else if (position == 4) {
                    Intent intent = new Intent(Menu_Matematicas.this,algebra_lineal.class);
                    startActivity(intent);
                }
                else if (position == 5) {
                    Intent intent = new Intent(Menu_Matematicas.this,Probabilidad_estadistica.class);

                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
                else if (position == 1) {
                    Intent intent = new Intent(Menu_Matematicas.this,geometria.class);
                    startActivity(intent);
                }
                else if (position == 3) {
                    Intent intent = new Intent(Menu_Matematicas.this, Trigonometria.class);
                    startActivity(intent);
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    } else {
                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }

                }

            }
        });
    }
    }
