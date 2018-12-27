package com.example.ruslan.orangeviews.view.customerView;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFragmentProfilePager extends Fragment {
    private class CustomerPagesAdapter extends FragmentPagerAdapter {
        public CustomerPagesAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public int getCount(){
            return 3;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new CustomerProfileFragment();
                case 1:
                    return new CustomerContactsFragment();
                case 2:
                    return new CustomerSettingsFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.customer_profile_page_top_navigation_profile);
                case 1:
                    return getResources().getText(R.string.customer_profile_page_top_navigation_contacts);
                case 2:
                    return getResources().getText(R.string.customer_profile_page_top_navigation_settings);
            }
            return null;
        }
    }

    public CustomerFragmentProfilePager() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_fragment_profile_pager, container, false);
        CustomerPagesAdapter customerPagesAdapter = new CustomerPagesAdapter(getChildFragmentManager());
        ViewPager pager = (ViewPager)view.findViewById(R.id.customer_profile_pager);
        pager.setAdapter(customerPagesAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.customer_profile_tabs);
        tabLayout.setupWithViewPager(pager);
        return view;
    }

}
