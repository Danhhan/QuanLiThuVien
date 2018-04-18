package MyTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DAO.ThongtinMuonTraDAO;
import DTO.Thongtinmuontra;
import mListView.AdapterDanhSachMuonTra;

/**
 * Created by Develop on 4/15/2018.
 */

public class TabXemDSMuonTraSach extends Fragment {
    ListView lvDSmuontra;
    ThongtinMuonTraDAO thongtinMuonTraDAO;
    List<Thongtinmuontra> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.layout_tabdsmuontrasach,container,false);
        lvDSmuontra=view.findViewById(R.id.lvDSmuontra);
        thongtinMuonTraDAO=new ThongtinMuonTraDAO(getActivity());
        list=thongtinMuonTraDAO.layThontinmuontra();
        AdapterDanhSachMuonTra adapterDanhSachMuonTra=new AdapterDanhSachMuonTra(getActivity(),R.layout.layout_custom_thontinmuontra,list);
        lvDSmuontra.setAdapter(adapterDanhSachMuonTra);
        adapterDanhSachMuonTra.notifyDataSetChanged();
        return view;
    }
}
