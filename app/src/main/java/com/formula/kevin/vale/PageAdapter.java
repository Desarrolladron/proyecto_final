package com.formula.kevin.vale;

import android.os.Build;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.formula.kevin.vale.Fragments.Fragment_Kitkat;
import com.formula.kevin.vale.Fragments.PrimerFragment;
import com.formula.kevin.vale.GridView_segundoFragment.SegundoFragment;
import com.formula.kevin.vale.Fragments.TercerFragment;

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

             if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP){
                return new Fragment_Kitkat();

            }
                else{
                return new PrimerFragment();

            }
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

//170e255adcc8cf558c4bf864eb079ede0e3943ae