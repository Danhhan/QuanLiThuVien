package com.example.develop.QuanLiThuVien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DAO.ClientDAO;
import DTO.ClientDTO;

/**
 * Created by Develop on 3/24/2018.
 */

public class DangkyActivity extends AppCompatActivity {

    EditText edtTendangnhap,edtMk,edtEmail,edtPhone;
    Button btnDongY;
    ClientDAO clientDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);
        edtTendangnhap=findViewById(R.id.edtTendangnhap);
        edtMk=findViewById(R.id.edtMk);
        edtEmail=findViewById(R.id.edtEmail);
        edtPhone=findViewById(R.id.edtPhone);
        btnDongY=findViewById(R.id.btnDongY);
        clientDAO=new ClientDAO(this);

        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mTendangnhap=edtTendangnhap.getText().toString().trim();
                String mMk=edtMk.getText().toString().trim();
                String mEmail=edtEmail.getText().toString().trim();
                String mPhone=edtPhone.getText().toString().trim();

                if(mTendangnhap==null || mTendangnhap.equals("")){
                    Toast.makeText(DangkyActivity.this, "Vui Long nhap ten dang nhap", Toast.LENGTH_SHORT).show();
                }else if(mMk==null || mMk.equals("")){
                    Toast.makeText(DangkyActivity.this, "Vui long nhap mat khau", Toast.LENGTH_SHORT).show();
                }else if(clientDAO.BatLoiTrungTK(mTendangnhap)){
                    Toast.makeText(DangkyActivity.this, "Tai Khoan da ton tai", Toast.LENGTH_SHORT).show();
                }
                else {
                    ClientDTO clientDTO=new ClientDTO();
                    clientDTO.setName_user(mTendangnhap);
                    clientDTO.setPwd_user(mMk);
                    clientDTO.setEmail_user(mEmail);
                    clientDTO.setPhone_user(mPhone);

                    long kiemtra=clientDAO.ThemUseres(clientDTO);
                    if(kiemtra!=0){
                        Toast.makeText(DangkyActivity.this, "Dang ky thanh cong " , Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(DangkyActivity.this,DangnhapActivity.class);
//                        startActivity(intent);


                    }else {
                        Toast.makeText(DangkyActivity.this, "Dang ky that bai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
