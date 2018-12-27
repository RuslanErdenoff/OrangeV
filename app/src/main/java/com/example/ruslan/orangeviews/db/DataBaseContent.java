package com.example.ruslan.orangeviews.db;

import android.content.Context;
import android.database.Cursor;

public class DataBaseContent {
    public static DataBaseContent dataBaseInstance = new DataBaseContent();
    private Cursor cursor;
    public DataBaseContent(){

    }

    /*public String[] getCities(Context context){
        cursor =  DataBaseInstance.getReadableDBInstance(context).query("CITIES",new String[]{"NAME"},null,null,null,null,null);

    }*/
}
