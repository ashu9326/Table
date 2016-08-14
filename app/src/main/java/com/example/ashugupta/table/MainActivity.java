package com.example.ashugupta.table;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textresult;
    Button generatebtn;
    EditText editTextnum, startfrom, endto;
    int temp;
    private static final int REQ_CODE1 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textresult = (TextView) findViewById(R.id.textresult);
        generatebtn = (Button) findViewById(R.id.generatebtn);
        startfrom = (EditText) findViewById(R.id.startfrom);
        endto = (EditText) findViewById(R.id.endto);
        editTextnum = (EditText) findViewById(R.id.editTextnum);

        generatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num1 = startfrom.getText().toString();
                String num2 = endto.getText().toString();
                String num3 = editTextnum.getText().toString();

                int number1 = Integer.parseInt(num1);
                int number2 = Integer.parseInt(num2);
                int number3 = Integer.parseInt(num3);

                if (num1.isEmpty() || num2.isEmpty() || num3.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (number2 - number1 <= 20) {
                    for (int i = number1; i <= number2; i++) {


                        temp = number3 * i;
                        textresult.append("" + number3 + "*" + i + "=" + temp + "\n");
                        textresult.append("\n");
                    }

                } else {
                    Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                    intent.putExtra("scrNum1", number1);
                    intent.putExtra("scrNum2", number2);
                    intent.putExtra("scrNum3", number3);

                    startActivityForResult(intent,REQ_CODE1);

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE1) {
            if (resultCode == RESULT_OK) {
                String receivedData = data.getExtras().getString("DataReturned");
                Toast.makeText(MainActivity.this, receivedData, Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();


            }

        }
    }
}





