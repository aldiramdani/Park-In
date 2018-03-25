package com.d3ifcool.park_in;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatFragment extends Fragment {


    public RiwayatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_riwayat,container,false);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
