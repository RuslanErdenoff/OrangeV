package com.example.ruslan.orangeviews.Adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.consultantRegistration.ConsultantRegistrationPageFourthActivity;
import com.example.ruslan.orangeviews.view.consultantRegistration.ConsultantRegistrationPageThirdActivity;
import com.example.ruslan.orangeviews.view.customerView.AmbulanceCategoryActivity;

public class ConsultantRegistrationCategoriesAdapter extends RecyclerView.Adapter<ConsultantRegistrationCategoriesAdapter.ViewHolder> {
    private String[] titles;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cv){
            super(cv);
            cardView = cv;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(cardView.getContext(), ConsultantRegistrationPageFourthActivity.class);
                    cardView.getContext().startActivity(intent);
                }
            });
        }
    }
    @Override
    public ConsultantRegistrationCategoriesAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search_category_card, parent, false);
        return new ConsultantRegistrationCategoriesAdapter.ViewHolder(cv);
    }
    public ConsultantRegistrationCategoriesAdapter(String[] titles){
        this.titles = titles;
    }
    @Override
    public int getItemCount(){
        return titles.length;
    }


    public void onBindViewHolder(ConsultantRegistrationCategoriesAdapter.ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        TextView textTitle = (TextView)cardView.findViewById(R.id.text_search_category_title);
        textTitle.setText(titles[position]);
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image_view_search_category_icon);
        switch (titles[position]){
            case "Скорая помощь":
                imageView.setImageDrawable(cardView.getContext().getResources().getDrawable(R.drawable.ic_aid_car));
                break;
            case "Врач":
                imageView.setImageDrawable(cardView.getContext().getResources().getDrawable(R.drawable.ic_aid_phone));
                break;
            case "Медсестра":
                imageView.setImageDrawable(cardView.getContext().getResources().getDrawable(R.drawable.ic_aid_nurse));
                break;
            case "Массаж":
                imageView.setImageDrawable(cardView.getContext().getResources().getDrawable(R.drawable.ic_aid_massage));
                break;
            case "Сестринский уход":
                imageView.setImageDrawable(cardView.getContext().getResources().getDrawable(R.drawable.ic_aid_nursing_care));
                break;
            case "Забор анализов":
                imageView.setImageDrawable(cardView.getContext().getResources().getDrawable(R.drawable.ic_aid_analyzes));
                break;
        }

    }
}
