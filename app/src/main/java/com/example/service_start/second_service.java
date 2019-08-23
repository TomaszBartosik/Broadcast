package com.example.service_start;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import java.security.Provider;

public class second_service extends Service {



    Handler handler = new Handler();
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        handler.post(new Runnable(){

            public void run() {
                Toast.makeText(getApplicationContext(),"im a live", Toast.LENGTH_SHORT).show();


                downloadData process = new downloadData();
                process.execute();
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        handler.post(new Runnable(){

            public void run() {
                Toast.makeText(getApplicationContext(),"i died", Toast.LENGTH_SHORT).show();
            }
        });

      secondActivity.webTexts.setText("");
      secondActivity.webTexts.setTextColor(Color.parseColor("#ffffff"));

    }
}
