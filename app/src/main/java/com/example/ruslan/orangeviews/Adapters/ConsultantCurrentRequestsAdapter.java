package com.example.ruslan.orangeviews.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.ConsultantCurrentRequestActivity;
import com.example.ruslan.orangeviews.R;

public class ConsultantCurrentRequestsAdapter extends RecyclerView.Adapter<ConsultantCurrentRequestsAdapter.ViewHolder> {
    private int count = 0;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cv){
            super(cv);
            cardView = cv;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(cardView.getContext(), ConsultantCurrentRequestActivity.class);
                    cardView.getContext().startActivity(intent);
                }
            });
        }
    }
    @Override
    public ConsultantCurrentRequestsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_consultant_current_request_card, parent, false);
        return new ConsultantCurrentRequestsAdapter.ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public ConsultantCurrentRequestsAdapter(int count){
        this.count = count;
    }
    @Override
    public int getItemCount(){
        return count;
    }

}
