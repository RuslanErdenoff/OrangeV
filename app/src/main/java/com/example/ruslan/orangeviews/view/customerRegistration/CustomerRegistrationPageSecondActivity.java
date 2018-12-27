package com.example.ruslan.orangeviews.view.customerRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

public class CustomerRegistrationPageSecondActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_customer_registration_page_second);
        initRegistrationToolBar();
    }
    public void thirdRegistrationPage(View view){
        Intent intent = new Intent(this,CustomerRegistrationThirdPageActivity.class);
        startActivity(intent);
    }
}
