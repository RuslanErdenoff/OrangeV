package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ruslan.orangeviews.Adapters.ConsultantRegistrationCategoriesAdapter;
import com.example.ruslan.orangeviews.R;

public class ConsultantRegistrationPageThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_registration_page_third);

        RecyclerView categoriesRecycler = (RecyclerView) findViewById(R.id.consultant_registration_categories_recycler);

        String[] titles = new String[]{"Скорая помощь","Врач","Медсестра","Массаж","Сестринский уход","Забор анализов"};
        ConsultantRegistrationCategoriesAdapter categoriesAdapter = new ConsultantRegistrationCategoriesAdapter(titles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        categoriesRecycler.setAdapter(categoriesAdapter);
        categoriesRecycler.setLayoutManager(linearLayoutManager);

    }
}
