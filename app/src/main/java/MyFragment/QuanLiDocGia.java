package MyFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DAO.DocGiaDAO;
import DTO.DocGia;

/**
 * Created by Develop on 4/13/2018.
 */

public class QuanLiDocGia extends Fragment implements View.OnFocusChangeListener {

    EditText edtHoTen,edtNgaySinh,edtNgheNghiep;
    Button btthemDocGia;
    DocGiaDAO docGiaDAO;
    List<DocGia> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_quanlidocgia,container,false);
        docGiaDAO=new DocGiaDAO(getContext());
        edtHoTen=view.findViewById(R.id.edtHoTenDocGia);
        edtNgaySinh=view.findViewById(R.id.edtNgaySinh);
        edtNgheNghiep=view.findViewById(R.id.edtNgheNghiep);
        btthemDocGia=view.findViewById(R.id.btnThemDocGia);
        edtNgaySinh.setOnFocusChangeListener(this);

        list=docGiaDAO.layMaDocGia();
        Log.d("list", String.valueOf(list));
        btthemDocGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DocGia docGia=new DocGia();
                docGia.setmHoTen(edtHoTen.getText().toString().trim());
                docGia.setmNgaySinh(edtNgaySinh.getText().toString().trim());
                docGia.setmNgheNghiep(edtNgheNghiep.getText().toString().trim());
                long check=docGiaDAO.ThemDocGia(docGia);
                Intent idulieu=new Intent();
                idulieu.putExtra("kiemtra",check);
                getActivity().setResult(Activity.RESULT_OK,idulieu);
                if(check>0){
                    Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Thêm Thất Bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        int id=view.getId();
        if(id==R.id.edtNgaySinh){
            if(b){
                DatePickerFragment datePickerFragment=new DatePickerFragment();
                datePickerFragment.show(getFragmentManager(),"Ngày Sinh");

            }
        }
    }
}
