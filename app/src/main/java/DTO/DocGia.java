package DTO;

/**
 * Created by Develop on 4/13/2018.
 */

public class DocGia {

    int mMaDocGia;
    String mHoTen,mNgaySinh,mNgheNghiep;

    public DocGia() {
    }

    public DocGia(int mMaDocGia, String mHoTen, String mNgaySinh, String mNgheNghiep) {
        this.mMaDocGia = mMaDocGia;
        this.mHoTen = mHoTen;
        this.mNgaySinh = mNgaySinh;
        this.mNgheNghiep = mNgheNghiep;
    }

    public int getmMaDocGia() {
        return mMaDocGia;
    }

    public void setmMaDocGia(int mMaDocGia) {
        this.mMaDocGia = mMaDocGia;
    }

    public String getmHoTen() {
        return mHoTen;
    }

    public void setmHoTen(String mHoTen) {
        this.mHoTen = mHoTen;
    }

    public String getmNgaySinh() {
        return mNgaySinh;
    }

    public void setmNgaySinh(String mNgaySinh) {
        this.mNgaySinh = mNgaySinh;
    }

    public String getmNgheNghiep() {
        return mNgheNghiep;
    }

    public void setmNgheNghiep(String mNgheNghiep) {
        this.mNgheNghiep = mNgheNghiep;
    }

    @Override
    public String toString() {
        return " Tên: " + mHoTen;
    }
}
