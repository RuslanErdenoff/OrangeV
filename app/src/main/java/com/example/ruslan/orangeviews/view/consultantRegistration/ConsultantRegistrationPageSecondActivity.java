package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.customerRegistration.CustomerRegistrationThirdPageActivity;

public class ConsultantRegistrationPageSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_registration_page_second);
    }
    public void thirdRegistrationPage(View view){
        Intent intent = new Intent(this,ConsultantRegistrationPageThirdActivity.class);
        startActivity(intent);
    }
}
