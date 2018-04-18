package MyFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.develop.QuanLiThuVien.R;

import mData.TVShowCollection;
import mListView.CustomAdapter;

/**
 * Created by Develop on 4/13/2018.
 */

public class TrangChuFragment extends Fragment {
    ListView lvItem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.layouttrangchu,container,false);

         lvItem=view.findViewById(R.id.lvtrangchu);

        CustomAdapter customAdapter=new CustomAdapter(getActivity(), TVShowCollection.getTVShows());
        lvItem.setAdapter(customAdapter);
        return view;
    }
}
