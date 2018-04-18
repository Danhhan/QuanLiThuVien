package com.example.develop.QuanLiThuVien;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import MyFragment.AboutFragment;
import MyFragment.QuanLiDocGia;
import MyFragment.QuanLiSachFragment;
import MyFragment.QuanLiTraMuonSach;
import MyFragment.TrangChuFragment;

/**
 * Created by Develop on 3/24/2018.
 */

public class QuanLiThuVienSach extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    TextView txtTenDangnhap;
    FragmentManager fragmentManager;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutquanlithuvien);
        drawerLayout=findViewById(R.id.DrawerLayout);
        navigationView=findViewById(R.id.navigationview);
        toolbar=findViewById(R.id.Toolbar);


        View view= navigationView.inflateHeaderView(R.layout.headerlayout);
        txtTenDangnhap=(TextView) view.findViewById(R.id.txtTendangnhap);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.mo, R.string.dong){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        drawerToggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        navigationView.setItemIconTintList(null);

        navigationView.setNavigationItemSelectedListener(this);
//        Intent intent=getIntent();
//        String tenDn=intent.getStringExtra("tenDn");
//        Log.d("kiemtra",tenDn);
//        txtTenDangnhap.setText(tenDn);
        //AdapterRv();

        fragmentManager=getSupportFragmentManager();
        FragmentTransaction tranTranChu =fragmentManager.beginTransaction();
        TrangChuFragment trangChuActivity=new TrangChuFragment();
        tranTranChu.replace(R.id.content,trangChuActivity);
        tranTranChu.commit();

        getSupportActionBar().setTitle("Trang Chủ");
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.itemTrangChu:
                FragmentTransaction tranTranChu =fragmentManager.beginTransaction();
                TrangChuFragment trangChuActivity=new TrangChuFragment();
                tranTranChu.replace(R.id.content,trangChuActivity);
                tranTranChu.commit();
                item.setChecked(true);
                getSupportActionBar().setTitle("Trang Chủ");
                drawerLayout.closeDrawers();
                break;
            case R.id.itemTraMuon:
                FragmentTransaction tranQuanlitramuon= fragmentManager.beginTransaction();
                QuanLiTraMuonSach qliTramuon= new QuanLiTraMuonSach();
                tranQuanlitramuon.replace(R.id.content,qliTramuon);
                tranQuanlitramuon.commit();
                item.setChecked(true);
                getSupportActionBar().setTitle("Quản Lí Trả Mượn Sách");

                drawerLayout.closeDrawers();
                break;
            case R.id.itemSach:
                FragmentTransaction tranHienThiSach= fragmentManager.beginTransaction();
                QuanLiSachFragment qliSach= new QuanLiSachFragment();
                tranHienThiSach.replace(R.id.content,qliSach);
                tranHienThiSach.commit();
                item.setChecked(true);
                getSupportActionBar().setTitle("Quản Lí Sách");
                drawerLayout.closeDrawers();
                break;

            case R.id.itemDocGia:
                FragmentTransaction tranDocGia= fragmentManager.beginTransaction();
                QuanLiDocGia qliDocGia= new QuanLiDocGia();
                tranDocGia.replace(R.id.content,qliDocGia);
                tranDocGia.commit();
                item.setChecked(true);
                getSupportActionBar().setTitle("Quản Lí Độc Giả");
                drawerLayout.closeDrawers();
                break;
            case R.id.itemGioiThieu:
                FragmentTransaction tranGioiThieu= fragmentManager.beginTransaction();
                AboutFragment aboutFragment= new AboutFragment();
                tranGioiThieu.replace(R.id.content,aboutFragment);
                tranGioiThieu.commit();
                item.setChecked(true);
                getSupportActionBar().setTitle("Giới Thiệu");
                drawerLayout.closeDrawers();
                break;
            case R.id.itemExit:

                System.exit(0);
                finish();
                break;
        }
        return false;
    }



}
