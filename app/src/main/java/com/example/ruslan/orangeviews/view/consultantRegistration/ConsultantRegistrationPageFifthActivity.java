package com.example.ruslan.orangeviews.view.consultantRegistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;

public class ConsultantRegistrationPageFifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultant_registration_page_fifth);

        TextView textOne = (TextView) findViewById(R.id.text_consultant_registration_one);
        textOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthOneActivity.class);
                startActivity(intent);
            }
        });
        TextView textTwo = (TextView) findViewById(R.id.text_consultant_registration_two);
        textTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthTwoActivity.class);
                startActivity(intent);
            }
        });
        TextView textThree = (TextView) findViewById(R.id.text_consultant_registration_three);
        textThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthThreeActivity.class);
                startActivity(intent);
            }
        });
        TextView textFour = (TextView) findViewById(R.id.text_consultant_registration_four);
        textFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthFourActivity.class);
                startActivity(intent);
            }
        });
        TextView textSix = (TextView) findViewById(R.id.text_consultant_registration_six);
        textSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthSixActivity.class);
                startActivity(intent);
            }
        });
        TextView textFive = (TextView) findViewById(R.id.text_consultant_registration_five);
        textFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthFiveActivity.class);
                startActivity(intent);
            }
        });
        TextView textSeven = (TextView) findViewById(R.id.text_consultant_registration_seven);
        textSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultantRegistrationPageFifthActivity.this,ConsultantRegistrationPageFifthSevenActivity.class);
                startActivity(intent);
            }
        });
    }
    public void consultantSixthRegistrationPage(View view){
        Intent intent = new Intent(this,ConsultantRegistrationPageSixthActivity.class);
        startActivity(intent);
    }
}
