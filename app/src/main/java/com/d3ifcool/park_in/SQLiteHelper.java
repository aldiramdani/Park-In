package com.d3ifcool.park_in;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Aldir on 3/31/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String txt_nama_tempat,String txt_ket_tempat,String tanggal,double jam, byte[] gambar){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO PARKIR VALUES (NULL, ?, ? ,? ,? ,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,txt_nama_tempat);
        statement.bindString(2,txt_ket_tempat);
        statement.bindString(3,tanggal);
        statement.bindDouble(4,jam);
        statement.bindBlob(5,gambar);

        statement.executeInsert();
    }

        public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
        }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
