package com.example.ruslan.orangeviews.Adapters;

public class ChatItem {
    public enum ItemType {
        RECEIVE_ITEM, SEND_ITEM;
    }

    private ItemType type;

    public ChatItem(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
