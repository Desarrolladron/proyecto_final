package com.formula.kevin.vale.Fisica_children.termodinamica_children;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.formula.kevin.vale.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class capacidad_calorifica_childrne extends AppCompatActivity {
    ImageView imagen;
    PhotoViewAttacher photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacidad_calorifica_childrne);
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
        imagen =(ImageView)findViewById(R.id.capacidadcalor);
        photo = new PhotoViewAttacher(imagen); }
}
