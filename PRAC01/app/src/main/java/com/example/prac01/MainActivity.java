package com.example.prac01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE = 1;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        // Tìm kiếm TextView và thiết lập chuỗi tài nguyên
//        TextView tvResult = findViewById(R.id.tvResult);
//        tvResult.setText(getString(R.string.result_placeholder));

        tvResult = findViewById(R.id.tvResult);
        Button btnOpenChild = findViewById(R.id.btnOpenChild);

        btnOpenChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để mở Activity con
                Intent intent = new Intent(MainActivity.this, ChildActivity.class);
                // Bắt đầu Activity con
                startActivity(intent);
                //startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }
    //Nhận dữ liệu trả về từ Activity con
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

            if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
                //Lấy dữ liệu trả về từ Activity con
                String FullName = data.getStringExtra("FullName");
                double gpa = data.getDoubleExtra("gpa", 0.0);

                //Hiện thị dữ liệu lên textview
                tvResult.setText("Họ và tên: " + FullName + "\nGPA: " + gpa);
                           }
        }
    }