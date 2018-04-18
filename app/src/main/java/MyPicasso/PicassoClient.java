package MyPicasso;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.example.develop.QuanLiThuVien.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Develop on 3/26/2018.
 */

public class PicassoClient {

    public static void downloadImage(Context c, String url, ImageView imageView){
        if (url !=null && url.length()>0){
            Picasso.with(c).load(url)
                    .placeholder(R.drawable.loadimg)
                    .into(imageView);
            Log.d("kiemtra", "downloadImage: ");
        }else {
            Picasso.with(c).load(R.drawable.logo).into(imageView);
            Log.d("kiemtra", "downloadImag2: ");
        }
    }
}
