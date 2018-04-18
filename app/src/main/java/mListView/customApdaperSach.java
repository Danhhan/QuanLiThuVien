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

import DTO.ThongTinSach;

/**
 * Created by Develop on 4/12/2018.
 */

public class customApdaperSach extends ArrayAdapter<ThongTinSach>{

    Context context;
    int resource;
    List<ThongTinSach> list;
    public customApdaperSach(@NonNull Context context, int resource, @NonNull List<ThongTinSach> list) {

        super(context, resource, list);
        this.context=context;
        this.resource=resource;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Holder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.layout_custom_sach,parent,false);
            holder=new Holder();
            holder.txtTenSach=convertView.findViewById(R.id.txtTenSach);
            holder.txtGiaTien=convertView.findViewById(R.id.txtGiaTien);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        ThongTinSach thongTinSach=list.get(position);
        holder.txtTenSach.setText("Tên Sách : " + thongTinSach.getmTenSach());
        holder.txtGiaTien.setText("Giá Tiền : " + thongTinSach.getmGiaTien());

        return convertView;
    }

    public class Holder{
        TextView txtGiaTien;
        TextView txtTenSach;
    }
}
