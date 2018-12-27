package com.example.ruslan.orangeviews.db;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

public class DataBaseAsyncTask extends AsyncTask<AsyncTaskParameters,Void,Boolean> {

    @Override
    protected Boolean doInBackground(AsyncTaskParameters... asyncTaskParameters) {
       /* switch (asyncTaskParameters[0].getName()){
            case "CITIES":
                Cursor cursor = asyncTaskParameters[0].getCursor();
                for(int i =0;i< cursor.getCount();i++){
                    View child = inflater.inflate(R.layout.item_child_text,null,false);
                    linearLayout.addView(child);
                    TextView id = (TextView)child.findViewById(R.id._id);
                    TextView name = (TextView)child.findViewById(R.id.name);
                    TextView desc = (TextView)child.findViewById(R.id.desc);

                    if(i==0){
                        if(cursor.moveToFirst()){
                            id.setText(cursor.getString(0));
                            name.setText(cursor.getString(1));
                            desc.setText(cursor.getString(2));
                        }
                    }else{
                        if(cursor.moveToNext()){
                            id.setText(cursor.getString(0));
                            name.setText(cursor.getString(1));
                            desc.setText(cursor.getString(2));
                        }
                    }
                }
                break;
        }
        return null;
    }*/
        return null;
    }
}
