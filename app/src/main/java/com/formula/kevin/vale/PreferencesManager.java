package com.formula.kevin.vale;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager  {

private Context context;
private SharedPreferences sharedPreferences;

public PreferencesManager(Context context){
    this.context= context;
    getSharedPreference();
}


private void getSharedPreference(){
    sharedPreferences= context.getSharedPreferences(context.getString(R.string.my_preference),Context.MODE_PRIVATE);
}
public void writePreferences(){
    SharedPreferences.Editor editor= sharedPreferences.edit();
    editor.putString(context.getString(R.string.my_preference_key),"INIT_OK");
    editor.commit();
}

public boolean checkPreferences(){
    boolean estado = false;

    if(sharedPreferences.getString(context.getString(R.string.my_preference_key),"null").equals("null")){
        estado = false;
    }
    else{
        estado = true;
    }return estado;
}

    public void limpiarPreferences() {
        sharedPreferences.edit().clear().commit();
    }
}
