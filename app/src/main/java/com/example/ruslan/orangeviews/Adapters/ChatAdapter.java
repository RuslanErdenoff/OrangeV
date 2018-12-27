package com.example.ruslan.orangeviews.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruslan.orangeviews.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private ArrayList<ChatItem> chatItems;

    private static final int TYPE_RECIEVE = 1;
    private static final int TYPE_SEND = 2;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        public ViewHolder(View cv){
            super(cv);
            view = cv;
        }
    }
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        if(viewType == TYPE_RECIEVE){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_recieve, parent, false);
            return new ChatAdapter.ViewHolder(view);
        }else if (viewType == TYPE_SEND){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_send, parent, false);
            return new ChatAdapter.ViewHolder(view);
        }else{
            throw new RuntimeException("The type has to be RECEIVE or SEND");
        }
    }
    public ChatAdapter(ArrayList<ChatItem> chatItems){
        this.chatItems = chatItems;
    }
    @Override
    public int getItemCount() {
        return chatItems == null ? 0 : chatItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        ChatItem chatItem = chatItems.get(position);
        if (chatItem.getType() == ChatItem.ItemType.RECEIVE_ITEM) {
            return TYPE_RECIEVE;
        } else if (chatItem.getType() == ChatItem.ItemType.SEND_ITEM) {
            return TYPE_SEND;
        } else {
            return -1;
        }
    }

    public void onBindViewHolder(ChatAdapter.ViewHolder holder, int position){

        /*CardView cardView = holder.cardView;
        TextView textFirstName = (TextView)cardView.findViewById(R.id.card_view_consultant_first_name);
        textFirstName.setText(firstNames[position]);
        TextView textMiddleName = (TextView)cardView.findViewById(R.id.card_view_consultant_middle_name);
        textMiddleName.setText(middleNames[position]);*/
    }

    /*static class ViewHolderReceive extends RecyclerView.ViewHolder {
        public ViewHolderOne(View itemView) {
            super(itemView);
        }
    }

    static class ViewHolderSend extends RecyclerView.ViewHolder {
        public ViewHolderTwo(View itemView) {
            super(itemView);
        }
    }*/
}
