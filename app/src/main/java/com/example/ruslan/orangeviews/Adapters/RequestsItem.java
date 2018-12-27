package com.example.ruslan.orangeviews.Adapters;

public class RequestsItem {
    public enum ItemType {
        COMPLETED_ITEM, CANCELED_ITEM;
    }

    private ItemType type;

    public RequestsItem(ItemType type) {
        this.type = type;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}
