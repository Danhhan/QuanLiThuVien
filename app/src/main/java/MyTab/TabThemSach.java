package MyTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DAO.ThongTinSachDAO;
import DTO.ThongTinSach;



public class TabThemSach extends Fragment {

    public TabThemSach() {
        // Required empty public constructor

    }
    EditText edtTenSach,edtGiaTien;
    Spinner spLoaiSach;
    Button btnThemSach;
    ThongTinSachDAO thongTinSachDAO;
    List<ThongTinSach> list;
    //boolean check=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View view=inflater.inflate(R.layout.layout_tab_themsach,container,false);

        thongTinSachDAO=new ThongTinSachDAO(getActivity());

        edtTenSach=view.findViewById(R.id.edtTenSach);
        edtGiaTien=view.findViewById(R.id.edtGiaTien);
        spLoaiSach=view.findViewById(R.id.SpLoaiSach);
        btnThemSach=view.findViewById(R.id.btnThemSch);

        ArrayAdapter<CharSequence> arrayAdapter1=ArrayAdapter.createFromResource(getActivity(),R.array.arr4,R.layout.item);
        spLoaiSach.setAdapter(arrayAdapter1);



        btnThemSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinSach thongTinSach=new ThongTinSach();


                String tenSach=edtTenSach.getText().toString().trim();
                String GiaTien=edtGiaTien.getText().toString().trim();
                String LoaiSach=spLoaiSach.getSelectedItem().toString();
                    thongTinSach.setmTenSach(tenSach);
                    thongTinSach.setmGiaTien(GiaTien);
                    thongTinSach.setmLoaiSach(LoaiSach);
                    long check1=thongTinSachDAO.ThemSach(thongTinSach);
                    if (check1!=0){
                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
//                        edtTenSach.setText("");
//                        edtGiaTien.setText("");
                        //Toast.makeText(getContext(), ""+thongTinSachDAO.LayDanhSach_Sach(), Toast.LENGTH_SHORT).show();
                        Log.d("kiemtranao", String.valueOf(thongTinSachDAO.LayDanhSach_Sach()));

                    }else {
                        Log.d("kiemtra","False");
                    }

            }
        });
        return view;
    }
}
