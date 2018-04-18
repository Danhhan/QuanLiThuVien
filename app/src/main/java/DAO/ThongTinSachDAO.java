package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import DTO.ThongTinSach;
import Database.CreateDatabase;

/**
 * Created by Develop on 4/12/2018.
 */

public class ThongTinSachDAO {

    SQLiteDatabase database;

    public ThongTinSachDAO(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }
    public long ThemSach(ThongTinSach thongTinSach){
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_SACH_TENSACH,thongTinSach.getmTenSach());
        contentValues.put(CreateDatabase.TB_SACH_GIATIEN,thongTinSach.getmGiaTien());
        contentValues.put(CreateDatabase.TB_SACH_LOAISACH,thongTinSach.getmLoaiSach());
        long check=database.insert(CreateDatabase.TB_SACH,null,contentValues);
        Log.d("Check", String.valueOf(check));
        return check;
    }
    public List<ThongTinSach> LayDanhSach_Sach()
    {
        List<ThongTinSach> list=new ArrayList<>();
        String TruyVan="SELECT * FROM " + CreateDatabase.TB_SACH;
        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ThongTinSach thongTinSach=new ThongTinSach();
            thongTinSach.setmMasach(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_SACH_MASACH)));
            thongTinSach.setmTenSach(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_TENSACH)));
            thongTinSach.setmGiaTien(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_GIATIEN)));
            thongTinSach.setmLoaiSach(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_LOAISACH)));
            list.add(thongTinSach);
            cursor.moveToNext();
        }
        return list;
    }
    public List<ThongTinSach> LayDSTheoLoaiSach(String loaiSach)
    {
        List<ThongTinSach> list=new ArrayList<>();

        String TruyVan="SELECT * FROM " + CreateDatabase.TB_SACH + " WHERE " + CreateDatabase.TB_SACH_LOAISACH
                + " = '" + loaiSach + "'";
        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ThongTinSach thongTinSach=new ThongTinSach();

            thongTinSach.setmTenSach(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_TENSACH)));
            thongTinSach.setmGiaTien(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_GIATIEN)));
            thongTinSach.setmLoaiSach(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_LOAISACH)));
            list.add(thongTinSach);
            cursor.moveToNext();
        }
        return list;
    }
    public boolean BatLoiTrungSach(String TenSach){

        String TruyVan="SELECT * FROM " + CreateDatabase.TB_SACH + " WHERE " + CreateDatabase.TB_SACH_TENSACH
                + " = '" + TenSach + "'";
        Cursor cursor=database.rawQuery(TruyVan,null);
        if(cursor.getCount()!=0){
            return true;
        }else {
            return false;
        }
    }
    public boolean TimTenSach(String TenSach){

        String TruyVan="SELECT * FROM " + CreateDatabase.TB_SACH + " WHERE " + CreateDatabase.TB_SACH_TENSACH
                + " = '" + TenSach + "'";
        Cursor cursor=database.rawQuery(TruyVan,null);
        if(cursor.getCount()!=0){
            Log.d("check","ok");
            return true;
        }else {
            Log.d("check","no");
            return false;
        }
    }
    public boolean deteleteItem(int id){

        long kt= database.delete(CreateDatabase.TB_SACH,CreateDatabase.TB_SACH_MASACH + " = " + id,null);
        if(kt!=0){
            Log.d("ab","true");
            return true;
        }else {
            Log.d("ab","falsea");
            return false;
        }
    }
    public String layTenSach(int maDocgia){


        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_SACH + " WHERE " + CreateDatabase.TB_SACH_MASACH + " ='"
                + maDocgia + "'";
        String TenSach="";
        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            TenSach=cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SACH_TENSACH));
            cursor.moveToNext();
        }
        return TenSach;
    }

}
