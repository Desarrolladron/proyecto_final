package com.example.kevin.vale.TercerFragmento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.kevin.vale.R;

import uk.co.senab.photoview.PhotoViewAttacher;

public class constantes extends AppCompatActivity {
    ImageView imageView,image2,imagen3;
    PhotoViewAttacher photoViewAttacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_constantes);

        imageView =(ImageView) findViewById(R.id.consta);
        photoViewAttacher = new PhotoViewAttacher(imageView);


        imagen3 =(ImageView) findViewById(R.id.conceptos);
        photoViewAttacher = new PhotoViewAttacher(imagen3);
    }
}
