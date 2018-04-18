package DTO;

/**
 * Created by Develop on 4/14/2018.
 */


public class Thongtinmuontra {

    int mSTT,mMaDocGia,mMaSach;
    String NgayMuon,NgayTra,TinhTrang;

    public Thongtinmuontra() {
    }

    public int getmSTT() {
        return mSTT;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public void setmSTT(int mSTT) {
        this.mSTT = mSTT;
    }

    public int getmMaDocGia() {
        return mMaDocGia;
    }

    public void setmMaDocGia(int mMaDocGia) {
        this.mMaDocGia = mMaDocGia;
    }

    public int getmMaSach() {
        return mMaSach;
    }

    public void setmMaSach(int mMaSach) {
        this.mMaSach = mMaSach;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        NgayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String ngayTra) {
        NgayTra = ngayTra;
    }

    @Override
    public String toString() {
        return "Thongtinmuontra{" +
                "mSTT=" + mSTT +
                ", mMaDocGia=" + mMaDocGia +
                ", mMaSach=" + mMaSach +
                ", NgayMuon='" + NgayMuon + '\'' +
                ", NgayTra='" + NgayTra + '\'' +
                ", TinhTrang='" + TinhTrang + '\'' +
                '}';
    }
}
