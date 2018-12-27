package com.example.ruslan.orangeviews.view.customerView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.Adapters.ConsultationsAdapter;
import com.example.ruslan.orangeviews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerConsultationsFragment extends Fragment {


    public CustomerConsultationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_customer_consultations, container, false);
        RecyclerView chatCardsRecycler = (RecyclerView)view.findViewById(R.id.consultations_recycler);

        String[] firstNames = new String[]{"Анастасия","Екатерина","Анатолий","Василиса","Вячеслав"};
        String[] middleNames = new String[]{"Филипова","Келишенко","Гармонов","Овсянникова","Тихонов"};
        boolean[] isReaded = new boolean[]{false,true,true,false,true};
        String[] unReadedMessages = new String[]{null,
                "In this tutorial we are going to learn how to render a simple RecyclerView with a custom layout. " +
                "We’ll also learn writing a adapter class, adding list divider and row click listener.",
                "In this tutorial we are going to learn how to render a simple RecyclerView with a custom layout. " +
                        "We’ll also learn writing a adapter class, adding list divider and row click listener.",
                null,
                "In this tutorial we are going to learn how to render a simple RecyclerView with a custom layout. " +
                        "We’ll also learn writing a adapter class, adding list divider and row click listener."};
        ConsultationsAdapter consultationsCardsAdapter = new ConsultationsAdapter(firstNames,middleNames,isReaded,unReadedMessages);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        chatCardsRecycler.setAdapter(consultationsCardsAdapter);
        chatCardsRecycler.setLayoutManager(linearLayoutManager);
        return view;
    }

}
