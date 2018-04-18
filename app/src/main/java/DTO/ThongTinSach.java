package DTO;

/**
 * Created by Develop on 4/12/2018.
 */

public class ThongTinSach {
    int mMasach;
    String mTenSach,mGiaTien,mLoaiSach;

    public ThongTinSach() {
    }

    public int getmMasach() {
        return mMasach;
    }

    public void setmMasach(int mMasach) {
        this.mMasach = mMasach;
    }

    public String getmTenSach() {
        return mTenSach;
    }

    public void setmTenSach(String mTenSach) {
        this.mTenSach = mTenSach;
    }

    public String getmGiaTien() {
        return mGiaTien;
    }

    public void setmGiaTien(String mGiaTien) {
        this.mGiaTien = mGiaTien;
    }

    public String getmLoaiSach() {
        return mLoaiSach;
    }

    public void setmLoaiSach(String mLoaiSach) {
        this.mLoaiSach = mLoaiSach;
    }

    @Override
    public String toString() {
        return "Tên Sách : " +mTenSach;
    }
}
