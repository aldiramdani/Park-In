package com.d3ifcool.park_in;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Aldir on 4/8/2018.
 */

public class DevAdapter extends FragmentPagerAdapter {
    public DevAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new AbidFragment();
        } else if(position ==1){
            return new RivkalFragment();
        } else {
            return new AldiFragment();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
