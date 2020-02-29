package com.formula.kevin.vale.resolver.matematicas;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.formula.kevin.vale.AreayVolumen.Adapter2;
import com.formula.kevin.vale.GridView_segundoFragment.Spacecraft;
import com.formula.kevin.vale.R;

import java.util.ArrayList;

public class probabilidad_ejer extends AppCompatActivity {
    private Adapter2 adaptador;

    private GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probabilidad_ejer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
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
        grid = (GridView) findViewById(R.id.item3);
        final ArrayList<Spacecraft> listItems = new ArrayList<>();
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.moda_media_mediana)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.desviacion_estandar)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.varianza)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.operaciones_conjuntos)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.probabilidad_condicional)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.esperanza_matematica)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.permutaciones)));
        listItems.add(new Spacecraft((R.drawable.bar_chart), getString(R.string.ordenaciones_combinaciones)));






        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=143c5UHME3oWqRrc33BmemObX2uQvBDeL");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
               else if (i == 1) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=10nf7BGLbHfjcvQMBKnoGDEluX9bQNAkg");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 2) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=161Pif8drVFDz6C8CZojQEQNlRVjuN8h4");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 3) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1wYr7hISJ3Do6YnWcihUOjejbjBTQrS_v");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 4) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1TfRgVq9s8WWRw4_zq5JnTHRYIES0A71d");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=18zGNs7Cnu3tUTNvp_cd_xtVvnVEeGfr3");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 6) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1wdUM3wsEqxzi5Qu4vR7l7DvbMqNueXzo");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1kPBAt4JyPW_yOFIgk9A0mvUYiB9aMzPA");

                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
    }
}
