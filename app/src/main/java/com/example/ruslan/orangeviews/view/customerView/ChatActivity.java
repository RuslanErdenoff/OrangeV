package com.example.ruslan.orangeviews.view.customerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.ruslan.orangeviews.Adapters.ChatAdapter;
import com.example.ruslan.orangeviews.Adapters.ChatItem;
import com.example.ruslan.orangeviews.R;
import com.example.ruslan.orangeviews.view.BaseActivity;

import java.util.ArrayList;

public class ChatActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,R.layout.activity_chat);
        ArrayList<ChatItem> chatItems = new ArrayList<>();

        chatItems.add(new ChatItem(ChatItem.ItemType.RECEIVE_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.SEND_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.RECEIVE_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.RECEIVE_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.SEND_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.RECEIVE_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.SEND_ITEM));
        chatItems.add(new ChatItem(ChatItem.ItemType.SEND_ITEM));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chat_recycler);
        ChatAdapter chatAdapter = new ChatAdapter(chatItems);
        recyclerView.setAdapter(chatAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        initToolbar("Консультация");

    }

}
