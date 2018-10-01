package com.example.android.mycontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Android on 6/14/2017.
 */
public class ContactDB extends SQLiteOpenHelper {
    public ContactDB(Context context)
    {
        super(context,"ContacatDataBase",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        //Command to create table
        String cmd1="Create table contact(id integer primary key," +
                " cname text," +
                " cphone text," +
                "cemail text)";

        sqLiteDatabase.execSQL(cmd1);
        //sqLiteDatabase.execSQL(cmd2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
