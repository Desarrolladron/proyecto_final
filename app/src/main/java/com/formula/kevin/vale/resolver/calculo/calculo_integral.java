package com.formula.kevin.vale.resolver.calculo;

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

public class calculo_integral extends AppCompatActivity {
    private Adapter2 adaptador;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_integral);
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

        listItems.add(new Spacecraft((R.drawable.area), getString(R.string.limites)));
        listItems.add(new Spacecraft((R.drawable.derivadaaas), getString(R.string.derivadas)));
        listItems.add(new Spacecraft((R.drawable.integraless),  getString(R.string.integral_relacional)));
        listItems.add(new Spacecraft((R.drawable.integraless),  getString(R.string.integral_trigonometrica)));
        listItems.add(new Spacecraft((R.drawable.derivadaaas),  getString(R.string.derivada_funciones_exponenciales)));


        adaptador = new Adapter2(this, listItems);
        grid.setAdapter(adaptador);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if  (i == 0){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=13Xub7cn_ve49v4EbNjvXQ58UfwMN3mZS");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                else if  (i == 1){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1YAdDf-rTxpKDq5LLMm4P9nCsMR5QlHlx");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


            } else if  (i == 2){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1YAdDf-rTxpKDq5LLMm4P9nCsMR5QlHlx");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


                }
                else if  (i == 3){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1J6C_21KHX61sGTsSEQoJ4tIevurOsGvk");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


                }
                else if  (i == 4){
                    Uri uri = Uri.parse("https://drive.google.com/open?id=1iRo47PJkQWDoGhAINemlNtrDxxWZ4OUX");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


                }

            }
        });

    }
}

