package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.consultantView.ConsultantMainProfileActivity;
import com.example.ruslan.orangeviews.view.customerView.ConsultantProfileActivity;
import com.example.ruslan.orangeviews.view.loginpage.LoginPageActivity;

public class ConsultantRegistrationPageSixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_registration_page_sixth);
    }
    public void toLoginPage(View view){
        Intent intent = new Intent(this,ConsultantMainProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        super.onBackPressed();  // optional depending on your needs
    }
}
