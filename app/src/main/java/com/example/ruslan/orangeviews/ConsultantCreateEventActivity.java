package com.example.ruslan.orangeviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ConsultantCreateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_create_event);
    }
    public void onAddCustomer(View view){
        Intent intent = new Intent(this,ConsultantEventCustomersActivity.class);
        startActivity(intent);
    }
}
