package com.example.ruslan.orangeviews.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "OrangeDB";
    private static final int DB_VERSION = 1;

    public DataBaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion < 1){
            db.execSQL("CREATE TABLE CITIES("
                    +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"NAME TEXT);");
            insertCity(db, "Алма-ата");
            insertCity(db, "Астана");
            insertCity(db, "Шымкент");
            insertCity(db,"Караганда");
            insertCity(db, "Актобе");
            insertCity(db, "Тараз");
            insertCity(db, "Павлодар");
            insertCity(db,"Усть-Каменогорск");
            insertCity(db,"Семей");
            insertCity(db,"Уральск");
            insertCity(db,"Костанай");

            db.execSQL("CREATE TABLE USER("
                    +"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"FIRST_NAME TEXT,"
                    +"MIDDLE_NAME TEXT,"
                    +"LAST_NAME TEXT,"
                    +"PHONE_NUMBER INTEGER,"
                    +"CITY TEXT,"
                    +"GENDER TEXT,"
                    +"BIRTHDAY TEXT,"
                    +"HEIGHT INTEGER,"
                    +"WEIGHT INTEGER,"
                    +"ALLERGIES TEXT);");

            /*ContentValues drinkValues = new ContentValues();
            drinkValues.put("NAME","MacCoffe");
            drinkValues.put("DESCRIPTION","Three in one");
            db.update("DRINK",drinkValues,"NAME=?",new String[] {"Latte"});*/
        }
        if(oldVersion < 2){
            //db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC;");
        }
    }
    public static void insertCity(SQLiteDatabase db,String name){
        ContentValues cityValues = new ContentValues();
        cityValues.put("NAME",name);

        db.insert("CITIES",null,cityValues);
    }
    public static void insertUser(SQLiteDatabase db,String firstName,String middleName,String lastName,int phoneNumber,String city,String gender,String birthday,int height,int weight,String allergies){
        ContentValues userInfo = new ContentValues();
        userInfo.put("FIRST_NAME",firstName);
        userInfo.put("MIDDLE_NAME",middleName);
        userInfo.put("LAST_NAME",lastName);
        userInfo.put("PHONE_NUMBER",phoneNumber);
        userInfo.put("CITY",city);
        userInfo.put("GENDER",gender);
        userInfo.put("BIRTHDAY",birthday);
        userInfo.put("HEIGHT",height);
        userInfo.put("WEIGHT",weight);
        userInfo.put("ALLERGIES",allergies);

        db.insert("USER",null,userInfo);
    }
}
