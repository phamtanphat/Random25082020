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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSoMin, mEdtSoMax;
    Button mBtnRandom,mBtnReset,mBtnAddRange;
    TextView mTvKetQua;
    List<Integer> mArrayListRange;
    String mTextSoMin = "";
    String mtextSoMax = "";
    String mKetQua = "";
    int mSMin = 0;
    int mSMax = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ
        mEdtSoMax = findViewById(R.id.edtSomax);
        mEdtSoMin = findViewById(R.id.edtSomin);
        mBtnRandom = findViewById(R.id.btnRandom);
        mTvKetQua = findViewById(R.id.tvKetqua);
        mBtnReset = findViewById(R.id.btnReset);
        mBtnAddRange = findViewById(R.id.btnAddRange);

//        leak memory : Vùng nhớ không được kiểm soát
        mArrayListRange = new ArrayList<>();

        mBtnAddRange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Lấy dữ liệu từ edittext
                mTextSoMin = mEdtSoMin.getText().toString();
                mtextSoMax = mEdtSoMax.getText().toString();
//              Kiểm tra chuỗi rỗng
                if (mTextSoMin.isEmpty() || mtextSoMax.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            "Bạn chưa nhập đủ thông tin",
                            Toast.LENGTH_SHORT
                    ).show();
                    return;
                }
//              Chuyển dữ liệu thành số
                mSMin = Integer.parseInt(mTextSoMin);
                mSMax = Integer.parseInt(mtextSoMax);

//              Kiểm tra số min không được hơn hoặc bằng số max
                if (mSMin >= mSMax){
                    mSMax = mSMin + 1;
                }
                mEdtSoMax.setText(String.valueOf(mSMax));
                mEdtSoMin.setText(String.valueOf(mSMin));

                mArrayListRange.clear();

                for (int i = mSMin; i <= mSMax ; i++) {
                    mArrayListRange.add(i);
                }

                Log.d("BBB",mArrayListRange.size() + "");

            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                // random
//                Random random = new Random();
//                int value = random.nextInt(sMax - sMin + 1) + sMin;
//                mKetQua += value + " - ";
//                mTvKetQua.setText(mKetQua);
            }
        });
    }
}