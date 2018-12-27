package com.example.ruslan.orangeviews.view.customerRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.view.customerView.CustomerProfileActivity;
import com.example.ruslan.orangeviews.R;

public class CustomerRegistrationPageFourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration_page_fourth);
    }
    public void toLoginPage(View view){
        Intent intent = new Intent(this,CustomerProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
