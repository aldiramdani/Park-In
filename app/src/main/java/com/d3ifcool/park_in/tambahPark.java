package com.d3ifcool.park_in;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import io.realm.Realm;


public class tambahPark extends AppCompatActivity {

    ImageButton imageTempat;
    Button button;

    TextInputEditText txt_nama_tempat,txt_ket_tempat;
    String formattedDate;
    Date c = Calendar.getInstance().getTime();
    Date jam = Calendar.getInstance().getTime();
    String currentHours;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imageTempat.setImageBitmap(bitmap);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_park);
        imageTempat = (ImageButton)findViewById(R.id.image_tempat);
        button = (Button)findViewById(R.id.button);
        txt_nama_tempat = (TextInputEditText)findViewById(R.id.txt_nama_tempat);
        txt_ket_tempat = (TextInputEditText)findViewById(R.id.txt_ket_tempat);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyy");
        formattedDate = dateFormat.format(c);
        Calendar rightnow = Calendar.getInstance();

        SimpleDateFormat hours = new SimpleDateFormat("hh:mm");
        currentHours = hours.format(jam);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
               if (txt_nama_tempat.getText().equals("") || txt_ket_tempat.getText().toString().equals("")){
                   Toast.makeText(tambahPark.this,"Nama Tempat Atau Keterangan Tempat Harus Di Isi !",Toast.LENGTH_SHORT).show();
               }else{
                   try{
                       //Realm Begin
                       Realm realm = Realm.getDefaultInstance();
                       realm.beginTransaction();
                       Park p = realm.createObject(Park.class, UUID.randomUUID().toString());
                       //relam atur data
                       p.setmJudul(txt_nama_tempat.getText().toString().trim());
                       p.setmKeterangan(txt_ket_tempat.getText().toString().trim());
                       p.setmTanggal(formattedDate);
                      p.setmJam(currentHours);
                       p.setmImage(ImageViewToByte(imageTempat));
                       p.setRiwayat(false);
                       realm.commitTransaction();

                       Toast.makeText(tambahPark.this,"Berhasil Di Tambah",Toast.LENGTH_LONG).show();
                       txt_nama_tempat.setText("");
                       txt_ket_tempat.setText("");
                       imageTempat.setImageResource(R.drawable.image);
                       finish();
                       pindah();
                   }   catch (Exception e){
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

    public void pindah(){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }

}
