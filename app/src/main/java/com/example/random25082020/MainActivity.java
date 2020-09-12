package com.example.random25082020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSoMin, mEdtSoMax;
    Button mBtnRandom, mBtnReset, mBtnAddRange;
    TextView mTvKetQua;
    List<Integer> mArrayListRange;
    String mTextSoMin = "";
    String mtextSoMax = "";
    String mKetQua = "";
    Random mRandom;
    int mSMin = 0;
    int mSMax = 0;
    int mIndexRandom = -1;
    int mValueRandom = -1;
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
        mRandom = new Random();

        disableView(mBtnRandom);

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
                if (mSMin >= mSMax) {
                    mSMax = mSMin + 1;
                }
                mEdtSoMax.setText(String.valueOf(mSMax));
                mEdtSoMin.setText(String.valueOf(mSMin));

                mArrayListRange.clear();

                for (int i = mSMin; i <= mSMax; i++) {
                    mArrayListRange.add(i);
                }
                disableView(mBtnAddRange);
                disableView(mEdtSoMax);
                disableView(mEdtSoMin);
                enableView(mBtnRandom);
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 : clear mArrayListRange , setEdittext lại thành chuỗi rỗng
                mArrayListRange.clear();
                mEdtSoMin.setText("");
                mEdtSoMax.setText("");
                // 2 : Bật tính năng lại cho edt , btnAddRange
                enableView(mEdtSoMin);
                enableView(mEdtSoMax);
                enableView(mBtnAddRange);
                // 3 : Ẩn tính năng random
                disableView(mBtnRandom);
                // 4 : setText cho kết quả nếu kết quả có tồn tại

            }
        });

        mBtnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mArrayListRange.size() > 0){
                    mIndexRandom = mRandom.nextInt(mArrayListRange.size());
                    mValueRandom = mArrayListRange.get(mIndexRandom);
                    mKetQua += mArrayListRange.size() != 1 ? mValueRandom + " - " : mValueRandom;
                    mTvKetQua.setText(mKetQua);
                    mArrayListRange.remove(mIndexRandom);
                }else{
                    Toast.makeText(MainActivity.this, "Het gia tri random", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    // Hàm :
    //   + Tái sử dụng lại code
    //   + Dễ sử dụng

    // private : Phạm vi hoạt động
    // void : Giá trị trả về (void là kiểu dữ liệu đặc biệt không cần trả về)
    // enableView : tên phương thức
    // trong () : tham số truyền vào
    private void enableView(View v) {
        v.setEnabled(true);
    }

    private void disableView(View v) {
        v.setEnabled(false);
    }

}