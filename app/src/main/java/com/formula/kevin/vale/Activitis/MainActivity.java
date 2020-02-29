package com.formula.kevin.vale.Activitis;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
import android.widget.Toast;


import com.formula.kevin.vale.R;
 import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.List;



public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener  {

    Button btn,botonvam,vamos2,boton,botonMenu;
    ImageView cerrar;
    private RewardedVideoAd mRewardedVideoAd;
    LinearLayout layout;
    private final int[] pics = {R.drawable.quimica, R.drawable.calculo, R.drawable.mate};


    public AdView mAdView;
    Dialog epicDialog,epicDialog2;
    public static boolean bandera =false;
   public static SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MobileAds.initialize(this, "ca-app-pub-5863997258237891~7759903239");

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);


        loadRewardedVideoAd();


        epicDialog = new Dialog(this);

        boton = (Button) findViewById(R.id.botonvamo);
        vamos2 = (Button) findViewById(R.id.botonvamo20);
        botonMenu = (Button) findViewById(R.id.btnMenuPrincipal);

        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LinearLayout root=findViewById(R.id.root);






        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    epicDialog.setContentView(R.layout.custompopu4);
                    cerrar = (ImageView)epicDialog.findViewById(R.id.cerrarVentana);
                    vamos2 = (Button)epicDialog.findViewById(R.id.botonvamo20);

                    cerrar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            epicDialog.dismiss();
                        }
                    });

                    epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    epicDialog.show();

                   vamos2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mRewardedVideoAd.isLoaded()) {
                                mRewardedVideoAd.show();
                            }
                        }
                    });
            }
        });
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



    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-8882667917768463/2801122349",
                new AdRequest.Builder().build());
    }
    @Override
    public void onRewarded(RewardItem reward) {

        Toast.makeText(this, "Anuncios eliminados durante esta sesión", Toast.LENGTH_SHORT).show();
        epicDialog.dismiss();

        bandera = true;
    }
    

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "Video cerrado", Toast.LENGTH_SHORT).show();
        loadRewardedVideoAd();
        epicDialog.dismiss();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
    }

    @Override
    public void onRewardedVideoAdLoaded() {
    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {
    }

    @Override
    public void onRewardedVideoCompleted() {
    }
    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
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

