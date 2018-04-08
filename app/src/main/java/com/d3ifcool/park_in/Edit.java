package com.d3ifcool.park_in;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import io.realm.Realm;

public class Edit extends AppCompatActivity {
    ImageButton imageTempat;
    Button button;

    TextInputEditText txt_nama_tempat,txt_ket_tempat;
    String formattedDate,hours;
    Date c = Calendar.getInstance().getTime();
    int currentHours;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageTempat.setImageBitmap(bitmap);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getExtras().getString("id");
        final Realm realm = Realm.getDefaultInstance();
        final Park park = realm.where(Park.class).equalTo("id", id).findFirst();

        imageTempat = (ImageButton)findViewById(R.id.image_tempat);
        button = (Button)findViewById(R.id.button);
        txt_nama_tempat = (TextInputEditText)findViewById(R.id.txt_nama_tempat);
        txt_ket_tempat = (TextInputEditText)findViewById(R.id.txt_ket_tempat);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm");
        formattedDate = dateFormat.format(c);
        Calendar rightnow = Calendar.getInstance();
        currentHours = rightnow.get(Calendar.HOUR_OF_DAY);

        txt_nama_tempat.setText(park.getmJudul());
        txt_ket_tempat.setText(park.getmKeterangan());
        Bitmap bitmap = BitmapFactory.decodeByteArray(park.getmImage(),0,park.getmImage().length);
        imageTempat.setImageBitmap(bitmap);

        imageTempat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_nama_tempat.getText().toString().equals("") || txt_ket_tempat.getText().toString().equals("")){
                    Toast.makeText(Edit.this,"Nama Tempat dan Keterangan Tempat Harus Di Isi !",Toast.LENGTH_LONG).show();
                }else {
                    try {
                        //Realm Begin
                        realm.beginTransaction();
                        //relam atur data
                        park.setmJudul(txt_nama_tempat.getText().toString().trim());
                        park.setmKeterangan(txt_ket_tempat.getText().toString().trim());
                        park.setmTanggal(formattedDate);
                        park.setmJam(String.valueOf(currentHours));
                        park.setmImage(ImageViewToByte(imageTempat));
                        park.setRiwayat(false);
                        realm.commitTransaction();

                        Toast.makeText(Edit.this, "Berhasil Di Edit", Toast.LENGTH_LONG).show();
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static byte[] ImageViewToByte(ImageButton image){
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] bytesArray = stream.toByteArray();
        return bytesArray;
    }
}
