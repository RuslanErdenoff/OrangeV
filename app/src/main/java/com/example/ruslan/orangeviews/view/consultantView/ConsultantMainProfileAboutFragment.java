package com.example.ruslan.orangeviews.view.consultantView;


import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultantMainProfileAboutFragment extends Fragment {


    public ConsultantMainProfileAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_consultant_main_profile_about, container, false);
        TextView textSchedule = (TextView) view.findViewById(R.id.text_consultant_main_profile_schedule);
        final LinearLayout linearSchedule = (LinearLayout) view.findViewById(R.id.linear_view_consultant_main_profile_schedule);

        TextView textExpa = (TextView) view.findViewById(R.id.text_consultant_main_profile_experience);
        final LinearLayout linearExpa = (LinearLayout) view.findViewById(R.id.linear_view_consultant_main_profile_experience);

        TextView textLicenses = (TextView) view.findViewById(R.id.text_consultant_main_profile_licenses);
        final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.frame_consultant_main_profile_licenses);

        TextView textPS = (TextView) view.findViewById(R.id.text_consultant_main_profile_professional_skills);
        final LinearLayout linearPS = (LinearLayout) view.findViewById(R.id.linear_view_consultant_main_profile_professional_skills);

        TextView textAI = (TextView) view.findViewById(R.id.text_consultant_main_profile_additing_info);
        final LinearLayout linearAI = (LinearLayout) view.findViewById(R.id.linear_view_consultant_main_profile_additing_info);

        TextView textEducation = (TextView) view.findViewById(R.id.text_consultant_main_profile_education);
        final LinearLayout linearEducation = (LinearLayout) view.findViewById(R.id.linear_view_consultant_main_profile_education);


        textSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearSchedule.getVisibility() == View.VISIBLE){
                    linearSchedule.setVisibility(View.GONE);
                }else{
                    linearSchedule.setVisibility(View.VISIBLE);
                }
            }
        });
        textExpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearExpa.getVisibility() == View.VISIBLE){
                    linearExpa.setVisibility(View.GONE);
                }else{
                    linearExpa.setVisibility(View.VISIBLE);
                }
            }
        });
        textLicenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(frameLayout.getVisibility() == View.VISIBLE){
                    frameLayout.setVisibility(View.GONE);
                }else{
                    frameLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        textPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearPS.getVisibility() == View.VISIBLE){
                    linearPS.setVisibility(View.GONE);
                }else{
                    linearPS.setVisibility(View.VISIBLE);
                }
            }
        });
        textAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearAI.getVisibility() == View.VISIBLE){
                    linearAI.setVisibility(View.GONE);
                }else{
                    linearAI.setVisibility(View.VISIBLE);
                }
            }
        });
        textEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(linearEducation.getVisibility() == View.VISIBLE){
                    linearEducation.setVisibility(View.GONE);
                }else{
                    linearEducation.setVisibility(View.VISIBLE);
                }
            }
        });

        return view;
    }

}
