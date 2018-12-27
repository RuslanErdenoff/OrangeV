package com.example.ruslan.orangeviews.view.consultantView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ruslan.orangeviews.ConsultantCreateEventActivity;
import com.example.ruslan.orangeviews.ConsultantCustomersPager;
import com.example.ruslan.orangeviews.ConsultantEventsFragment;
import com.example.ruslan.orangeviews.ConsultantRequestPagerFragment;
import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.customerView.CustomerConsultationsFragment;

public class ConsultantMainProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_main_profile);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_consultant_customers:
                                fragment = new ConsultantCustomersPager();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_consultant_request:
                                fragment = new ConsultantRequestPagerFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_consultant_messages:
                                fragment = new CustomerConsultationsFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_consultant_calendar:
                                fragment = new ConsultantEventsFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_consultant_profile:
                                fragment = new ConsultantMainProfilePager();
                                loadFragment(fragment);
                                return true;
                        }
                        return false;
                    }
                });
        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_consultant_profile);
        Fragment fragment = new ConsultantMainProfilePager();
        loadFragment(fragment);

    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.consultant_main_profile_fragments_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void onAddNewEvent(View view){
        Intent intent = new Intent(this, ConsultantCreateEventActivity.class);
        startActivity(intent);
    }
}
