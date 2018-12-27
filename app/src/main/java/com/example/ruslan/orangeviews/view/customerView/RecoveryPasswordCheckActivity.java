package com.example.ruslan.orangeviews.view.customerView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.loginpage.LoginPageActivity;
import com.example.ruslan.orangeviews.view.loginpage.RegistrationPageFirstActivity;

public class RecoveryPasswordCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password_check);
    }
    public void toLoginPage(View view){
        Intent intent = new Intent(this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void doRegistration(View view){
        Intent intent = new Intent(this,RegistrationPageFirstActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
        super.onBackPressed();  // optional depending on your needs
    }

}
