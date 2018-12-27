package com.example.ruslan.orangeviews.view.customerView;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.Dialogs.NewAddressDialog;

public class CustomerProfileActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav_bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_search:
                                fragment = new CustomerSearchFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_request:
                                fragment = new CustomerRequestFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_messages:
                                fragment = new CustomerConsultationsFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_favorite:
                                fragment = new CustomerFavoritesFragment();
                                loadFragment(fragment);
                                return true;
                            case R.id.bottom_navigation_profile:
                                fragment = new CustomerFragmentProfilePager();
                                loadFragment(fragment);
                                return true;
                        }
                        return false;
                    }
                });
        if(getIntent()!=null){
            try {
                int state = getIntent().getExtras().getInt(TAG);
                switch (state){
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_search);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_request);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_messages);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_favorite);
                        break;
                    case 5:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_profile);
                        break;
                    default:
                        bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_profile);
                        break;
                }
            }catch (Exception e){
                bottomNavigationView.setSelectedItemId(R.id.bottom_navigation_profile);
            }

        }


    }

    public void addNewAddress(View view){
        showNewAddressDialog();
    }
    private void showNewAddressDialog(){
        FragmentManager fm = getSupportFragmentManager();
        fm.executePendingTransactions();
        final NewAddressDialog addressDialog = NewAddressDialog.newInstance();
        addressDialog.show(fm,TAG);

    }
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.customer_profile_fragments_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
