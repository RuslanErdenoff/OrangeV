package com.example.ruslan.orangeviews.view.consultantView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.Adapters.CustomersAdapter;
import com.example.ruslan.orangeviews.Adapters.FavoriteConsultantsAdapter;
import com.example.ruslan.orangeviews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantCustomersFragment extends Fragment {


    public ConsultantCustomersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_customers, container, false);
        RecyclerView favoriteConsultantsRecycler = (RecyclerView)view.findViewById(R.id.customer_profile_fragment_favorite_consultants_recycler);

        String[] firstNames = new String[]{"Анастасия","Екатерина","Анатолий","Василиса","Вячеслав"};
        String[] middleNames = new String[]{"Филипова","Келишенко","Гармонов","Овсянникова","Тихонов"};
        CustomersAdapter favoriteConsultantsAdapter = new CustomersAdapter(firstNames,middleNames);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        favoriteConsultantsRecycler.setAdapter(favoriteConsultantsAdapter);
        favoriteConsultantsRecycler.setLayoutManager(linearLayoutManager);

        return view;
    }

}
