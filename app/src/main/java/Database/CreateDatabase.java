package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Develop on 3/24/2018.
 */

public class CreateDatabase extends SQLiteOpenHelper {

    public static final String TB_USER="USER";

    public static final String TB_USER_ID="ID";
    public static final String TB_USER_NAME="NAME";
    public static final String TB_USER_PWD="PWD";
    public static final String TB_USER_EMAIL="EMAIL";
    public static final String TB_USER_PHONE="PHONE";

    public static final String TB_KHOSACH="KHOSACH";

    public static final String TB_KHOSACH_MAKHO="MAKHO";
    public static final String TB_KHOSACH_TENKHO="TENKHO";
    public static final String TB_KHOSACH_GHICHU="GHICHU";

    public static final String TB_SACH="SACH";

    public static final String TB_SACH_MASACH="MASACH";
    public static final String TB_SACH_TENSACH="TENSACH";
    public static final String TB_SACH_GIATIEN="GIATIEN";
    public static final String TB_SACH_LOAISACH="LOAISACH";

    public static final String TB_DOCGIA="DOCGIA";

    public static final String TB_DOCGIA_MADOCGIA="MADOCGIA";
    public static final String TB_DOCGIA_HOTEN="HOTEN";
    public static final String TB_DOCGIA_NGAYSINH="NGAYSINH";
    public static final String TB_DOCGIA_NGHENGHIEP="NGHENGHIEP";
    public static final String TB_MUONTRA="MUONTRA";

    public static final String TB_MUONTRA_STT="STT";
    public static final String TB_MUONTRA_MADOCGIA="MADOCGIA";
    public static final String TB_MUONTRA_NGAYMUON="NGAYMUON";
    public static final String TB_MUONTRA_NGAYTRA="NGAYTRA";
    public static final String TB_MUONTRA_TINHTRANG="TINHTRANG";
    public static final String TB_MUONTRA_MASACH="MASACH";

    public CreateDatabase(Context context) {
        super(context, "tinhtrangfal", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String tb_USER= "CREATE TABLE " + TB_USER + " ( " + TB_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_USER_NAME + " TEXT, " + TB_USER_PWD + " TEXT, " + TB_USER_EMAIL + " TEXT, " + TB_USER_PHONE + " TEXT )";

        String tb_KHOSACH= "CREATE TABLE " + TB_KHOSACH + " ( " + TB_KHOSACH_MAKHO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_KHOSACH_TENKHO + " TEXT, " + TB_KHOSACH_GHICHU + " TEXT )";

        String tb_SACH= "CREATE TABLE " + TB_SACH + " ( " +TB_SACH_MASACH + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_SACH_TENSACH + " TEXT, " + TB_SACH_GIATIEN + " TEXT, " + TB_SACH_LOAISACH + " TEXT )";

        String tb_DOCGIA= "CREATE TABLE " + TB_DOCGIA + " ( " + TB_DOCGIA_MADOCGIA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_DOCGIA_HOTEN + " TEXT, " + TB_DOCGIA_NGAYSINH + " TEXT, " + TB_DOCGIA_NGHENGHIEP + " TEXT )";

        String tb_MUONTRA = " CREATE TABLE " + TB_MUONTRA + " ( " + TB_MUONTRA_STT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_MUONTRA_MADOCGIA + " INTEGER, " + TB_MUONTRA_NGAYMUON + " TEXT, " + TB_MUONTRA_NGAYTRA + " TEXT, "
                + TB_MUONTRA_TINHTRANG + " TEXT, " + TB_MUONTRA_MASACH + " INTEGER )";

        db.execSQL(tb_USER);
        db.execSQL(tb_KHOSACH);
        db.execSQL(tb_SACH);
        db.execSQL(tb_DOCGIA);
        db.execSQL(tb_MUONTRA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public SQLiteDatabase Open(){
        return this.getWritableDatabase();
    }
}
