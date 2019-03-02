package com.example.kevin.vale.Activitis;

import android.app.Dialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevin.vale.PageAdapter;
import com.example.kevin.vale.R;


public class Menu_principal extends AppCompatActivity {
Dialog epicDialog;
Button boton;
ImageView cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        epicDialog = new Dialog(this);
        boton = (Button)findViewById(R.id.botonvamo);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        TabLayout tabs = (TabLayout) findViewById(R.id.my_Tablayout);
        tabs.addTab(tabs.newTab().setText(getString(R.string.Menu)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.conve)));
        tabs.addTab(tabs.newTab().setText(getString(R.string.herra)));

        tabs.setSelectedTabIndicatorHeight(15);

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
        }

        return super.onOptionsItemSelected(item);

    }
    public void mostrarInfo(){
    epicDialog.setContentView(R.layout.custom_popup);
     cerrar = (ImageView)epicDialog.findViewById(R.id.cerrarVentana);

     cerrar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             epicDialog.dismiss();
         }
     });

     epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();



    }
}

