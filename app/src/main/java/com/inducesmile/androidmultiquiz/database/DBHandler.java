package com.inducesmile.androidmultiquiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.inducesmile.androidmultiquiz.entities.Client;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Sandman on 12/05/2017.
 */

public class DBHandler extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "quiz";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_CLIENT = "clients";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void addClient(Client client) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, client.getName());
        values.put(COLUMN_EMAIL, client.getEmail());
        //Create DB object and assign current object to it
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CLIENT, null, values);
        db.close();
    }
}
