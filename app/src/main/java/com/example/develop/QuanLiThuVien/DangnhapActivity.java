package com.example.develop.QuanLiThuVien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DAO.ClientDAO;

/**
 * Created by Develop on 3/24/2018.
 */

public class DangnhapActivity extends AppCompatActivity {
    EditText edtTaikhoan,edtMatkhau;
    Button btnDangNhap;
    ClientDAO clientDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        edtTaikhoan=findViewById(R.id.edtTaiKhoan);
        edtMatkhau=findViewById(R.id.edtMatKhau);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        clientDAO=new ClientDAO(this);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mTaiKhoan=edtTaikhoan.getText().toString().trim();
                String mMatKhau=edtMatkhau.getText().toString().trim();
                boolean kiemtra=clientDAO.KiemtraDangNhap(mTaiKhoan,mMatKhau);
                if(kiemtra){
                    Toast.makeText(DangnhapActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    Intent iTranChu=new Intent(DangnhapActivity.this,QuanLiThuVienSach.class);
                    iTranChu.putExtra("tenDn",mTaiKhoan);

                    startActivity(iTranChu);

                }else {
                    Toast.makeText(DangnhapActivity.this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
