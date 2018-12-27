package com.example.ruslan.orangeviews.Adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.view.customerView.CustomerRequestActivity;
import com.example.ruslan.orangeviews.R;

public class CustomerCurrentRequestsAdapter extends RecyclerView.Adapter<CustomerCurrentRequestsAdapter.ViewHolder> {
    private String[] names;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cv){
            super(cv);
            cardView = cv;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(cardView.getContext(), CustomerRequestActivity.class);
                    intent.putExtra(CustomerRequestActivity.REQUEST_TAG,3);
                    cardView.getContext().startActivity(intent);
                }
            });
        }
    }
    public CustomerCurrentRequestsAdapter(String[] names){
        this.names = names;
    }

    @Override
    public CustomerCurrentRequestsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_current_request_card, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public int getItemCount(){
        return names.length;
    }


    public void onBindViewHolder(CustomerCurrentRequestsAdapter.ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        TextView textTitle = (TextView) cardView.findViewById(R.id.request_current_title);
        textTitle.setText(names[position]);
    }
}
