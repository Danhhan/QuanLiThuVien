package mListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.develop.QuanLiThuVien.R;

/**
 * Created by Develop on 3/26/2018.
 */

public class myHolder {

    TextView nameTxt;
    ImageView book1,book2,book3;

    public myHolder(View v) {
        nameTxt=v.findViewById(R.id.txtTuaDeSach);
        book1=v.findViewById(R.id.book1);
        book2=v.findViewById(R.id.book2);
        book3=v.findViewById(R.id.book3);
    }
}
