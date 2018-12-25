package com.example.kevin.vale.Materias_mate;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kevin.vale.R;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    String[] gruponombres = {"Ley De Los Exponentes","Productos Notables","Valor Absoluto","Binomio de Newton","Números Reales",
    "Ecuaciones","Números Complejos","Ley de Signos","Formula General"};

    int[][] childNames = {{R.drawable.ley_exponente},{R.drawable.productos_notables},{R.drawable.valor_absoluto},{R.drawable.newton},{R.drawable.numeros_reales},
            {R.drawable.ecuacioness},{R.drawable.numero_complejo},{R.drawable.ley_signos},{R.drawable.formula_gral}};
    Context context;

    public ExpandableListViewAdapter(Context context){ //aqui colocar el int [] imagenes
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return gruponombres.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return childNames[i].length;
    }

    @Override
    public Object getGroup(int i) {
        return gruponombres[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return childNames[i][i1];
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        TextView txtview= new TextView(context);
        txtview.setText(gruponombres[i]);
        txtview.setPadding(100,25,0,25);
        txtview.setTextSize(20);

        return txtview;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ImageView imag = new ImageView(context);
        imag.setImageResource(childNames[i][i1]);
        imag.setScaleType(ImageView.ScaleType.FIT_START);
        imag.setPadding(0,75,0,75);

        return imag;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
