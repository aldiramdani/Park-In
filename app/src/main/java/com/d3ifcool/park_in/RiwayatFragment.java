package com.d3ifcool.park_in;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

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
         View rootView = inflater.inflate(R.layout.fragment_control,container,false);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Park> parks = realm.where(Park.class).sort("time", Sort.DESCENDING)
                .equalTo("isRiwayat", true).findAll();
        RiwayatAdapter parkAdapter = new RiwayatAdapter(parks);
        ListView listView = (ListView)rootView.findViewById(R.id.list_view_park);
        View emptyViewPark = rootView.findViewById(R.id.empty_view_riwayat);
        listView.setEmptyView(emptyViewPark);
        listView.setAdapter(parkAdapter);

        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
    }
}
