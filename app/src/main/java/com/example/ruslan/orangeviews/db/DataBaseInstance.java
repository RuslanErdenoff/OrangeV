package com.example.ruslan.orangeviews.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataBaseInstance {
    public static SQLiteOpenHelper myDb;
    public static void createDB(Context context){
        try {
            myDb = new DataBaseHelper(context);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(context, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public static void closeDB(){
        myDb.close();
    }
}
