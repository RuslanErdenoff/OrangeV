package com.example.ruslan.orangeviews.view.welcomepagefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ruslan.orangeviews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomePageFirstFragment extends Fragment {


    public WelcomePageFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ImageView imageView = container.findViewById(R.id.testImage);
        return inflater.inflate(R.layout.fragment_welcome_page_first, container, false);
    }

}
