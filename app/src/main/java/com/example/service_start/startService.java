package com.example.service_start;


import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.LogRecord;

public class startService  extends IntentService {

    private int i;
    private Handler handler = new Handler();







    public startService() {
        super("START SERVICE");
    }


    

    @Override
    protected void onHandleIntent(Intent arg0) {

        while(i<5){
            try{
                Thread.sleep(3000);

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

            handler.post(new Runnable(){

                public void run() {
                    Toast.makeText(getApplicationContext(),Integer.toString(downloadData.counter), Toast.LENGTH_SHORT).show();
                }
            });
i++;
        }
    }
}












































































































