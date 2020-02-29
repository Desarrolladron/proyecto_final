package com.formula.kevin.vale.Matematicas_children.Probabilidad_children;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.formula.kevin.vale.R;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class probabilidadCondicional_children extends AppCompatActivity {
    ImageView imagen,ima2;
    PhotoViewAttacher photo,poto2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_probabilidad_condicional_children);
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
        imagen =(ImageView)findViewById(R.id.probabilidadc);
        photo = new PhotoViewAttacher(imagen);

        ima2 =(ImageView)findViewById(R.id.probabilidadc2);
        poto2 = new PhotoViewAttacher(ima2);
    }
}
