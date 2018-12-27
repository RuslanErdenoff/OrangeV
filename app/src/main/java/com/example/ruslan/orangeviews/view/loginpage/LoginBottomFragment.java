package com.example.ruslan.orangeviews.view.loginpage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginBottomFragment extends Fragment {


    public LoginBottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_bottom, container, false);
    }

}
