package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ruslan.orangeviews.R;

public class ConsultantRegistrationPageFifthOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_registration_page_fifth_one);
    }
    public void consultantRegistrationSave(View view){
        Intent intent = new Intent(this,ConsultantRegistrationPageFifthActivity.class);
        startActivity(intent);
    }
}
