package com.example.kevin.vale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.kevin.vale.Fragments.PrimerFragment;
import com.example.kevin.vale.GridView_segundoFragment.SegundoFragment;
import com.example.kevin.vale.Fragments.TercerFragment;

public class PageAdapter extends FragmentStatePagerAdapter {
    private int numeroTabs;
    public PageAdapter(FragmentManager fm, int numeroTabs ){
        super(fm);
        this.numeroTabs = numeroTabs;
    }

    @Override
    public Fragment getItem(int position) { //aqui se manda a llamar los fragments
        switch (position){

            case 0:
                return new PrimerFragment();
            case 1:
                return new SegundoFragment();
            case 2:
                return new TercerFragment();

            default: return null;
        }

    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}