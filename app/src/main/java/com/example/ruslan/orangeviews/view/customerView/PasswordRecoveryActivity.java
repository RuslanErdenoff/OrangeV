package com.example.ruslan.orangeviews.view.customerView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.loginpage.RegistrationPageFirstActivity;

public class PasswordRecoveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);
        TextView textView = (TextView) findViewById(R.id.login_tool_bar_title);
        textView.setText("Восстановление пароля");


    }
    public void recoveryPasswordCheck(View view){
        Intent intent = new Intent(this,RecoveryPasswordCheckActivity.class);
        startActivity(intent);
    }
    public void doRegistration(View view){
        Intent intent = new Intent(this,RegistrationPageFirstActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();

    }
}
