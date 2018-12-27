package com.example.ruslan.orangeviews.view.customerRegistration;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.db.DataBaseInstance;
import com.example.ruslan.orangeviews.view.BaseActivity;

import java.util.Calendar;


public class CustomerRegistrationThirdPageActivity extends BaseActivity {

    TextView currentDateTime;
    Calendar dateAndTime=Calendar.getInstance();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_customer_registration_page_third);
        initToolbar("Регистрация");

        DataBaseInstance.createDB(this);
        Cursor cursor = DataBaseInstance.myDb.getReadableDatabase().query("CITIES",new String[]{"NAME"},null,null,null,null,null);

        final TextView currentCity = (TextView) findViewById(R.id.text_current_city);
        final String[] cities = new String[cursor.getCount()];
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group_cities);

        EditText editText = (EditText) findViewById(R.id.testEdittext);
        findViewById(R.id.linearLayoutFocusTest).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });
        for (int i = 0; i < cities.length; i++) {
            if(i==0){
                if(cursor.moveToFirst()){
                    cities[i]=(cursor.getString(0));
                }
            }else{
                if(cursor.moveToNext()){
                    cities[i]=(cursor.getString(0));
                }
            }
            RadioButton radioButton = (RadioButton) getLayoutInflater().inflate(R.layout.item_child_city,null);
            radioButton.setText(cities[i]);
            radioButton.setId(i);
            radioGroup.addView(radioButton);
        }
        cursor.close();
        currentCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroup.getVisibility() == View.VISIBLE){
                    radioGroup.setVisibility(View.GONE);
                    currentCity.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_down, 0);
                }else{
                    radioGroup.setVisibility(View.VISIBLE);
                    currentCity.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_up, 0);
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = (RadioButton) findViewById(checkedRadioButtonId);
                currentCity.setText(radioBtn.getText());
            }
        });

        currentDateTime=(TextView)findViewById(R.id.dateOfBirth);


    }
    public void fourthRegistrationPage(View view){
        Intent intent = new Intent(this,CustomerRegistrationPageFourthActivity.class);
        startActivity(intent);
    }
    public void setDate(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
    private void setInitialDateTime() {
        currentDateTime.setVisibility(View.VISIBLE);
        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
