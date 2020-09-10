package com.example.random25082020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSoMin, mEdtSoMax;
    Button mBtnRandom;
    TextView mTvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ
        mEdtSoMax = findViewById(R.id.edtSomax);
        mEdtSoMin = findViewById(R.id.edtSomin);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetQua = findViewById(R.id.tvKetqua);

        //ctrl + p : xem tham số truyền vào
        // Annotation : chú thích

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textSoMin = mEdtSoMin.getText().toString();
                String textSoMax = mEdtSoMax.getText().toString();

                if (textSoMin.isEmpty() || textSoMax.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Bạn chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }

                int sMin = Integer.parseInt(textSoMin);
                int sMax = Integer.parseInt(textSoMax);


            }
        });
    }
}