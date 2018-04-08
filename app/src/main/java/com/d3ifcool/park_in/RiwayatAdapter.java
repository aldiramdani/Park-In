package com.d3ifcool.park_in;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;

/**
 * Created by Aldir on 3/25/2018.
 */

public class RiwayatAdapter extends RealmBaseAdapter<Park> implements ListAdapter {

    public RiwayatAdapter (OrderedRealmCollection<Park> realmResults){
        super(realmResults);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
          View listParkView = convertView;
        if (listParkView == null){
            listParkView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_riwayat, parent, false);
        }

        //ambilobjek
        final Park currentPark = adapterData.get(position);
        ImageView imageBeranda = (ImageView)listParkView.findViewById(R.id.image_beranda);
        TextView textView_bagi = (TextView) listParkView.findViewById(R.id.textview_bagi);
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

        TextView textView_delete = (TextView) listParkView.findViewById(R.id.textview_del);
        final View ListParkView = listParkView;
        textView_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListParkView.getRootView().getContext());
                builder.setMessage("Yakin Akan Dihapus?")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Realm realm = Realm.getDefaultInstance();
                                realm.beginTransaction();
                                currentPark.deleteFromRealm();
                                realm.commitTransaction();
                            }
                        })
                        .setNegativeButton("Batal",null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

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
            imageBeranda.setImageBitmap(bitmap);
        }

        return listParkView;
    }
}

