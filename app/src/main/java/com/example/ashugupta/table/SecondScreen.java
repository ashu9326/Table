package com.example.ashugupta.table;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity
{
TextView  secondScrRes;
    Button successbtn, buttonFailure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Intent intent=getIntent();
        Bundle bundel = intent.getExtras();
        int number1=bundel.getInt("srcNum1");
        int number2=bundel.getInt("srcNum2");
        int number3=bundel.getInt("srcNum3");

        successbtn=(Button)findViewById(R.id.successbtn);
        buttonFailure=(Button)findViewById(R.id.failurebtn);
        secondScrRes=(TextView) findViewById(R.id. secondScrRes);


        for(int i=number1;i<=number2;i++)
        {
          int  temp=number3*i;
            secondScrRes.append(number3+"*"+ i+"="+ temp+"\n" );
            secondScrRes.append("\n");
        }


        successbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //intent.putExtra("");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        buttonFailure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
