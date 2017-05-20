package com.inducesmile.androidmultiquiz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.inducesmile.androidmultiquiz.entities.Client;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandman on 12/05/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_CLIENTS = "clients";
    public static final String COLUMN_CLIENT_ID = "client_id";
    public static final String COLUMN_CLIENT_NAME = "client_name";
    public static final String COLUMN_CLIENT_EMAIL = "client_email";

    private String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENTS + "("
            + COLUMN_CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CLIENT_NAME + " TEXT,"
            + COLUMN_CLIENT_EMAIL + " TEXT" + ")";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CLIENT_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
        onCreate(db);
    }

    public void addClient(Client client) {
        //Create ContentValues Object to hold data
        ContentValues values = new ContentValues();
        //Assign client name to object taken from passed Client object
        values.put(COLUMN_CLIENT_NAME, client.getName());
        //Assign email to object taken from passed Client object
        values.put(COLUMN_CLIENT_EMAIL, client.getEmail());
        //Create DB object and assign current object to it
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_CLIENTS, null, values);
        db.close();
    }
    public List<Client> getAllClient() {

        // array of columns to fetch
        String[] columns = {
                COLUMN_CLIENT_ID,
                COLUMN_CLIENT_NAME,
                COLUMN_CLIENT_EMAIL
        };
        // sorting orders
    //    String sortOrder =
    //            COLUMN_USER_NAME + " ASC";
        List<Client> clientList = new ArrayList<Client>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_CLIENTS, //Table to query
                columns,    //columns to return
                null,       //columns for the WHERE clause
                null,       //The values for the WHERE clause
                null,       //group the rows
                null,        //filter by row groups
                null);    //The sort order


        // Traversing through all rows and adding to list
            if (cursor.moveToFirst()) {
            do {
                Client client = new Client();
                client.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CLIENT_ID))));
                client.setName(cursor.getString(cursor.getColumnIndex(COLUMN_CLIENT_NAME)));
                client.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_CLIENT_EMAIL)));
    //            client.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                // Adding user record to list
                clientList.add(client);
            } while (cursor.moveToNext());
        }
            cursor.close();
            db.close();

        // return user list
            return clientList;
    }

    public boolean checkClient(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_CLIENT_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_CLIENT_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_CLIENTS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
