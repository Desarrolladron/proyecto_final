package com.example.kevin.vale.Materias_Fisica;

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

public class Termodinamica_fisi extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termodinamica_fisi);

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


        expandableListView = (ExpandableListView) findViewById(R.id.lista_expandible_termodinamica_fisc);


        ExpandableListViewAdapterTermooriginal adapter = new ExpandableListViewAdapterTermooriginal(Termodinamica_fisi.this);
        expandableListView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Termodinamica_fisi.this, Menu_principal.class);

                startActivity(intent);
                finish();
            }
        });
    }

    public class ExpandableListViewAdapterTermooriginal extends BaseExpandableListAdapter {

        String[] gruponombres = {"Calor","Ley de Presiones Parciales o de Dalton","Capacidad Calorífica","Ecuación de estado de los gases ideales",
                "Ley de Boyle-Mariotte","Primer Principio de la Termodinámica","Dilatación Lineal","Dilatación Volumetrica","Dilatación Superficial",
                "Dilatación de Líquidos","Máquinas Térmicas","Procesos Termodinámicos e Isotérmicos"};

        int[][] childNames = {{R.drawable.termodinamica_calor},{R.drawable.presiones_parciales},{R.drawable.capacidad_calorifica},{R.drawable.ecuacion_de_estado},
                {R.drawable.ley_boyle},{R.drawable.primer_principio},{R.drawable.dilatacion_lineal},
                {R.drawable.dilatacion_cubica_o_volumetrica},{R.drawable.dilatacion_superficial},{R.drawable.dilatacion_liquidos},{R.drawable.maquinas_termicas},
                {R.drawable.procesos_termodinamicos_isotermicos}};
        Context context;

        public ExpandableListViewAdapterTermooriginal(Context context) { //aqui colocar el int [] imagenes
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