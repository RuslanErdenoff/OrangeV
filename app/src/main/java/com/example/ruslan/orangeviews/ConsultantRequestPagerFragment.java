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

import com.example.ruslan.orangeviews.view.customerView.CustomerContactsFragment;
import com.example.ruslan.orangeviews.view.customerView.CustomerProfileFragment;
import com.example.ruslan.orangeviews.view.customerView.CustomerSettingsFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantRequestPagerFragment extends Fragment {

    private class RequestsPagesAdapter extends FragmentPagerAdapter {
        public RequestsPagesAdapter(FragmentManager fragmentManager){
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
                    return new ConsultantCurrentRequestsFragment();
                case 1:
                    return new ConsultantOldRequestsFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Актуальные заявки";
                case 1:
                    return "Архив заявок";
            }
            return null;
        }
    }
    public ConsultantRequestPagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_request_pager, container, false);
        RequestsPagesAdapter requestsPagesAdapter = new RequestsPagesAdapter(getChildFragmentManager());
        ViewPager pager = (ViewPager)view.findViewById(R.id.consultant_requests_pager);
        pager.setAdapter(requestsPagesAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.consultant_requests_tabs);
        tabLayout.setupWithViewPager(pager);

        return view;
    }

}
