package com.example.ruslan.orangeviews.view.welcomepagefragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.loginpage.LoginPageActivity;

public class WelcomePageActivity extends AppCompatActivity {
    private int currentPosition = 0;
    private ViewPager pager;
    private class WelcomePagesAdapter extends FragmentPagerAdapter{
        public WelcomePagesAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public int getCount(){
            return 5;
        }
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new WelcomePageFirstFragment();
                case 1:
                    return new WelcomePageSecondFragment();
                case 2:
                    return new WelcomePageThirdFragment();
                case 3:
                    return new WelcomePageFourthFragment();
                case 4:
                    return new WelcomePageFifthFragment();
            }
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button skipButton = (Button) findViewById(R.id.welcome_skip_button);
        WelcomePagesAdapter welcomePagesAdapter = new WelcomePagesAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.welcomePager);
        pager.setAdapter(welcomePagesAdapter);
    }
    public void skipWelcomePages(View view){
        Intent intent = new Intent(this, LoginPageActivity.class);
        startActivity(intent);
    }
    public void nextWelcomePage(View view){
        currentPosition = pager.getCurrentItem();
        if(currentPosition != 4){
            pager.setCurrentItem(currentPosition++,true);
        }else{
            Intent intent = new Intent(this, LoginPageActivity.class);
            startActivity(intent);
        }
    }
}
