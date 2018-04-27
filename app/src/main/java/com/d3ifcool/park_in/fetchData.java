package com.d3ifcool.park_in;

import android.os.AsyncTask;
import android.util.Log;

import com.d3ifcool.park_in.PengembangActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Aldir on 4/27/2018.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed = "";
    String singelParsed = "";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/yvvev");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line= bufferedReader.readLine();
            while (line != null){
                data = data + line;
                line = bufferedReader.readLine();
            }

            Log.d("AAA", data);
            JSONArray JA = new JSONArray(data);
            for (int i = 0; i < JA.length();i++){
                JSONObject JO  = (JSONObject)JA.get(i);
                singelParsed = "version :"+JO.get("version") + "\n"
                + "Nama "+JO.get("nama") +"\n";
                dataParsed = dataParsed + singelParsed;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        PengembangActivity.txt_ver_baru.setText(this.dataParsed);
    }
}
