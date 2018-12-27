package com.example.ruslan.orangeviews.view.customerView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.welcomepagefragments.AddressCardViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddressesFragment extends Fragment {


    public AddressesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(
                R.layout.fragment_addresses, container, false);
        RecyclerView addressRecycler = (RecyclerView) view.findViewById(R.id.addresses_recycler);
        String[] addreses = {"Сейфулина 451б дом 451б кв 20",
                "Сейфулина 451б дом 451б кв 20",
                "Сейфулина 451б дом 451б кв 20",
                "Сейфулина 451б дом 451б кв 20",
                "Сейфулина 451б дом 451б кв 20"};
        String city = "г.Алматы";
        AddressCardViewAdapter adapter = new AddressCardViewAdapter(city, addreses);
        addressRecycler.setAdapter(adapter);
        addressRecycler.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        addressRecycler.setLayoutManager(layoutManager);
        return view;
    }

}
