package com.example.ruslan.orangeviews.Adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.consultantView.CustomerProfileAboutActivity;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.ViewHolder> {
    private String[] firstNames;
    private String[] middleNames;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cv){
            super(cv);
            cardView = cv;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(cardView.getContext(), CustomerProfileAboutActivity.class);
                    cardView.getContext().startActivity(intent);
                }
            });
        }
    }
    @Override
    public CustomersAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_customer_card, parent, false);
        return new ViewHolder(cv);
    }
    public CustomersAdapter(String[] firstName,String[] middleName){
        this.firstNames = firstName;
        this.middleNames = middleName;
    }
    @Override
    public int getItemCount(){
        return firstNames.length;
    }


    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        TextView textFirstName = (TextView)cardView.findViewById(R.id.card_view_consultant_first_name);
        textFirstName.setText(firstNames[position]);
        TextView textMiddleName = (TextView)cardView.findViewById(R.id.card_view_consultant_middle_name);
        textMiddleName.setText(middleNames[position]);
    }
}
