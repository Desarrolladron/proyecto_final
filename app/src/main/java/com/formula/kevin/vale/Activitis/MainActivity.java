package com.formula.kevin.vale.Activitis;

import android.app.Dialog;
import android.content.Intent;
 import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;

 import com.formula.kevin.vale.juego.LauncherActivity2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
  import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.formula.kevin.vale.R;
import com.google.android.gms.ads.AdView;


public class MainActivity extends AppCompatActivity  {
     Button btn,botonvam,vamos2,boton,botonMenu,juego;
    ImageView cerrar;
     LinearLayout layout;



    public AdView mAdView;
    Dialog epicDialog,epicDialog2;



    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        epicDialog = new Dialog(this);

        boton = (Button) findViewById(R.id.botonvamo);
        vamos2 = (Button) findViewById(R.id.botonvamo20);
        botonMenu = (Button) findViewById(R.id.btnMenuPrincipal);
        juego =(Button )findViewById(R.id.BtnJuegos);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout root=findViewById(R.id.root);





        FloatingActionButton fab3 = (FloatingActionButton) findViewById(R.id.fabEstrella);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.formula.kevin.vale");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                */
       mostrarInfo();
            }
        });



    }
    public void loadSlides(View view) {


        startActivity(new Intent(this, LauncherActivity2.class));
        finish();
    }
    public void cargarInicio(View view) {

            startActivity(new Intent(this, Menu_principal.class));
            finish();
            // para versiones anteriores a android 6.0

    }


    public void playStore(View view) {
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.formula.kevin.vale");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
*/


            }
        });
    }




    public void mostrarInfo() {


        epicDialog.setContentView(R.layout.custompopu3);
        cerrar = (ImageView) epicDialog.findViewById(R.id.cerrarVentana);
        botonvam = (Button) epicDialog.findViewById(R.id.botonvamo);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();

        botonvam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=com.overflow.samplestickerapp";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }



}

