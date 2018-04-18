package MyFragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.develop.QuanLiThuVien.R;

/**
 * Created by Develop on 4/13/2018.
 */

public class QuanLiTraMuonSach extends Fragment {

    private ViewPager pager_tramuon;
    private TabLayout tabLayout_tramuon;
    FragmentManager fragmentManager;
    PaperAdapter_tramuon paperAdapter_tramuon;
    private FragmentActivity myContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.qualitramuonsach, container,false);
        pager_tramuon=view.findViewById(R.id.view_pager_tramuon);
        tabLayout_tramuon=view.findViewById(R.id.tab_layout_tramuon);
        addControl();
        return view;
    }
    private void addControl() {

        fragmentManager=myContext.getSupportFragmentManager();
        paperAdapter_tramuon=new PaperAdapter_tramuon(fragmentManager);
        pager_tramuon.setAdapter(paperAdapter_tramuon);
        tabLayout_tramuon.setupWithViewPager(pager_tramuon);
        pager_tramuon.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout_tramuon));
        tabLayout_tramuon.setTabsFromPagerAdapter(paperAdapter_tramuon);
    }

    @Override
    public void onAttach(Activity activity) {
        myContext= (FragmentActivity) activity;
        super.onAttach(activity);
    }
}
