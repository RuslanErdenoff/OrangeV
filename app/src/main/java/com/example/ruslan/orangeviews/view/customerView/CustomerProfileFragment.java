package com.example.ruslan.orangeviews.view.customerView;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerProfileFragment extends Fragment {


    public CustomerProfileFragment() {
        // Required empty public constructor
    }
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState == null) {
                AddressesFragment addressesFragment = new AddressesFragment();
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                ft.add(R.id.addresses_container, addressesFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_customer_profile, container, false);
    }

}
