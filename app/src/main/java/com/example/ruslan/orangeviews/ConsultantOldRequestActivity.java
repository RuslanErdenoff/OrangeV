package com.example.ruslan.orangeviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruslan.orangeviews.view.BaseActivity;

public class ConsultantOldRequestActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_consultant_old_request);
        initToolbar("Завершенная заявка");
    }
}
