package com.example.ruslan.orangeviews;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.view.consultantView.ConsultantCustomersFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantCustomersPager extends Fragment {


    private class CustomersPagesAdapter extends FragmentPagerAdapter {
        public CustomersPagesAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public int getCount(){
            return 2;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new ConsultantCustomersFragment();
                case 1:
                    return new ConsultantCustomersFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Запросы на консультацию";
                case 1:
                    return "Мои пациенты";
            }
            return null;
        }
    }
    public ConsultantCustomersPager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_customers_pager, container, false);
        CustomersPagesAdapter requestsPagesAdapter = new CustomersPagesAdapter(getChildFragmentManager());
        ViewPager pager = (ViewPager)view.findViewById(R.id.consultant_customers_pager);
        pager.setAdapter(requestsPagesAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.consultant_customers_tab);
        tabLayout.setupWithViewPager(pager);

        return view;
    }

}
