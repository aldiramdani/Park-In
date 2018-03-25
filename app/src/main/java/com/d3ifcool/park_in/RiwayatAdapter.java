package com.d3ifcool.park_in;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Aldir on 3/25/2018.
 */

public class RiwayatAdapter extends ArrayAdapter<Park> {

    public RiwayatAdapter (Context context, ArrayList<Park> parks){
        super(context,0,parks);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
    View listParkView = convertView;

        if (listParkView == null){
        listParkView = LayoutInflater.from(getContext()).inflate
                (R.layout.list_riwayat,parent, false);
    }

    //ambilobjek
    Park currentPark = getItem(position);

    //ambilfoto
    ImageView image_beranda =(ImageView)listParkView.findViewById(R.id.image_beranda);
        if (currentPark.hasImage()){
        image_beranda.setImageResource(currentPark.getmImage());
        image_beranda.setVisibility(View.VISIBLE);
    }else{
        image_beranda.setVisibility(View.GONE);
    }


        TextView textView_bagi = (TextView) listParkView.findViewById(R.id.textview_bagi);

        textView_bagi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getContext(),"Coba Bagi",Toast.LENGTH_SHORT).show();
        }
    });


    //ambiltext
    TextView textJudul = (TextView)listParkView.findViewById(R.id.text_judul);
        textJudul.setText(currentPark.getmJudul());

    TextView textKeterangan = (TextView)listParkView.findViewById(R.id.text_jam);
        textKeterangan.setText(currentPark.getmKeterangan());

    TextView textTanggal = (TextView)listParkView.findViewById(R.id.text_tanggal);
        textTanggal.setText(currentPark.getmTanggal());

    TextView textJam = (TextView)listParkView.findViewById(R.id.text_jam);
        textJam.setText(currentPark.getmJam());
        return listParkView;
}
}
