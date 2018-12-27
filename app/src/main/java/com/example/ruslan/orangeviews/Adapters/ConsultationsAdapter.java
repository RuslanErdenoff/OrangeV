package com.example.ruslan.orangeviews.Adapters;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ruslan.orangeviews.view.customerView.ChatActivity;
import com.example.ruslan.orangeviews.R;

public class ConsultationsAdapter extends RecyclerView.Adapter<ConsultationsAdapter.ViewHolder> {
    private String[] firstNames;
    private String[] middleNames;
    private boolean[] isReaded;
    private String[] unReadedMessages;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cv){
            super(cv);
            cardView = cv;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent intent = new Intent(cardView.getContext(), ChatActivity.class);
                    cardView.getContext().startActivity(intent);
                }
            });
        }
    }
    @Override
    public ConsultationsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_consultations_card, parent, false);
        return new ConsultationsAdapter.ViewHolder(cv);
    }
    public ConsultationsAdapter(String[] firstName, String[] middleName, boolean[] isReaded, String[] unReadedMessages){
        this.firstNames = firstName;
        this.middleNames = middleName;
        this.isReaded = isReaded;
        this.unReadedMessages = unReadedMessages;
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
        LinearLayout linearLayout = (LinearLayout) cardView.findViewById(R.id.card_view_linear_layout_unreaded_message);
        if(isReaded[position]){
            linearLayout.setVisibility(View.VISIBLE);
            TextView textUnreadeMessage = (TextView) cardView.findViewById(R.id.text_unreaded_message);
            textUnreadeMessage.setText(unReadedMessages[position]);

            FrameLayout frameLayout = (FrameLayout)cardView.findViewById(R.id.frame_layout_chat_unreaded_count);
            frameLayout.setVisibility(View.VISIBLE);

            ImageButton imageButton = (ImageButton)cardView.findViewById(R.id.image_button_view_chat);
            imageButton.setVisibility(View.GONE);
        }else{
            linearLayout.setVisibility(View.GONE);
        }
    }
}
