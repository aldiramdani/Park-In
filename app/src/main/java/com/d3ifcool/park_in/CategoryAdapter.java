package com.d3ifcool.park_in;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Aldir on 3/25/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter{

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new ParkFragment();
        } else{
            return new RiwayatFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
