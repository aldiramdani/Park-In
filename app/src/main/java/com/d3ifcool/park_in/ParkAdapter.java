package com.d3ifcool.park_in;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private Context context;
    private  int layout;
    private ArrayList<Park> ParkList;

    public ParkAdapter (Context context, ArrayList<Park> parks){
        super(context,0,parks);
    }

    private class ViewHolder{
        ImageView image_beranda;
        TextView    textJudul,textKeterangan,textTanggal,textJam;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listParkView = convertView;
        ViewHolder holder = new ViewHolder();
        if (listParkView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        //ambilobjek
        Park currentPark = getItem(position);

        //ambilfoto
        ImageView image_beranda =(ImageView)listParkView.findViewById(R.id.image_beranda);



        TextView textView_bagi = (TextView) listParkView.findViewById(R.id.textview_bagi);
        TextView textView_hapus = (TextView) listParkView.findViewById(R.id.textview_hapus);
        TextView textView_edit = (TextView)listParkView.findViewById(R.id.textview_edit);
        textView_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coba Bagi",Toast.LENGTH_SHORT).show();
            }
        });

        textView_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Coba Edit",Toast.LENGTH_SHORT).show();
            }
        });

        textView_hapus.setOnClickListener(new View.OnClickListener() {
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

        byte[] parkirImage = currentPark.getmImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(parkirImage,0,parkirImage.length);

        return listParkView;
    }
}
