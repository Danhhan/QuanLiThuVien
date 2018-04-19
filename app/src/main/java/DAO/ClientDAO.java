package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import DTO.ClientDTO;
import Database.CreateDatabase;


public class ClientDAO {
    SQLiteDatabase database;

    public ClientDAO(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }
    public long ThemUseres(ClientDTO clientDTO)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_USER_NAME,clientDTO.getName_user());
        contentValues.put(CreateDatabase.TB_USER_PWD,clientDTO.getPwd_user());
        contentValues.put(CreateDatabase.TB_USER_EMAIL,clientDTO.getEmail_user());
        contentValues.put(CreateDatabase.TB_USER_PHONE,clientDTO.getPhone_user());
        long check=database.insert(CreateDatabase.TB_USER,null,contentValues);
        return check;
    }
    public boolean BatLoiTrungTK(String mTaiKhoan){
        String TruyVan="SELECT * FROM " + CreateDatabase.TB_USER + " WHERE " + CreateDatabase.TB_USER_NAME + " = '" + mTaiKhoan
                + "'";
        Cursor cursor=database.rawQuery(TruyVan,null);
        if(cursor.getCount()!=0){
            return true;
        }else {
            return false;
        }
    }
    public boolean KiemtraDangNhap(String mTaiKhoan,String mMk){
        String TruyVan="SELECT * FROM " + CreateDatabase.TB_USER + " WHERE " + CreateDatabase.TB_USER_NAME + " = '" + mTaiKhoan
                + "' AND " + CreateDatabase.TB_USER_PWD + " = '" + mMk + "'" ;
        Cursor cursor=database.rawQuery(TruyVan,null);
        if(cursor.getCount()!=0){
            return true;
        }else {
            return false;
        }
    }

}
