package com.example.random25082020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        float number = 1.5f;
//        Lam tron theo 0.5
//        int result = Math.round(number);
//        Làm tròn lên
//        double number = 1.01;
//        double result = Math.ceil(number);
//        Làm tròn xuống
//        double number = 1.999;
//        double result = Math.floor(number);
        // 5 -> 10
        for (int i = 0; i <100 ; i++) {
            double result = Math.floor(Math.random() * 6) + 5;
            Log.d("BBB",String.valueOf(result));
        }


    }
}