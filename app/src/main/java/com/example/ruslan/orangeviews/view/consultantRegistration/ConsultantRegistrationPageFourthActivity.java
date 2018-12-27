package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;

public class ConsultantRegistrationPageFourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_registration_page_fourth);
    }
    public void consultantFifthRegistrationPage(View view){
        Intent intent = new Intent(this,ConsultantRegistrationPageFifthActivity.class);
        startActivity(intent);
    }
}
