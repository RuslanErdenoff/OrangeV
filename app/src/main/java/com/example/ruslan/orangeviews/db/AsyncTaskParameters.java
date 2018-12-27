package com.example.ruslan.orangeviews.db;

import android.content.Context;
import android.database.Cursor;
import android.view.View;

public class AsyncTaskParameters {
    private Context context;

    public Cursor getCursor() {
        return cursor;
    }

    private Cursor cursor;

    public String getName() {
        return name;
    }

    private String name;

    public Context getContext() {
        return context;
    }

    public View getView() {
        return view;
    }

    private View view;

    public AsyncTaskParameters(Cursor cursor, String name, Context context, View view){
        this.context = context;
        this.view = view;
        this.name = name;
        this.cursor = cursor;
    }


}
