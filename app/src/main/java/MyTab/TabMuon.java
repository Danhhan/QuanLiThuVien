package MyTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DAO.DocGiaDAO;
import DAO.ThongTinSachDAO;
import DAO.ThongtinMuonTraDAO;
import DTO.DocGia;
import DTO.ThongTinSach;
import DTO.Thongtinmuontra;
import MyFragment.DatePickerFragmentNgayMuon;
import MyFragment.DatePickerFragmentNgayTra;
import mListView.AdapterMaDocGia;
import mListView.AdapterMaSach;

/**
 * Created by Develop on 4/14/2018.
 */

public class TabMuon extends Fragment implements View.OnClickListener, View.OnFocusChangeListener{
    EditText edtTenSach,edtNgayMuon,edtNgayTra;
    EditText edtMadocgia;
    Button btnDongy,btnThoat;
    Spinner spMaDocgia,spMaSach;
    ThongTinSachDAO thongTinSachDAO;
    DocGia docGia;
    DocGiaDAO docGiaDAO;

    ThongtinMuonTraDAO thongtinMuonTraDAO;
    ThongTinSach thongTinSach;
    List<DocGia> listMaDocGia;
    List<ThongTinSach> listsach;
    AdapterMaSach adapterMaSach;
    AdapterMaDocGia adapterMaDocGia;
    private int maDocGia,maSach;
    private String name,res;
    public static int REQUEST_CODE_MADOCGIA=113;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_muonsach,container,false);

        thongTinSachDAO=new ThongTinSachDAO(getActivity());
        docGiaDAO=new DocGiaDAO(getActivity());
        docGia=new DocGia();
        thongtinMuonTraDAO=new ThongtinMuonTraDAO(getActivity());
        spMaDocgia=view.findViewById(R.id.spMadocgia);
        spMaSach=view.findViewById(R.id.spMaSach);
        edtTenSach=view.findViewById(R.id.edtTenSach);
        edtMadocgia=view.findViewById(R.id.edtTenDocGia);
        edtNgayMuon=view.findViewById(R.id.edtNgayMuon);
        edtNgayTra=view.findViewById(R.id.edtNgayTra);
        btnDongy=view.findViewById(R.id.btnYes);

        //btnThoat=view.findViewById(R.id.btnExt);

        listMaDocGia=docGiaDAO.layMaDocGia();
        adapterMaDocGia=new AdapterMaDocGia(getActivity(),R.layout.adaptermadocgia,listMaDocGia);
        spMaDocgia.setAdapter(adapterMaDocGia);
        adapterMaDocGia.notifyDataSetChanged();
        spMaDocgia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maDocGia=listMaDocGia.get(i).getmMaDocGia();
                name=docGiaDAO.layTenDocgia(maDocGia);
                edtMadocgia.setText(name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        listsach=thongTinSachDAO.LayDanhSach_Sach();
        adapterMaSach=new AdapterMaSach(getActivity(),R.layout.adaptermasach,listsach);
        spMaSach.setAdapter(adapterMaSach);
        adapterMaSach.notifyDataSetChanged();
        spMaSach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maSach=listsach.get(i).getmMasach();
                res=thongTinSachDAO.layTenSach(maSach);
                edtTenSach.setText(res);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnDongy.setOnClickListener(this);
        //btnThoat.setOnClickListener(this);

        edtNgayMuon.setOnFocusChangeListener(this);
        edtNgayTra.setOnFocusChangeListener(this);
        return view;
    }



    @Override
    public void onFocusChange(View view, boolean b) {
        int id=view.getId();
        switch (id){
            case R.id.edtNgayMuon:
                if(b){
                    DatePickerFragmentNgayMuon datePickerFragmentNgayMuon=new DatePickerFragmentNgayMuon();
                    datePickerFragmentNgayMuon.show(getFragmentManager(),"Ngày Mượn");
                }
                break;

            case R.id.edtNgayTra:
                if(b){
                    DatePickerFragmentNgayTra datePickerFragmentNgayTra=new DatePickerFragmentNgayTra();
                    datePickerFragmentNgayTra.show(getFragmentManager(),"Ngày Trả");
                }
                break;
        }
    }
    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){

            case R.id.btnYes:

                Thongtinmuontra thongtinmuontra=new Thongtinmuontra();
                String ngaymuon=edtNgayMuon.getText().toString();
                String ngaytra=edtNgayTra.getText().toString();

                thongtinmuontra.setmMaDocGia(maDocGia);
                thongtinmuontra.setmMaSach(maSach);
                thongtinmuontra.setNgayMuon(ngaymuon);
                thongtinmuontra.setNgayTra(ngaytra);
                thongtinmuontra.setTinhTrang("false");//cho mượn tức là chưa trả thì là false;
                long add=thongtinMuonTraDAO.ThemMuonSach(thongtinmuontra);
                if(add>0){
                    Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                    Log.d("check", String.valueOf(thongtinMuonTraDAO.layThontinmuontra()));
                }else {
                    Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
