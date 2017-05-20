package com.inducesmile.androidmultiquiz.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseObject {

    private static Database dbHelper;
    private SQLiteDatabase db;
    private SQLiteDatabase dbWrite;

    public DatabaseObject(Context context) {
        dbHelper = new Database(context);
        //Assign writable db to variable
        this.dbWrite = this.dbHelper.getWritableDatabase();
        this.db = dbHelper.getReadableDatabase();
    }


    public SQLiteDatabase getDbConnection(){
        return this.db;
    }


    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }
}
