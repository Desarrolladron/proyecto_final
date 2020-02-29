package com.formula.kevin.vale.Activitis;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.formula.kevin.vale.PageAdapter;
import com.formula.kevin.vale.R;
import com.scwang.wave.MultiWaveHeader;



public class Menu_principal extends AppCompatActivity {

    Dialog epicDialog, epicDialog2;
    Button boton, botonvam, botonface;
    ImageView cerrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        setSupportActionBar(toolbar);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);


        TabLayout tabs = (TabLayout) findViewById(R.id.my_Tablayout);
        tabs.addTab(tabs.newTab().setText(getString(R.string.Menu)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.conve)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.herra)));
        tabs.setSelectedTabIndicatorHeight(15);
        tabs.setBackground(getResources().getDrawable(R.drawable.gradiente));
        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));



        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item1) {
            mostrarInfo();
        } else if (item.getItemId() == R.id.itemCompartir) {

            Intent compartir = new Intent(android.content.Intent.ACTION_SEND);
            compartir.setType("text/plain");
            String url = "https://play.google.com/store/apps/details?id=com.formula.kevin.vale";
            String mensaje = "iFormulas - Todo en uno. ¡Descargar aqui!" + "\n" + url;
            compartir.putExtra(android.content.Intent.EXTRA_SUBJECT, "Formulario de las ciencias exactas. iFormulas " + url);
            compartir.putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(compartir, "Compartir vía"));
        } else if(item.getItemId() == R.id.itemValorar) {
            play();
        }
        return super.onOptionsItemSelected(item);
    }

    public void play(){
        String url = "https://play.google.com/store/apps/details?id=com.formula.kevin.vale";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }



    public void mostrarInfo(){
        epicDialog = new Dialog(this);
        epicDialog.setContentView(R.layout.custom_popup);
        cerrar = (ImageView)epicDialog.findViewById(R.id.cerrarVentana);
        botonvam = (Button)epicDialog.findViewById(R.id.botonvamo);
        botonface = (Button)epicDialog.findViewById(R.id.botonface);

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
                play();

            }
        });
        botonface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/iFormulas";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }



    }

