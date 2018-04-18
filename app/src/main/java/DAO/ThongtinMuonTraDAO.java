package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import DTO.Thongtinmuontra;
import Database.CreateDatabase;

/**
 * Created by Develop on 4/14/2018.
 */

public class ThongtinMuonTraDAO {

    SQLiteDatabase database;

    public ThongtinMuonTraDAO(Context context)
    {
        CreateDatabase createDatabase=new CreateDatabase(context);
        database=createDatabase.Open();
    }

    public long ThemMuonSach(Thongtinmuontra thongtinmuontra){
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_MUONTRA_MADOCGIA,thongtinmuontra.getmMaDocGia());
        contentValues.put(CreateDatabase.TB_MUONTRA_MASACH,thongtinmuontra.getmMaSach());
        contentValues.put(CreateDatabase.TB_MUONTRA_NGAYMUON,thongtinmuontra.getNgayMuon());
        contentValues.put(CreateDatabase.TB_MUONTRA_NGAYTRA,thongtinmuontra.getNgayTra());
        contentValues.put(CreateDatabase.TB_MUONTRA_TINHTRANG,thongtinmuontra.getTinhTrang());
        long check=database.insert(CreateDatabase.TB_MUONTRA,null,contentValues);
        Log.d("check", String.valueOf(check));
        return check;
    }

    public List<Thongtinmuontra> layThontinmuontra(){

        List<Thongtinmuontra> list=new ArrayList<>();

        String TruyVan=" SELECT * FROM " + CreateDatabase.TB_MUONTRA;
        Cursor cursor=database.rawQuery(TruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Thongtinmuontra thongtinmuontra=new Thongtinmuontra();
            thongtinmuontra.setmSTT(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_STT)));
            thongtinmuontra.setmMaSach(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_MASACH)));
            thongtinmuontra.setmMaDocGia(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_MADOCGIA)));
            thongtinmuontra.setNgayMuon(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_NGAYMUON)));
            thongtinmuontra.setNgayTra(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_NGAYTRA)));
            thongtinmuontra.setTinhTrang(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_TINHTRANG)));
            list.add(thongtinmuontra);
            cursor.moveToNext();
        }
        return list;
    }
    public boolean UpdateTinhTrangMuonTra(int maDocGia,String tinhtrang){
        ContentValues contentValues=new ContentValues();
        contentValues.put(CreateDatabase.TB_MUONTRA_TINHTRANG,tinhtrang);
        long kiemtra=database.update(CreateDatabase.TB_MUONTRA,contentValues,CreateDatabase.TB_DOCGIA_MADOCGIA + " = '" +
        maDocGia + "'",null);
        if(kiemtra!=0){
            return true;
        }else {
            return false;
        }
    }
    public String ThongBaoTinhTrang(String tinhtrang){

        String tv=" SELECT * FROM " + CreateDatabase.TB_MUONTRA + " WHERE " + " = '" + tinhtrang + "'";

        String kt="";
        
        Cursor cursor=database.rawQuery(tv,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Thongtinmuontra thongtinmuontra=new Thongtinmuontra();
            kt=cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_MUONTRA_TINHTRANG));
        }
        return kt;

    }


}
