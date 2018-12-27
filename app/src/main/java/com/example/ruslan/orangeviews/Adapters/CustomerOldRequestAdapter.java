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

import java.util.ArrayList;

public class CustomerOldRequestAdapter extends RecyclerView.Adapter<CustomerOldRequestAdapter.ViewHolder> {
    private String[] names;
    private ArrayList<RequestsItem> requestsItems;

    public static final int TYPE_COMPLETED = 1;
    public static final int TYPE_CANCELED = 2;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cv,int viewType){
            super(cv);
            cardView = cv;
            switch (viewType){
                case TYPE_CANCELED:
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override public void onClick(View v) {
                            Intent intent = new Intent(cardView.getContext(), CustomerRequestActivity.class);
                            intent.putExtra(CustomerRequestActivity.REQUEST_TAG,TYPE_CANCELED);
                            cardView.getContext().startActivity(intent);
                        }
                    });
                    break;
                case TYPE_COMPLETED:
                    cardView.setOnClickListener(new View.OnClickListener() {
                        @Override public void onClick(View v) {
                            Intent intent = new Intent(cardView.getContext(), CustomerRequestActivity.class);
                            intent.putExtra(CustomerRequestActivity.REQUEST_TAG,TYPE_COMPLETED);
                            cardView.getContext().startActivity(intent);
                        }
                    });
                    break;
            }
        }
    }
    public CustomerOldRequestAdapter(String[] names,ArrayList<RequestsItem> requestsItems){
        this.names = names;
        this.requestsItems = requestsItems;
    }
    @Override
    public int getItemViewType(int position) {
        RequestsItem requestsItem = requestsItems.get(position);
        if (requestsItem.getType() == RequestsItem.ItemType.COMPLETED_ITEM) {
            return TYPE_COMPLETED;
        } else if (requestsItem.getType() == RequestsItem.ItemType.CANCELED_ITEM) {
            return TYPE_CANCELED;
        } else {
            return -1;
        }
    }

    @Override
    public CustomerOldRequestAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        if(viewType == TYPE_COMPLETED){
            CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_old_request_card, parent, false);
            return new ViewHolder(cv,viewType);
        }else if(viewType == TYPE_CANCELED){
            CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_old_request_card, parent, false);
            return new ViewHolder(cv,viewType);
        }else{
            throw new RuntimeException("The type has to be COMPLETED or CANCELED");
        }
    }

    @Override
    public int getItemCount(){
        return names.length;
    }


    public void onBindViewHolder(CustomerOldRequestAdapter.ViewHolder holder, int position) {

        CardView cardView = holder.cardView;
        TextView textTitle = (TextView) cardView.findViewById(R.id.request_old_title);
        textTitle.setText(names[position]);
        TextView textStatus = (TextView) cardView.findViewById(R.id.text_request_status);

        switch (holder.getItemViewType()){
            case TYPE_COMPLETED:
                textStatus.setText("Завершена");
                break;
            case TYPE_CANCELED:
                textStatus.setText("Отменена");
                break;
        }
    }
}
