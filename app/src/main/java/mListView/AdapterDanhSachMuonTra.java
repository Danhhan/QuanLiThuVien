package mListView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DAO.ThongtinMuonTraDAO;
import DTO.Thongtinmuontra;

/**
 * Created by Develop on 4/16/2018.
 */

public class AdapterDanhSachMuonTra extends ArrayAdapter<Thongtinmuontra> {

    Context context;
    int resource;
    List<Thongtinmuontra> list;

    ThongtinMuonTraDAO thongtinMuonTraDAO=new ThongtinMuonTraDAO(getContext());

    public AdapterDanhSachMuonTra(@NonNull Context context, int resource, @NonNull List<Thongtinmuontra> list) {
        super(context, resource, list);
        this.context=context;
        this.resource=resource;
        this.list=list;
    }
    public class ViewHolder{
        TextView txtChuaTra,txtDaTra,txtmMadocgia,txtmTenSach;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.layout_custom_thontinmuontra,parent,false);
            viewHolder=new ViewHolder();

            viewHolder.txtDaTra=convertView.findViewById(R.id.txtDaTra);
            viewHolder.txtmMadocgia=convertView.findViewById(R.id.txtmMaDoc);
            viewHolder.txtmTenSach=convertView.findViewById(R.id.txtmTenSach);

            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Thongtinmuontra thongtinmuontra=list.get(position);

        if(thongtinMuonTraDAO.UpdateTinhTrangMuonTra(thongtinmuontra.getmMaDocGia(),"false")){
            viewHolder.txtDaTra.setText("Chưa Trả");
        }else {
            viewHolder.txtDaTra.setText("cc");
        }

        viewHolder.txtmTenSach.setText("Mã Sách: "  + String.valueOf(thongtinmuontra.getmMaSach()));



        return convertView;
    }
}
