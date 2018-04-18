package mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.develop.QuanLiThuVien.R;

import java.util.ArrayList;

import MyPicasso.PicassoClient;
import mData.TVShow;

/**
 * Created by Develop on 3/26/2018.
 */

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<TVShow> tvShows;
    LayoutInflater inflater;
    public CustomAdapter(Context c, ArrayList<TVShow> tvShows) {
        this.c = c;
        this.tvShows = tvShows;
    }

    @Override
    public int getCount() {
        return tvShows.size();
    }

    @Override
    public Object getItem(int i) {
        return tvShows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater==null){
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view==null){
            view=inflater.inflate(R.layout.custom_rv,viewGroup,false);


        }

        myHolder mHolder=new myHolder(view);
        mHolder.nameTxt.setText(tvShows.get(i).getName());
        PicassoClient.downloadImage(c,tvShows.get(i).getUrl1(),mHolder.book1);
        PicassoClient.downloadImage(c,tvShows.get(i).getUrl2(),mHolder.book2);
        PicassoClient.downloadImage(c,tvShows.get(i).getUrl3(),mHolder.book3);
        return view;
    }
}
