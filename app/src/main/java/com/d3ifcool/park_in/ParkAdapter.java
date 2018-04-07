package com.d3ifcool.park_in;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;

/**
 * Created by Aldir on 3/25/2018.
 */

public class ParkAdapter extends RealmBaseAdapter<Park> implements ListAdapter{

    public ParkAdapter (OrderedRealmCollection<Park> realmResults){
        super(realmResults);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View listParkView = convertView;
        if (listParkView == null){
            listParkView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        }

        //ambilobjek
        final Park currentPark = adapterData.get(position);

        //ambilfoto
        ImageView image_beranda =(ImageView)listParkView.findViewById(R.id.image_beranda);



        TextView textView_bagi = (TextView) listParkView.findViewById(R.id.textview_bagi);
        TextView textView_hapus = (TextView) listParkView.findViewById(R.id.textview_hapus);
        TextView textView_edit = (TextView)listParkView.findViewById(R.id.textview_edit);
        textView_bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Saya parkir di " + currentPark.getmJudul() + " "+ currentPark.getmKeterangan());
                sendIntent.setType("text/plain");
                parent.getContext().startActivity(sendIntent);
            }
        });

        textView_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(parent.getContext(), Edit.class);
                intent.putExtra("id", currentPark.getId());
                parent.getContext().startActivity(intent);
            }
        });

        textView_hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                currentPark.setRiwayat(true);
                realm.commitTransaction();
            }
        });
        //ambiltext
        TextView textJudul = (TextView)listParkView.findViewById(R.id.text_judul);
        textJudul.setText(currentPark.getmJudul());

        TextView textKeterangan = (TextView)listParkView.findViewById(R.id.text_keterangan);
        textKeterangan.setText(currentPark.getmKeterangan());

        TextView textTanggal = (TextView)listParkView.findViewById(R.id.text_tanggal);
        textTanggal.setText(currentPark.getmTanggal());

        TextView textJam = (TextView)listParkView.findViewById(R.id.text_jam);
        textJam.setText(currentPark.getmJam());

        byte[] parkirImage = currentPark.getmImage();
        if (parkirImage != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(parkirImage,0,parkirImage.length);
            image_beranda.setImageBitmap(bitmap);
        }

        return listParkView;
    }
}
