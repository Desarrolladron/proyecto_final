package com.example.kevin.vale.Activitis;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kevin.vale.PreferencesManager;
import com.example.kevin.vale.R;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btn = (Button)findViewById(R.id.inicio);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent intent = new Intent(MainActivity.this,Menu_principal.class);
              startActivity(intent);
        finish();
            }
        });

    }

    public void loadSlides(View view){

        new PreferencesManager(this).limpiarPreferences();
        startActivity(new Intent(this, WelcomeAcivity.class));
        finish();
    }
}
