package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

public class ConsultantRegistrationPageFifthFiveActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_consultant_registration_page_fifth_five);
        initToolbar("Опыт и стаж работы");
    }
    public void consultantRegistrationSave(View view){
        Intent intent = new Intent(this,ConsultantRegistrationPageFifthActivity.class);
        startActivity(intent);
    }
}
