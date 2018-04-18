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
 * Created by Develop on 4/10/2018.
 */

public class QuanLiSachFragment extends Fragment {

    private ViewPager pager;
    private TabLayout tabLayout;
    FragmentManager fragmentManager;
    PaperAdapter paperAdapter;
    private FragmentActivity myContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.layout_quanli_sach,container,false);
        pager=view.findViewById(R.id.view_pager);
        tabLayout=view.findViewById(R.id.tab_layout);
        addControl();
        return view;
    }

    private void addControl() {

        fragmentManager=myContext.getSupportFragmentManager();
        paperAdapter=new PaperAdapter(fragmentManager);
        pager.setAdapter(paperAdapter);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(paperAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        myContext= (FragmentActivity) activity;
        super.onAttach(activity);
    }
}
