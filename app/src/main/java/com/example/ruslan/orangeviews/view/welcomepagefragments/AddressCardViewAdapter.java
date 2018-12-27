package com.example.ruslan.orangeviews.view.welcomepagefragments;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruslan.orangeviews.R;

public class AddressCardViewAdapter extends RecyclerView.Adapter<AddressCardViewAdapter.AdressCardViewAdapterHolder>{
    private String[] addresses;
    private String city;
    public AddressCardViewAdapter(String city,String[] addresses){
        this.addresses = addresses;
        this.city = city;
    }
    public static class AdressCardViewAdapterHolder extends RecyclerView.ViewHolder {
        //Определить представление для каждого элемента данных
        private CardView cardView;

        public AdressCardViewAdapterHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
    @Override
    public int getItemCount(){
        return addresses.length;
    }
    @Override
    public AddressCardViewAdapter.AdressCardViewAdapterHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        //Код создания экземпляра ViewHolder
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.address_card_view, parent, false);
        return new AdressCardViewAdapterHolder(cv);
    }
    @Override
    public void onBindViewHolder(AdressCardViewAdapterHolder holder, int position){
        CardView cardView = holder.cardView;
        TextView addressTextView = (TextView)cardView.findViewById(R.id.customer_profile_home_address);
        TextView addressCityTextView = (TextView)cardView.findViewById(R.id.customer_profile_home_address_city);
        addressTextView.setText(addresses[position]);
        addressCityTextView.setText(city);
    }
}
