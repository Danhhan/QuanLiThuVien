package MyFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import MyTab.TabMuon;
import MyTab.TabTra;
import MyTab.TabXemDSMuonTraSach;

/**
 * Created by Develop on 4/11/2018.
 */

public class PaperAdapter_tramuon extends FragmentStatePagerAdapter {


    public PaperAdapter_tramuon(FragmentManager fragmentManager) {
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
                frag= new TabMuon();
                break;
            case 1:
                frag=new TabTra();

                break;
            case 2:
                frag=new TabXemDSMuonTraSach();

                break;

        }
        return frag;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = "";
        switch (position){
            case 0:
                title = "Phiếu Cho Mượn";
                break;
            case 1:
                title = "Phiếu Trả Sách";
                break;
            case 2:
                title = "Danh Sách Mượn Trả";
                break;
        }
        return title;
    }
}
