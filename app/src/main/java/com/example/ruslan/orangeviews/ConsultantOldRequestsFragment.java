package com.example.ruslan.orangeviews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.Adapters.ConsultantOldRequestsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantOldRequestsFragment extends Fragment {


    public ConsultantOldRequestsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_old_requests, container, false);
        RecyclerView currentRequestRecycler = (RecyclerView) view.findViewById(R.id.recycler_consultant_old_request);
        ConsultantOldRequestsAdapter adapter = new ConsultantOldRequestsAdapter(4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        currentRequestRecycler.setAdapter(adapter);
        currentRequestRecycler.setLayoutManager(linearLayoutManager);
        return view;
    }

}
