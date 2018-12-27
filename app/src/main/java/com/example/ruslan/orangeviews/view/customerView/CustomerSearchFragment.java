package com.example.ruslan.orangeviews.view.customerView;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.Adapters.SearchCategoriesAdapter;
import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.db.DataBaseInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerSearchFragment extends Fragment {


    public CustomerSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(
                R.layout.fragment_customer_search, container, false);
        RecyclerView categoriesRecycler = (RecyclerView)view.findViewById(R.id.customer_search_categories_recycler);

        String[] titles = new String[]{"Скорая помощь","Врач","Медсестра","Массаж","Сестринский уход","Забор анализов"};
        SearchCategoriesAdapter searchCategoriesAdapter = new SearchCategoriesAdapter(titles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        categoriesRecycler.setAdapter(searchCategoriesAdapter);
        categoriesRecycler.setLayoutManager(linearLayoutManager);
        categoriesRecycler.setNestedScrollingEnabled(false);

        Cursor cursor = DataBaseInstance.myDb.getReadableDatabase().query("CITIES",new String[]{"NAME"},null,null,null,null,null);

        final TextView currentCity = (TextView) view.findViewById(R.id.text_current_city);
        final String[] cities = new String[cursor.getCount()];
        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group_cities);

        for (int i = 0; i < cities.length; i++) {
            if(i==0){
                if(cursor.moveToFirst()){
                    cities[i]=(cursor.getString(0));
                }
            }else{
                if(cursor.moveToNext()){
                    cities[i]=(cursor.getString(0));
                }
            }
            RadioButton radioButton = (RadioButton) getActivity().getLayoutInflater().inflate(R.layout.item_child_city,null);
            radioButton.setText(cities[i]);
            radioButton.setId(i);
            radioGroup.addView(radioButton);
        }
        cursor.close();
        currentCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroup.getVisibility() == View.VISIBLE){
                    radioGroup.setVisibility(View.GONE);
                }else{
                    radioGroup.setVisibility(View.VISIBLE);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = (RadioButton) view.findViewById(checkedRadioButtonId);
                currentCity.setText(radioBtn.getText());
            }
        });

        return view;
    }

}
