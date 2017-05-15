package com.inducesmile.androidmultiquiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.inducesmile.androidmultiquiz.entities.Client;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Sandman on 12/05/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_CLIENTS = "clients";
    //public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENTS_TABLE = "CREATE TABLE " + TABLE_CLIENTS + " ( " + COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_EMAIL + " INTEGER NOT NULL UNIQUE )";
        db.execSQL(CREATE_CLIENTS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
        onCreate(db);
    }

    public void addClient(Client client) {
        //Create ContentValues Object to hold data
        ContentValues values = new ContentValues();
        //Assign client name to object taken from passed Client object
        values.put(COLUMN_NAME, client.getName());
        //Assign email to object taken from passed Client object
        values.put(COLUMN_EMAIL, client.getEmail());
        //Create DB object and assign current object to it
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CLIENTS, null, values);
        db.close();
    }

    public Client findAllClients() {
        String query = "SELECT * FROM " + TABLE_CLIENTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Client client = new Client();
        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            client.setName(cursor.getString(1));
            client.setEmail(cursor.getString(2));
            cursor.close();
        } else {
            client = null;
        }
        db.close();
        return client;
    }
}
