package com.example.service_start;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
import java.util.Random;

public class downloadData extends AsyncTask<Void,Void,Void> {

    String data = "";
    String[] singleParsed = new String[100];
    String dataParsed = "";


   public static int counter;
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            //URL url = new URL("https://api.myjson.com/bins/oz95z");
            URL url = new URL("https://danepubliczne.imgw.pl/api/data/synop");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";


                while(line != null){

                    line = bufferedReader.readLine();
                    data = data + line;


                }


            JSONArray JA = new JSONArray(data);
            counter = JA.length();

                for(int i =0; i<JA.length();i++){
                    JSONObject JO = (JSONObject) JA.get(i);


               // if( JO.get("id_stacji").equals("12375") ){

                        singleParsed[i] = JO.get("stacja") + "\n";
                        dataParsed = dataParsed + singleParsed[i];

                        singleParsed[i] = JO.get("temperatura") +"  C" + "\n";
                        dataParsed = dataParsed + singleParsed[i];

                        singleParsed[i] = JO.get("cisnienie") + " hPa"+"\n\n";
                        dataParsed = dataParsed + singleParsed[i];

                //}

                }


            Log.i("oki","doki");

            } catch (IOException | JSONException e) {
                e.printStackTrace();
                 }


        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Random r = new Random();
     int i = r.nextInt(counter+1);


        secondActivity.webTexts.setText(this.dataParsed.toString());


    }
}
