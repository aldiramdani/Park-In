package com.d3ifcool.park_in;

import android.app.Application;

import io.realm.Realm;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        //tess
//        Realm.deleteRealm(Realm.getDefaultConfiguration());
    }
}
