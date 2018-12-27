package com.example.ruslan.orangeviews.view.customerView;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

public class ConsultantProfileActivity extends BaseActivity {

    private class ConsultantPagesAdapter extends FragmentPagerAdapter {
        public ConsultantPagesAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public int getCount(){
            return 4;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new ConsultantAboutFragment();
                case 1:
                    return new ConsultantServicesFragment();
                case 2:
                    return new ConsultantReviewsFragment();
                case 3:
                    return new ConsultantContactsFragment();
            }
            return null;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "O враче";
                case 1:
                    return "Услуги";
                case 2:
                    return "Отзывы";
                case 3:
                    return "Контакты";
            }
            return null;
        }
    }
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_consultant_profile);
        initToolbar("Консультант");

        FragmentPagerAdapter  customerPagesAdapter = new ConsultantPagesAdapter(this.getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.view_pager_consultant_profile);
        pager.setAdapter(customerPagesAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.consultant_profile_tabs);
        tabLayout.setupWithViewPager(pager);
    }

    public void onPreRequest(View view){
        Intent intent = new Intent(this, CustomerPreRequestActivity.class);
        startActivity(intent);
    }
    public void onConsultation(View view){
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }
}
