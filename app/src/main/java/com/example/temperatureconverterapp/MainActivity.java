package com.example.temperatureconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    TextView text1;
    EditText temp;
    RadioButton rbtn1,rbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button) findViewById(R.id.btn);
        text1=(TextView) findViewById(R.id.text1);
        temp=(EditText) findViewById(R.id.temp);
        rbtn1=(RadioButton) findViewById(R.id.rbtn1);
        rbtn2=(RadioButton) findViewById(R.id.rbtn2);
        btn2=(Button) findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp.getText().toString().isEmpty()){
                    text1.setText("PLease Give Temperature");
                }
                else {
                    double x = Double.parseDouble(String.valueOf(temp.getText()));
                    if(rbtn1.isChecked()){
                        x=(x*9)/5+32;
                        x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                        text1.setText(String.valueOf(x)+"Degree F");

                    }
                    else if (rbtn2.isChecked()) {
                        x=(x-32)*5/9;
                        x=Double.parseDouble(new DecimalFormat("##.###").format(x));
                        text1.setText(String.valueOf(x)+"Degree C");

                    }
                    else{
                        text1.setText("Please Select One Option !");
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("0.0");
                temp.setText(" ");
                rbtn1.setChecked(false);
                rbtn2.setChecked(false);
            }
        });
    }
}