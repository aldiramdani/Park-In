package com.d3ifcool.park_in;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Aldir on 3/25/2018.
 */

public class ParkAdapter extends ArrayAdapter<Park> {

    public ParkAdapter (Context context, ArrayList<Park> parks){
        super(context,0,parks);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listParkView = convertView;

        if (listParkView == null){
            listParkView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list,parent, false);
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


        ImageButton btn_bagi = (ImageButton)listParkView.findViewById(R.id.btn_bagi);
        ImageButton btn_hapus = (ImageButton)listParkView.findViewById(R.id.btn_hapus);
        ImageButton btn_edit = (ImageButton)listParkView.findViewById(R.id.btn_edit);
        btn_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coba Bagi",Toast.LENGTH_SHORT).show();
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coba Edit",Toast.LENGTH_SHORT).show();
            }
        });

        btn_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coba Hapus",Toast.LENGTH_SHORT).show();
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
