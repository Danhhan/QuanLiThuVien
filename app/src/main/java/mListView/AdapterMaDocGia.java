package mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.develop.QuanLiThuVien.R;

import java.util.List;

import DTO.DocGia;



public class AdapterMaDocGia extends BaseAdapter {

    Context context;
    int layout;
    List<DocGia> list;
    ViewHolder viewHolder;
    public AdapterMaDocGia(Context context, int layout, List<DocGia> list){
        this.context=context;
        this.layout=layout;
        this.list=list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getmMaDocGia();
    }
    public class ViewHolder{
        TextView tvMaDocGia;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=view;
        if (view1==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view1=inflater.inflate(R.layout.adaptermadocgia,viewGroup,false);
            viewHolder.tvMaDocGia=view1.findViewById(R.id.tvMaDocGia);

            view1.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view1.getTag();
        }

        DocGia docGia=list.get(i);

        viewHolder.tvMaDocGia.setText("Mã đọc giả: " + String.valueOf(docGia.getmMaDocGia()));

        //viewHolder.tvMaDocGia.setText(docGia.getmHoTen());

        return view1;
    }
}
