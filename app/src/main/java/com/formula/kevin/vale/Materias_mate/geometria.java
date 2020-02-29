package com.formula.kevin.vale.Materias_mate;

import android.content.Intent;

import com.formula.kevin.vale.Matematicas_children.Geometria_children.circunferenciaCentroOrigen_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.circunferenciaFueraOrigen_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.distanciaDosPuntos_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.distanciaPuntorec_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.ecuacionGralConi_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.formaPuntoPendiente_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.hiperbola_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.modulo_vector_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.parabolaFueraOrigen_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.parabolaOrigen_children;
import com.formula.kevin.vale.Matematicas_children.Geometria_children.puntoMedio_children;
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
import com.formula.kevin.vale.resolver.matematicas.Geometria_ejer;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class geometria extends AppCompatActivity {
    ExpandableListView expandableListView;
    private AdView mAdView;
    private ListView list;
    private CustomAdapter3 adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria);



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
        listItems.add(new lista2((R.drawable.cuboo),getString(R.string.distancia_entre_dos)));
        listItems.add(new lista2((R.drawable.cuboo),getString(R.string.punto_medio)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.punto_pendiente)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.distancia_punto_recta)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.ecuacion_general_conica)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.circunferencia_centro_origen)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.circunferencia_fuera_origen)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.hiperbola)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.modulo_vector)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.parabola_origen)));
        listItems.add(new lista2((R.drawable.cuboo), getString(R.string.parabola_fuera_origen)));



        adaptador = new CustomAdapter3(this, listItems);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(geometria.this, distanciaDosPuntos_children.class);
                    startActivity(intent);
                }
                else if (i == 1) {
                    Intent intent = new Intent(geometria.this, puntoMedio_children.class);
                  startActivity(intent);
                }
                else if (i == 2) {
                    Intent intent = new Intent(geometria.this, formaPuntoPendiente_children.class);
                    startActivity(intent);
                }
                else if (i == 3) {
                     Intent intent = new Intent(geometria.this, distanciaPuntorec_children.class);
                  startActivity(intent);
                }
                else if (i == 4) {
                    Intent intent = new Intent(geometria.this, ecuacionGralConi_children.class);
                    startActivity(intent);
                }
                else if (i == 5) {
                    Intent intent = new Intent(geometria.this, circunferenciaCentroOrigen_children.class);
                    startActivity(intent);
                }
                else if (i == 6) {
                     Intent intent = new Intent(geometria.this, circunferenciaFueraOrigen_children.class);
                    startActivity(intent);
                }
                else if (i == 7) {
                    Intent intent = new Intent(geometria.this, hiperbola_children.class);
                    startActivity(intent);
                }
                else if (i == 8) {
                    Intent intent = new Intent(geometria.this, modulo_vector_children.class);
                    startActivity(intent);
                }   else if (i == 9) {
                    Intent intent = new Intent(geometria.this, parabolaOrigen_children.class);
                    startActivity(intent);
                }
                else if (i == 10) {
                    Intent intent = new Intent(geometria.this, parabolaFueraOrigen_children.class);
                    startActivity(intent);
                }

            }
        });
        FloatingActionButton fab2 = findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(geometria.this, Geometria_ejer.class);

                startActivity(intent);

            }
        });

//boton flotante
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(geometria.this, Menu_principal.class);

                startActivity(intent);
                finish();

            }
        });
    }
/*
    public class ExpandableListViewAdapter4 extends BaseExpandableListAdapter {

        String[] gruponombres = {getString(R.string.distancia_entre_dos),
                getString(R.string.punto_medio),getString(R.string.punto_pendiente),getString(R.string.distancia_punto_recta),
                getString(R.string.ecuacion_general_conica),getString(R.string.circunferencia_centro_origen)
                ,getString(R.string.circunferencia_fuera_origen),getString(R.string.hiperbola)
        ,getString(R.string.modulo_vector),getString(R.string.parabola_origen),getString(R.string.circunferencia_fuera_origen)};


        int[][] childNames = {{R.drawable.distancia2},{R.drawable.punto_medio_def},{R.drawable.forma_punto_pendiente},{R.drawable.punto_recta},{R.drawable.conicas},
                {R.drawable.centro_origen},{R.drawable.fuera_origen},{R.drawable.hiperbola},{R.drawable.modulo_vector},{R.drawable.parabola_vertice_origen},
                {R.drawable.parabola_vertice_fueraorigen}};
        Context context;

        public ExpandableListViewAdapter4(Context context) { //aqui colocar el int [] imagenes
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
            imag.setPadding(0, 75, 0, 75);

            return imag;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }
    }

 */
}

