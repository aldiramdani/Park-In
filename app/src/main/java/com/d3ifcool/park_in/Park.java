package com.d3ifcool.park_in;

import io.realm.RealmObject;

/**
 * Created by Aldir on 3/24/2018.
 */

public class Park extends RealmObject {
    private String mJudul;;
    private  String mKeterangan;
    private String mTanggal;
    private  String mJam;
    private byte[] mImage;

    public Park(String mJudul, String mKeterangan, String mTanggal, String mJam,byte[] mImage) {
        this.mJudul = mJudul;
        this.mKeterangan = mKeterangan;
        this.mTanggal = mTanggal;
        this.mJam = mJam;
        this.mImage = mImage;
    }

    public Park(){} // Wajib ada kalo pake realm

    public String getmJudul() {
        return mJudul;
    }

    public void setmJudul(String mJudul) {
        this.mJudul = mJudul;
    }

    public String getmKeterangan() {
        return mKeterangan;
    }

    public void setmKeterangan(String mKeterangan) {
        this.mKeterangan = mKeterangan;
    }

    public String getmTanggal() {
        return mTanggal;
    }

    public void setmTanggal(String mTanggal) {
        this.mTanggal = mTanggal;
    }

    public String getmJam() {
        return mJam;
    }

    public void setmJam(String mJam) {
        this.mJam = mJam;
    }

    public byte[] getmImage() {
        return mImage;
    }

    public void setmImage(byte[] mImage) {
        this.mImage = mImage;
    }

}
