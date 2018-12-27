package com.example.ruslan.orangeviews.view.customerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ruslan.orangeviews.Adapters.FavoriteConsultantsAdapter;
import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

public class AmbulanceCategoryActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_ambulance_category);
        initToolbar("Скорая помощь");

        RecyclerView favoriteConsultantsRecycler = (RecyclerView) findViewById(R.id.customer_profile_fragment_favorite_consultants_recycler);

        String[] firstNames = new String[]{"Анастасия","Екатерина","Анатолий","Василиса","Вячеслав"};
        String[] middleNames = new String[]{"Филипова","Келишенко","Гармонов","Овсянникова","Тихонов"};
        FavoriteConsultantsAdapter favoriteConsultantsAdapter = new FavoriteConsultantsAdapter(firstNames,middleNames);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        favoriteConsultantsRecycler.setAdapter(favoriteConsultantsAdapter);
        favoriteConsultantsRecycler.setLayoutManager(linearLayoutManager);
    }
}
