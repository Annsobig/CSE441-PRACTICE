package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {
    private EditText etFullName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        etFullName = findViewById(R.id.etFullName);
        etGPA = findViewById(R.id.etGPA);
        Button btnSendBack = findViewById(R.id.btnSendBack);

        //Xử lý sự kiện khi nhấn nút trả dữ liệu về activity cha
        btnSendBack.setOnClickListener(v -> {
//            @Override
//            public void onClick(View v) {
                //Lấy dữ liệu từ EditText
                String FullName = etFullName.getText().toString();
                double gpa = Double.parseDouble(etGPA.getText().toString());

                //Tạo Intent để trả về dữ liệu
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Ho va ten", FullName);
                resultIntent.putExtra("gpa", gpa);


                //Trả về dữ liệu
                setResult(RESULT_OK, resultIntent);

                //Kết thúc Activity con
                finish();
//            }
        });
    }
}
