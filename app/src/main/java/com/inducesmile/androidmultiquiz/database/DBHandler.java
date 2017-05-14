package com.inducesmile.androidmultiquiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.inducesmile.androidmultiquiz.entities.Client;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Sandman on 12/05/2017.
 */

public class DBHandler extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "quiz";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_CLIENT = "clients";
    //public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_CLIENTS_TABLE = "CREATE TABLE " + TABLE_CLIENT + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_EMAIL + " TEXT)";
//        db.execSQL(CREATE_CLIENTS_TABLE);
//    }
//
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
//        onCreate(db);
//    }

    public void addClient(Context context, Client client) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, client.getName());
        values.put(COLUMN_EMAIL, client.getEmail());
        DatabaseQuery dbQuery = new DatabaseQuery(context);
        SQLiteDatabase db = dbQuery.getDbWrite();
        //SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CLIENT, null, values);
        db.close();
    }

//    public Client findClient(int id) {
//        String query = "SELECT * FROM " + TABLE_CLIENT + " WHERE " + COLUMN_ID + " = '" + id + "';";
//    }
}
