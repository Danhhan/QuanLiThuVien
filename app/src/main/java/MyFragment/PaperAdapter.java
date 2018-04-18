package MyFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import MyTab.TabThonTinSach;
import MyTab.TabThemSach;

/**
 * Created by Develop on 4/11/2018.
 */

public class PaperAdapter extends FragmentStatePagerAdapter {


    public PaperAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag= new TabThonTinSach();
                break;
            case 1:
                frag=new TabThemSach();

                break;

        }
        return frag;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = "";
        switch (position){
            case 0:
                title = "Thông Tin Sách";
                break;
            case 1:
                title = "Thêm Sách";
                break;
        }
        return title;
    }
}
