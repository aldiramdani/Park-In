package com.d3ifcool.park_in;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkFragment extends Fragment {
    ListView listView;
    ArrayList<Park> list;
    ParkAdapter adapter=null;

    public ParkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_park,container,false);

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Park> parks = realm.where(Park.class).findAll();
        ArrayList<Park> parkArray = new ArrayList<>(parks); // Convert ke arraylist biar sesuai sama adapternya karna saya males update adapternya ke realm result

        ParkAdapter parkAdapter = new ParkAdapter(getContext(),parkArray);
        ListView listView = (ListView)rootView.findViewById(R.id.list_view);
        listView.setAdapter(parkAdapter);

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeActivity();
            }
        });
        return rootView;
    }


    public void ChangeActivity(){
        Intent i = new Intent(getContext(),tambahPark.class);
        startActivity(i);
    }
    @Override
    public void onStop() {
        super.onStop();
    }
}
