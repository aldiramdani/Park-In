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

/**
 * A simple {@link Fragment} subclass.
 */
public class ParkFragment extends Fragment {
    ListView listView;
    ArrayList<Park> list;
    ParkAdapter adapter=null;
    private ArrayList<Park> parks = new ArrayList<>();

    public ParkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_park,container,false);
//
//        parks.add(new Park("Test","Tes2","19/20/2013","19:00",R.drawable.ic_launcher_background));
//
//        ParkAdapter parkAdapter = new ParkAdapter(getContext(),parks);
//        ListView listView = (ListView)rootView.findViewById(R.id.list_view);
//        listView.setAdapter(parkAdapter);

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
