package com.example.ruslan.orangeviews.view.consultantView;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.customerView.CustomerSettingsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantMainProfilePager extends Fragment {

    private class ConsultantPagerAdapter extends FragmentPagerAdapter {
        public ConsultantPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public int getCount(){
            return 5;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new ConsultantMainProfileAboutFragment();
                case 1:
                    return new ConsultantMainProfileServicesFragment();
                case 2:
                    return new ConsultantMainProfileReviews();
                case 3:
                    return new ConsultantMainProfileContactsFragment();
                case 4:
                    return new CustomerSettingsFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "О враче";
                case 1:
                    return "Услуги";
                case 2:
                    return "Отзывы";
                case 3:
                    return "Контакты";
                case 4:
                    return "Настройки";
            }
            return null;
        }
    }
    public ConsultantMainProfilePager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_main_profile_pager, container, false);
        ConsultantPagerAdapter consultantPagerAdapter = new ConsultantPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.consultant_main_profile_pager);

        viewPager.setAdapter(consultantPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.consultant_main_profile_tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
