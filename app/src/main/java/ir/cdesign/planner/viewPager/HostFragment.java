package ir.cdesign.planner.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.cdesign.planner.R;

/**
 * Created by amin pc on 14/09/2016.
 */
public class HostFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static Toolbar toolbar;

    public static int int_items = 3 ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_host_layout,null);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_main);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        try {
            tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new HomeFragment();
                case 1 : return new FutureFragment();
                case 2 : return new HistoryFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Home";
                case 1 :
                    return "Future";
                case 2 :
                    return "History";
            }
            return null;
        }
    }
}
