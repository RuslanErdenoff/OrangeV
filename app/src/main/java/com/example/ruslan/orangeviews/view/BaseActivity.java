package com.example.ruslan.orangeviews.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected final void onCreate(Bundle savedInstanceState, int layoutId)
    {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

    }

    public void initToolbar(String name)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView textView = (TextView) toolbar.getRootView().findViewById(R.id.toolbar_title);
        textView.setText(name);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void initRegistrationToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarRegistration);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left_white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
