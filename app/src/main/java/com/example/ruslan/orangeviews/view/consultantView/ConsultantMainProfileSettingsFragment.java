package com.example.ruslan.orangeviews.view.consultantView;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantMainProfileSettingsFragment extends Fragment {


    public ConsultantMainProfileSettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_consultant_main_profile_settings, container, false);
    }

}
