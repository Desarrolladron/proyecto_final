package com.example.kevin.vale.Materias_Calculo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevin.vale.Activitis.Menu_principal;
import com.example.kevin.vale.R;

public class Diferencial_Integral extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diferencial__integral);
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


        expandableListView = (ExpandableListView) findViewById(R.id.lista_expandible_calculo);


        ExpandableListViewAdapterCalculo adapter = new ExpandableListViewAdapterCalculo(Diferencial_Integral.this);
        expandableListView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Diferencial_Integral.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }
    public class ExpandableListViewAdapterCalculo extends BaseExpandableListAdapter {

        String[] gruponombres = {"Logaritmos","Sumas y Productos","Límites","Derivadas","Derivadas de Funciones LOG & EXP","Derivada " +
                "de Funciones Trigonometricas","Derivada de Funciones Hiperbólicas","Integrales","Integrales de Funciones LOG & EXP","Integrales de Fracciones",
        "Integral con Raiz"};

        int[][] childNames = {{R.drawable.logaritmos},{R.drawable.suma_productos},{R.drawable.limites},{R.drawable.derivada},{R.drawable.derivada_funciones_log},
                {R.drawable.deri_funcioes_trigo},{R.drawable.derivada_funciones_hiperbolicas},{R.drawable.integrales},{R.drawable.integrales_funcion_log},{R.drawable.integrales_fraccion},
                {R.drawable.integral_raiz}};
        Context context;

        public ExpandableListViewAdapterCalculo(Context context) { //aqui colocar el int [] imagenes
            this.context = context;
        }

        @Override
        public int getGroupCount() {
            return gruponombres.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return childNames[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return gruponombres[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return childNames[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView txtview = new TextView(context);
            txtview.setText(gruponombres[i]);
            txtview.setPadding(100, 25, 0, 25);
            txtview.setTextSize(20);

            return txtview;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            ImageView imag = new ImageView(context);
            imag.setImageResource(childNames[i][i1]);
            imag.setScaleType(ImageView.ScaleType.FIT_START);
            imag.setPadding(0, 75, 0, 0);

            return imag;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }
}

