package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import DTO.DocGia;
import Database.CreateDatabase;

/**
 * Created by Develop on 4/13/2018.
 */

public class DocGiaDAO {

    SQLiteDatabase database;

    public DocGiaDAO(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }
    public long ThemDocGia(DocGia docGia){
        ContentValues contentValues=new ContentValues();
        //contentValues.put(CreateDatabase.TB_DOCGIA_MADOCGIA,docGia.getmMaDocGia());
        contentValues.put(CreateDatabase.TB_DOCGIA_HOTEN,docGia.getmHoTen());
        contentValues.put(CreateDatabase.TB_DOCGIA_NGAYSINH,docGia.getmNgaySinh());
        contentValues.put(CreateDatabase.TB_DOCGIA_NGHENGHIEP,docGia.getmNgheNghiep());
        long check=database.insert(CreateDatabase.TB_DOCGIA,null,contentValues);

        return check;
    }
    public List<DocGia> layMaDocGia(){

        List<DocGia> list=new ArrayList<>();

        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_DOCGIA;
        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            DocGia docGia=new DocGia();
            docGia.setmMaDocGia(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_DOCGIA_MADOCGIA)));
            docGia.setmHoTen(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_DOCGIA_HOTEN)));
            docGia.setmNgheNghiep(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_DOCGIA_NGHENGHIEP)));
            docGia.setmNgaySinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_DOCGIA_NGAYSINH)));
            list.add(docGia);
            cursor.moveToNext();
        }
        return list;
    }
    public String layTenDocgia(int maDocgia){


        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_DOCGIA + " WHERE " + CreateDatabase.TB_DOCGIA_MADOCGIA + " ='"
                + maDocgia + "'";
        String TenDocGia="";
        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            TenDocGia=cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_DOCGIA_HOTEN));
            cursor.moveToNext();
        }
        return TenDocGia;
    }



}
