package MyTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DAO.ThongTinSachDAO;
import DTO.ThongTinSach;
import mListView.customApdaperSach;


public class TabThonTinSach extends Fragment {
    Button btnGo;
    ThongTinSachDAO thongTinSachDAO;
    Spinner spLoaisach;
    ListView lvSach;
    customApdaperSach sach;
    List<ThongTinSach> list;
    int pos=0;
    public TabThonTinSach() {

        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.layout_tab_danhmucsach,container,false);

        thongTinSachDAO=new ThongTinSachDAO(getActivity());

        spLoaisach=view.findViewById(R.id.spDsLoaiSach);
        lvSach=view.findViewById(R.id.lvSach);

        ArrayAdapter<CharSequence> arrayAdapter1=ArrayAdapter.createFromResource(getActivity(),R.array.arr5,R.layout.item);
        spLoaisach.setAdapter(arrayAdapter1);

        list=thongTinSachDAO.LayDanhSach_Sach();
        SetAdapter();


        spLoaisach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                switch (pos){
                    case 0:
                        list=thongTinSachDAO.LayDanhSach_Sach();

                        SetAdapter();
                        break;
                    case 1:
                        list=thongTinSachDAO.LayDSTheoLoaiSach("Ngôn Tình");
                        SetAdapter();
                        break;
                    case 2:
                        list=thongTinSachDAO.LayDSTheoLoaiSach("Công Nghệ Thông Tin");

                        SetAdapter();
                        break;
                    case 3:
                        list=thongTinSachDAO.LayDSTheoLoaiSach("Kinh Tế");

                        SetAdapter();
                        break;
                    case 4:

                        list=thongTinSachDAO.LayDSTheoLoaiSach("Khoa Học");
                        SetAdapter();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        EventClick();


        return view;
    }
    public void SetAdapter(){
        sach=new customApdaperSach(getActivity(),R.layout.layout_custom_sach,list);
        lvSach.setAdapter(sach);
        sach.notifyDataSetChanged();
    }
    public void Delete(int position){
        int vitri=list.get(position).getmMasach();
        boolean check=thongTinSachDAO.deteleteItem(vitri);
        if (check){
            Toast.makeText(getActivity(), "Xóa Thành Công", Toast.LENGTH_SHORT).show();
            list=thongTinSachDAO.LayDanhSach_Sach();
            SetAdapter();
        }else {
            Toast.makeText(getActivity(), "Xóa Thất Bại", Toast.LENGTH_SHORT).show();
        }
    }
    public void EventClick(){
        lvSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Delete(i);
                return false;
            }
        });
    }
}
