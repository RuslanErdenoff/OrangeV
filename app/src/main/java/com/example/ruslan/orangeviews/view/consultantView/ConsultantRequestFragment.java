package com.example.ruslan.orangeviews.view.consultantView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.Adapters.CustomerCurrentRequestsAdapter;
import com.example.ruslan.orangeviews.Adapters.CustomerOldRequestAdapter;
import com.example.ruslan.orangeviews.Adapters.RequestsItem;
import com.example.ruslan.orangeviews.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantRequestFragment extends Fragment {


    public ConsultantRequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_request, container, false);

        RecyclerView currentRequestsRecycler = (RecyclerView) view.findViewById(R.id.customer_current_requests_recycler);
        RecyclerView oldRequestsRecycler = (RecyclerView) view.findViewById(R.id.customer_old_requests_recycler);


        String[] currentRequestsNames = {"Постовая медстестра","Cиделка","Капельница","Массаж классический","Педиатрия"};

        ArrayList<RequestsItem> requestsItems = new ArrayList<>();
        String[] oldRequestsNames = {"Постовая медстестра","Cиделка","Капельница","Массаж классический","Педиатрия"};
        requestsItems.add(new RequestsItem(RequestsItem.ItemType.COMPLETED_ITEM));
        requestsItems.add(new RequestsItem(RequestsItem.ItemType.CANCELED_ITEM));
        requestsItems.add(new RequestsItem(RequestsItem.ItemType.COMPLETED_ITEM));
        requestsItems.add(new RequestsItem(RequestsItem.ItemType.COMPLETED_ITEM));
        requestsItems.add(new RequestsItem(RequestsItem.ItemType.CANCELED_ITEM));

        CustomerCurrentRequestsAdapter customerCurrentRequestsAdapter = new CustomerCurrentRequestsAdapter(currentRequestsNames);
        CustomerOldRequestAdapter customerOldRequestAdapter = new CustomerOldRequestAdapter(oldRequestsNames,requestsItems);

        currentRequestsRecycler.setAdapter(customerCurrentRequestsAdapter);
        oldRequestsRecycler.setAdapter(customerOldRequestAdapter);

        currentRequestsRecycler.setLayoutManager( new LinearLayoutManager(getActivity()));
        oldRequestsRecycler.setLayoutManager( new LinearLayoutManager(getActivity()));
        return view;
    }

}
