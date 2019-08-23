package com.example.service_start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

import java.util.Random;

public class secondActivity extends AppCompatActivity {

    public TextView textViewName;
    public static TextView webTexts;
    public static Button webButtons;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        webTexts =   (TextView) findViewById(R.id.webText);
        webButtons = (Button) findViewById(R.id.webButton);



        String fVal = getIntent().getStringExtra("fValue");
        String sVal = getIntent().getStringExtra("sValue");
        String task = getIntent().getStringExtra("task");

        textViewName=(TextView)findViewById(R.id.textViewName);


        textViewName.setText("Your result:   " + calculate(fVal,sVal,task));





    }



   private String calculate(String a, String b, String c){

       int iA = Integer.parseInt(a);
       int iB = Integer.parseInt(b);
       int d =0;




       switch(c){

            case "+":
               d= iA + iB;
               break;
            case "-":
               d= iA - iB;
                break;
            case "*":
               d= iA * iB;
                break;
            case "/":
               d= iA / iB;
                break;



       }


        String answer = Integer.toString(d);

  return answer;
   }


    public void read(View view) {


        downloadData process = new downloadData();
        process.execute();

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
