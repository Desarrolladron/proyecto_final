package com.formula.kevin.vale.juego;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.formula.kevin.vale.Activitis.MainActivity;
import com.formula.kevin.vale.R;
import com.mrntlu.toastie.Toastie;

public class LauncherActivity2 extends AppCompatActivity {

    Boolean doublePressToExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Home Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        if(!isTablet(this)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        final ImageButton addButton = (ImageButton) findViewById(R.id.add);
        final ImageButton subButton = (ImageButton) findViewById(R.id.sub);
        final ImageButton mulButton = (ImageButton) findViewById(R.id.mul);
         Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
         setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //regresar...
                Intent intent = new Intent (LauncherActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Start Addition Quiz
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity2.this, QuizActivity.class);
                intent.putExtra("operation", "add");
                startActivity(intent);

            }
        });

        //Start Subtraction Quiz
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity2.this, QuizActivity.class);
                intent.putExtra("operation", "sub");
                startActivity(intent);
            }
        });

        //Start Multiplication Quiz
        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LauncherActivity2.this, QuizActivity.class);
                intent.putExtra("operation", "mul");
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (doublePressToExit) {
            Intent startMain = new Intent(LauncherActivity2.this,MainActivity.class);
            startActivity(startMain);
            finish();
        }

        this.doublePressToExit = true;



        final Toast toast = Toast.makeText(LauncherActivity2.this, getString(R.string.salirr), Toast.LENGTH_SHORT);
        toast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doublePressToExit = false;
                toast.cancel();
            }
        }, 2000);



    }




    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}