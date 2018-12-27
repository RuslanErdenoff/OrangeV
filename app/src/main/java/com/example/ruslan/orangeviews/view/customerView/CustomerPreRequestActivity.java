package com.example.ruslan.orangeviews.view.customerView;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

public class CustomerPreRequestActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_customer_pre_request);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group_customer_pre_request);
        final CustomerPreRequestToConsultant customerPreRequestToConsultant = new CustomerPreRequestToConsultant();
        final CustomerPreRequestToHome customerPreRequestToHome = new CustomerPreRequestToHome();
        final FragmentManager fm = getSupportFragmentManager();
        RadioButton radioButton  =(RadioButton) findViewById(R.id.radio_button_customer_pre_request_to_consultant);
        radioButton.setChecked(true);
        FragmentTransaction ft;
        ft = fm.beginTransaction();
        ft.replace(R.id.customer_pre_request_container, customerPreRequestToConsultant);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                FragmentTransaction ft;
                switch(checkedId)
                {
                    case R.id.radio_button_customer_pre_request_to_consultant:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.customer_pre_request_container, customerPreRequestToConsultant);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                    case R.id.radio_button_customer_pre_request_to_home:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.customer_pre_request_container, customerPreRequestToHome);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                        break;
                }
            }
        });
        /*
        if(viewType == CustomerOldRequestAdapter.TYPE_COMPLETED){
            CustomerComletedRequestFragment customerComletedRequestFragment = new CustomerComletedRequestFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.customer_request_container, customerComletedRequestFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if(viewType == CustomerOldRequestAdapter.TYPE_CANCELED){
            CustomerCanceledRequestFragment customerCanceledRequestFragment = new CustomerCanceledRequestFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.customer_request_container, customerCanceledRequestFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else{
            CustomerCurrentRequestFragment customerCanceledRequestFragment = new CustomerCurrentRequestFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.customer_request_container, customerCanceledRequestFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }*/
        initToolbar("Заявка на прием");
    }
    public void onRequest(View view){
        Intent intent = new Intent(this, CustomerProfileActivity.class);
        intent.putExtra(CustomerProfileActivity.TAG,2);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
