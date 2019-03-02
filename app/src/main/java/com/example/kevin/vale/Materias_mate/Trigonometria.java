package com.example.kevin.vale.Materias_mate;

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

public class Trigonometria extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometria);
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

        expandableListView = (ExpandableListView) findViewById(R.id.lista_expandible4);

        ExpandableListViewAdapter9 adapter = new ExpandableListViewAdapter9(Trigonometria.this);
        expandableListView.setAdapter(adapter);

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

    public class ExpandableListViewAdapter9 extends BaseExpandableListAdapter {

        String[] gruponombres = {"Ángulos Complementarios","Ángulos Suplementarios","Teorema de Pitágoras","Ángulos Opuestos",
                "Relaciones de la Trigonometría","Clasificación de Triangulos según sus ángulos","Razones Trigonometricas","Razones del ángulo suma/diferencia","Teoremas Importantes"};

        int[][] childNames = {{R.drawable.angulos_complementarios},{R.drawable.ang_suplementario},{R.drawable.teorema_pitag},{R.drawable.angulo_opuesto},
                {R.drawable.relaciones_trigoono},{R.drawable.clasificacion_angulo},{R.drawable.razones_trigon},{R.drawable.razones_suma_dif},{R.drawable.teoremas_import}};
        Context context;

        public ExpandableListViewAdapter9(Context context) { //aqui colocar el int [] imagenes
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
            imag.setPadding(0, 75, 0, 30);

            return imag;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }
}