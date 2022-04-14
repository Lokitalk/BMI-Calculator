package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtweight, edtHeightFt, edtHeightIn;
        Button btnCalculator;
        TextView txtResult;
        LinearLayout LLMain;

        edtweight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtheightF_t);
        edtHeightIn = findViewById(R.id.edtHeight_In);
        btnCalculator = findViewById(R.id.button);
        txtResult = findViewById(R.id.result);
        LLMain = findViewById(R.id.LLMAIN);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // take value form user
                int weight = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in =Integer.parseInt(edtHeightIn.getText().toString());

                // create logic its a simple math you just search on google
                int totalin = ft* 12 + in;
                double totalcm = totalin*2.53;
                double totalm = totalcm/100;
                double bmi = weight/(totalm*totalm);

                // here we use simple condition statement

                if (bmi >25){
                    txtResult.setText("you're obese");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.red));
                } else if (bmi<18){
                    txtResult.setText("you're Underweight");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }else {
                    txtResult.setText("you're healthy");
                    LLMain.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });

    }
}