package com.example.ruslan.orangeviews.view.customerView;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.loginpage.LoginPageActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerSettingsFragment extends Fragment {


    public CustomerSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer_settings, container, false);
        TextView textEdit = (TextView)  view.findViewById(R.id.text_edit_profile);
        textEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),CustomerEditProfileActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image_button_exit_profile);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),LoginPageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

}
