package mData;

import java.util.ArrayList;


public class TVShowCollection {

    public static ArrayList<TVShow> getTVShows(){
        ArrayList<TVShow> tvShows=new ArrayList<>();
        TVShow tv=new TVShow();
        tv.setName("Ngôn Tình");
        tv.setUrl1("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tv.setUrl2("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tv.setUrl3("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tvShows.add(tv);

        tv=new TVShow();
        tv.setName("Công nghệ Thông tin");
        tv.setUrl1("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tv.setUrl2("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tv.setUrl3("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tvShows.add(tv);

        tv=new TVShow();
        tv.setName("Kinh Tế");
        tv.setUrl1("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tv.setUrl2("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tv.setUrl3("http://res.cloudinary.com/hanminhdanh/image/upload/v1522069051/bngontinh.gif");
        tvShows.add(tv);
        return tvShows;
    }
}
