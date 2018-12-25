package com.example.kevin.vale.Activitis;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kevin.vale.PreferencesManager;
import com.example.kevin.vale.R;
import com.example.kevin.vale.mPagerAdapter;

public class WelcomeAcivity extends AppCompatActivity implements View.OnClickListener{
private ViewPager mpager ;
private int[] layuots = {R.layout.primer_layout,R.layout.segundo_layout,R.layout.tercer_layout,R.layout.cuarto_layout};
private mPagerAdapter mPagerAdapter2;
private LinearLayout dots_layout;
private ImageView[] dots;
private Button omitir;
private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if(new PreferencesManager(this).checkPreferences())
        {
        cargarHome();
        }

        if(Build.VERSION.SDK_INT>=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else{
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setContentView(R.layout.activity_welcome_acivity);

        mpager= findViewById(R.id.viewpager);
        mPagerAdapter2 = new mPagerAdapter(layuots,this);
        mpager.setAdapter(mPagerAdapter2);

        dots_layout = (LinearLayout)findViewById(R.id.dotsLayout);
        next = (Button)findViewById(R.id.btn_siguiente);
        omitir = (Button)findViewById(R.id.btn_skip);
        next.setOnClickListener(this);
        omitir.setOnClickListener(this);


        crearDots(0);
        mpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                crearDots(position);

                if(position== layuots.length-1){
                next.setText("Iniciar");
                omitir.setVisibility(View.INVISIBLE);
                }
                else{
                    next.setText("Siguiente");
                    omitir.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void crearDots(int current_position){
    if(dots_layout != null){ //si contiene
        dots_layout.removeAllViews();
        dots= new ImageView[layuots.length];

        for(int i = 0; i<layuots.length; i++ ){
            dots[i] = new ImageView(this);
            if(i== current_position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.activar_dots));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));

            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dots_layout.addView(dots[i],params);
        }
    }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_siguiente:
                loadNextSlide();
                break;
            case R.id.btn_skip:
                cargarHome();
                new PreferencesManager(this).writePreferences();
                break;
        }
    }
    private void cargarHome(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    private void loadNextSlide(){
        int next_slide = mpager.getCurrentItem()+1;
        if(next_slide<layuots.length){
            mpager.setCurrentItem(next_slide);

        }else{
            cargarHome();
            new PreferencesManager(this).writePreferences();
        }
    }
}
