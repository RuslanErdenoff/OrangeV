package com.example.ruslan.orangeviews.view.customerView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ruslan.orangeviews.Adapters.FavoriteConsultantsAdapter;
import com.example.ruslan.orangeviews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerFavoritesFragment extends Fragment {


    public CustomerFavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(
                R.layout.fragment_customer_favorites, container, false);
        RecyclerView favoriteConsultantsRecycler = (RecyclerView)view.findViewById(R.id.customer_profile_fragment_favorite_consultants_recycler);

        String[] firstNames = new String[]{"Анастасия","Екатерина","Анатолий","Василиса","Вячеслав"};
        String[] middleNames = new String[]{"Филипова","Келишенко","Гармонов","Овсянникова","Тихонов"};
        FavoriteConsultantsAdapter favoriteConsultantsAdapter = new FavoriteConsultantsAdapter(firstNames,middleNames);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        favoriteConsultantsRecycler.setAdapter(favoriteConsultantsAdapter);
        favoriteConsultantsRecycler.setLayoutManager(linearLayoutManager);

        return view;
    }

}
