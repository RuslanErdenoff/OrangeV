package com.example.ruslan.orangeviews.view.customerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.db.DataBaseInstance;
import com.example.ruslan.orangeviews.view.BaseActivity;

import java.util.Calendar;

public class CustomerEditProfileActivity extends BaseActivity {
    TextView currentDateTime;
    Calendar dateAndTime=Calendar.getInstance();
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_customer_edit_profile);
        initToolbar("Редактирование профиля");

        DataBaseInstance.createDB(this);
        Cursor cursor = DataBaseInstance.myDb.getReadableDatabase().query("CITIES",new String[]{"NAME"},null,null,null,null,null);

        final TextView currentCity = (TextView) findViewById(R.id.text_current_city_edit_profile);
        final String[] cities = new String[cursor.getCount()];
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group_cities_edit_profile);

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
                }else{
                    radioGroup.setVisibility(View.VISIBLE);
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
    public void saveProfile(View view){
        Intent intent = new Intent(this,CustomerProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
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
        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }
}
