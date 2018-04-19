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
import mListView.AdapterMaDocGia;
import mListView.AdapterMaSach;



public class TabTra extends Fragment {

    EditText edtTenSach;
    EditText edtMadocgia;
    Button btnDongy;
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
    List<Thongtinmuontra> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.layout_trasach,container,false);

        thongTinSachDAO=new ThongTinSachDAO(getActivity());
        docGiaDAO=new DocGiaDAO(getActivity());
        docGia=new DocGia();
        thongtinMuonTraDAO=new ThongtinMuonTraDAO(getActivity());
        spMaDocgia=view.findViewById(R.id.spMadocgia);
        spMaSach=view.findViewById(R.id.spMaSach);
        edtTenSach=view.findViewById(R.id.edtTenSach);
        edtMadocgia=view.findViewById(R.id.edtTenDocGia);

        btnDongy=view.findViewById(R.id.btnXacNhan);

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
        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean kiemtra=thongtinMuonTraDAO.UpdateTinhTrangMuonTra(maDocGia,"true");
                if(kiemtra){
                    Toast.makeText(getActivity(), "xác nhận trả thành công", Toast.LENGTH_SHORT).show();
                    Log.d("xacnhan", String.valueOf(list));
                }else {
                    Toast.makeText(getActivity(), "xác nhận trả thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
