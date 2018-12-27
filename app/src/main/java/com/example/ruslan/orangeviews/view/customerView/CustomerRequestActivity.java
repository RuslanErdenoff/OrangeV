package com.example.ruslan.orangeviews.view.customerView;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruslan.orangeviews.Adapters.CustomerOldRequestAdapter;
import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

public class CustomerRequestActivity extends BaseActivity {
    public static final String REQUEST_TAG = "requestTag";
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_customer_request);
        initToolbar("Заявка на прием");

        if(getIntent() != null){
            int viewType = getIntent().getExtras().getInt(REQUEST_TAG);
            if(viewType == CustomerOldRequestAdapter.TYPE_COMPLETED){
                CustomerComletedRequestFragment customerComletedRequestFragment = new CustomerComletedRequestFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.customer_request_container, customerComletedRequestFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }else if(viewType == CustomerOldRequestAdapter.TYPE_CANCELED){
                CustomerCanceledRequestFragment customerCanceledRequestFragment = new CustomerCanceledRequestFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.customer_request_container, customerCanceledRequestFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }else{
                CustomerCurrentRequestFragment customerCanceledRequestFragment = new CustomerCurrentRequestFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.customer_request_container, customerCanceledRequestFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }
    }
}
