package com.d3ifcool.park_in;

/**
 * Created by Aldir on 3/24/2018.
 */

public class Park {
    private String mJudul;;
    private  String mKeterangan;
    private String mTanggal;
    private  String mJam;
    private int mImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Park(String mJudul, String mKeterangan, String mTanggal, String mJam,int mImage) {
        this.mJudul = mJudul;
        this.mKeterangan = mKeterangan;
        this.mTanggal = mTanggal;
        this.mJam = mJam;
        this.mImage = mImage;
    }

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

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
    public boolean hasImage (){
        return mImage != NO_IMAGE_PROVIDED;
    }
}
