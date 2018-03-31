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


public class tambahPark extends AppCompatActivity {
//    public static SQLiteHelper sqLiteHelper;
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
        setContentView(R.layout.activity_tambah_park);
//        sqLiteHelper = new SQLiteHelper(this, "ParkDB.sqlite", null, 1);
//        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS PARKIR (ID INTEGER PRIMARY KEY AUTOINCREMENT, namaTempat VARCHAR, keterangan VARCHAR, tanggal VARCHAR, jam VARCHAR, gambar BLOB)");
        imageTempat = (ImageButton)findViewById(R.id.image_tempat);
        button = (Button)findViewById(R.id.button);
        txt_nama_tempat = (TextInputEditText)findViewById(R.id.txt_nama_tempat);
        txt_ket_tempat = (TextInputEditText)findViewById(R.id.txt_ket_tempat);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = dateFormat.format(c);
        Calendar rightnow = Calendar.getInstance();
        currentHours = rightnow.get(Calendar.HOUR_OF_DAY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageTempat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,0);
            }
        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try{
//                    sqLiteHelper.insertData(
//                          txt_nama_tempat.getText().toString().trim(),
//                            txt_ket_tempat.getText().toString().trim(),
//                            formattedDate,
//                            currentHours,
//                            ImageViewToByte(imageTempat)
//
//                    );
//
//                    Toast.makeText(getApplicationContext(),"Berhasil Di Tambah",Toast.LENGTH_LONG);
//                    txt_nama_tempat.setText("");
//                    txt_ket_tempat.setText("");
//                    imageTempat.setImageResource(R.drawable.image);
//                }
//                catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        });



    }

//    public static byte[] ImageViewToByte(ImageButton image){
//      Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
//      byte[] bytesArray = stream.toByteArray();
//      return bytesArray;
//    }
}
