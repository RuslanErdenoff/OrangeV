package com.example.ruslan.orangeviews.view.customerView;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.ruslan.orangeviews.R;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerPreRequestToHome extends Fragment {

    Calendar dateAndTime=Calendar.getInstance();
    TextView currentDateTime;
    TextView currentODateTime;
    TextView currentODateHour;
    public CustomerPreRequestToHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_pre_request_to_home, container, false);

        Button button = (Button) view.findViewById(R.id.setRequestDate);
        currentDateTime = (TextView) view.findViewById(R.id.requestDate);

        Button oButton = (Button) view.findViewById(R.id.setRequestODate);
        currentODateTime = (TextView) view.findViewById(R.id.requestODate);
        currentODateHour = (TextView) view.findViewById(R.id.requestODateHour);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new TimePickerDialog(getContext(), t,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE), true)
                        .show();
            }
        });
        oButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new TimePickerDialog(getContext(), tO,
                        dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE), true)
                        .show();
            }
        });
        return view;
    }

    private void setInitialDateTime() {
        currentDateTime.setVisibility(View.VISIBLE);
        currentDateTime.setText(DateUtils.formatDateTime(getContext(),
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_TIME));
    }
    private void setInitialODateTime() {
        currentODateTime.setVisibility(View.VISIBLE);
        currentODateHour.setVisibility(View.VISIBLE);

        currentODateTime.setText(DateUtils.formatDateTime(getContext(),
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_TIME));
    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };
    TimePickerDialog.OnTimeSetListener tO =new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialODateTime();
        }
    };
}
