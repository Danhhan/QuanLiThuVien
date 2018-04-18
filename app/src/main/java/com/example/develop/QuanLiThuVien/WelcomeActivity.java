package com.example.develop.QuanLiThuVien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout ll1,ll2,bg;
    Button btnSignin,btnSignup;
    Animation uptodown,downtoup;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_welcome);
        btnSignin=findViewById(R.id.btnSignIn);
        btnSignup=findViewById(R.id.btnSignUp);
        bg=findViewById(R.id.bg);
        img=findViewById(R.id.img);
        ll1=findViewById(R.id.ll1);
        ll2=findViewById(R.id.ll2);
        uptodown= AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup= AnimationUtils.loadAnimation(this, R.anim.downtoup);
        ll1.setAnimation(uptodown);
        ll2.setAnimation(downtoup);
        btnSignup.setOnClickListener(this);
        btnSignin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id== R.id.btnSignIn){
            Intent iSignIn=new Intent(this,QuanLiThuVienSach.class);
            startActivity(iSignIn);
        }else {
            Intent iSignUp=new Intent(this,DangkyActivity.class);
            startActivity(iSignUp);
        }
    }
}

