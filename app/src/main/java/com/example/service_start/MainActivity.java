package com.example.service_start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText firstValues;
public  EditText secondValues;
private RadioGroup selectAction;
private  RadioButton selectButton;

String fVal;
String sVal;
private final String CHANNEL_ID = "personal_notifications";
private final int NOTIFICATION_ID = 001;


String przyklad ="przyklad";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }





    public void start(View v) {
        startService(new Intent(getBaseContext(),startService.class));


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_sync_problem_black_24dp);
        builder.setContentInfo("EXAMPLE notifications");
        builder.setContentText("You turn on start service");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());









    }

    public void bound(View v) {

        firstValues =(EditText)findViewById(R.id.firstVar);
        fVal = firstValues.getText().toString();


        secondValues = (EditText) findViewById(R.id.secondVar);
        sVal = secondValues.getText().toString();


        if(fVal.equals("") || sVal.equals("")){

         Toast.makeText(getApplicationContext(),"please enter numbers",Toast.LENGTH_SHORT).show();
        }
        else {




            selectAction = (RadioGroup) findViewById(R.id.selectAction);
            int radioId = selectAction.getCheckedRadioButtonId();
            selectButton = findViewById(radioId);

            String abab = selectButton.getText().toString();


            //Toast.makeText(getApplicationContext(),abab, Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, secondActivity.class);
            i.putExtra("fValue", fVal);
            i.putExtra("sValue", sVal);
            i.putExtra("task",abab);
            startActivity(i);















        }
    }

    public void start_second_service(View view) {
       Intent i = new Intent(this,second_service.class);
       startService(i);
    }

    public void stop_second_service(View view) {
        Intent i = new Intent(this,second_service.class);
        stopService(i);

    }
}
