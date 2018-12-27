package com.example.ruslan.orangeviews.view.consultantView;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.customerView.CustomerContactsFragment;
import com.example.ruslan.orangeviews.view.customerView.CustomerFragmentProfilePager;
import com.example.ruslan.orangeviews.view.customerView.CustomerProfileFragment;
import com.example.ruslan.orangeviews.view.customerView.CustomerSettingsFragment;

public class CustomerProfileAboutActivity extends AppCompatActivity {

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
                    return new CustomerProfileAboutFragment();
                case 1:
                    return new CustomerContactsFragment();
                case 2:
                    return new CustomerProfileAboutFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Профиль пациента";
                case 1:
                    return getResources().getText(R.string.customer_profile_page_top_navigation_contacts);
                case 2:
                    return "Записи";
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile_about);

        FragmentPagerAdapter  customerPagesAdapter = new CustomerPagesAdapter(this.getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager_consultant_profile);
        pager.setAdapter(customerPagesAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.consultant_profile_tabs);
        tabLayout.setupWithViewPager(pager);
    }
}
