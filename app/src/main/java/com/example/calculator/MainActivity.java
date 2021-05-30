package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
// Kerakli klaslarni chaqirib olamiz
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

// Asosiy ushbu klas ichida yozamiz

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //XML fayldagi barcha kerakli konteynerlarni IDsi orqali chaqirib olamiz

        setContentView(R.layout.activity_main);
        EditText editText1 = findViewById(R.id.text01);
        EditText editText2 = findViewById(R.id.text02);
        TextView resultText = findViewById(R.id.result01);
        RadioGroup radioGroup =findViewById(R.id.radioGroup);
        Button calculate=findViewById(R.id.equalBtn);

        //Button klasidan olingan obekt orqali buttonga murojat qilamiz, yani button bosilganda nima ish bo`lish algoritmini qilamiz

        calculate.setOnClickListener(v->{

            // XML dagi editTextlarni o`zgaruvchilarga o`zlashtirib , ulardan foydalanamiz

            String text1 = editText1.getText().toString();
            String text2 = editText2.getText().toString();
            int id = radioGroup.getCheckedRadioButtonId();
            if (text1.isEmpty()) {
                Toast toast = Toast.makeText(this, "1-raqamni kiriting", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if (text2.isEmpty()){
                Toast toast = Toast.makeText(this, "2-raqamni kiriting", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            int num1=Integer.parseInt(text1);
            int num2=Integer.parseInt(text2);
            double result=0;
            switch (id){
                case R.id.add:{
                    result=num1+num2;
                    break;
                }
                case R.id.subtract:{
                    result=num1-num2;

                    break;
                }
                case R.id.multiply:{
                    result=num1*num2;

                    break;
                }
                case R.id.divide:{
                    if (num2==0){
                        Toast.makeText(this, "0 ga bo'lish mn emas", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result=num1*1.0/num2;
                    break;
                }
            }
            resultText.setText(String.format("%.4f",result));

        });
        
    }
}

