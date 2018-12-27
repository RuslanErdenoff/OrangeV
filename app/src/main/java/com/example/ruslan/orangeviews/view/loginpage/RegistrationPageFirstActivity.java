package com.example.ruslan.orangeviews.view.loginpage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;
import com.example.ruslan.orangeviews.view.consultantRegistration.ConsultantRegistrationPageSecondActivity;
import com.example.ruslan.orangeviews.view.customerRegistration.CustomerRegistrationPageSecondActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrationPageFirstActivity extends BaseActivity {
    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;
    private boolean customer = false;
    private RadioGroup radioGroup;
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE };
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_registration_page_first);
        initRegistrationToolBar();

        checkPermissions();
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);

        final RadioButton radioButtonCustomer = (RadioButton) findViewById(R.id.customer_radio_button);
        final RadioButton radioButtonConsultant = (RadioButton) findViewById(R.id.doctor_radio_button);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioButtonCustomer.isChecked()){
                    radioButtonCustomer.setTextColor(Color.WHITE);
                    radioButtonConsultant.setTextColor(getResources().getColor(R.color.very_light_orange));
                }else{
                    radioButtonCustomer.setTextColor(getResources().getColor(R.color.very_light_orange));
                    radioButtonConsultant.setTextColor(Color.WHITE);
                }
            }
        });
    }
    public void secondRegistrationPage(View view){
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        if(checkedRadioButtonId == R.id.customer_radio_button){
            Intent intent = new Intent(RegistrationPageFirstActivity.this,CustomerRegistrationPageSecondActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(RegistrationPageFirstActivity.this,ConsultantRegistrationPageSecondActivity.class);
            startActivity(intent);
        }
    }
    public void toLoginPage(View view){
        Intent intent = new Intent(this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    protected void checkPermissions() {
        final List<String> missingPermissions = new ArrayList<String>();
        // check all required dynamic permissions
        for (final String permission : REQUIRED_SDK_PERMISSIONS) {
            final int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
            // request all missing permissions
            final String[] permissions = missingPermissions
                    .toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            final int[] grantResults = new int[REQUIRED_SDK_PERMISSIONS.length];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                    grantResults);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int index = permissions.length - 1; index >= 0; --index) {
                    if (grantResults[index] != PackageManager.PERMISSION_GRANTED) {
                        // exit the app if one permission is not granted
                        Toast.makeText(this, "Required permission '" + permissions[index]
                                + "' not granted, exiting", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, LoginPageActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
                // all permissions were granted
                break;
        }
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
