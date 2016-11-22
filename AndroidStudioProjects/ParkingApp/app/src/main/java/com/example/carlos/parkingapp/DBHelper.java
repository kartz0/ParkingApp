package com.example.carlos.parkingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Carlos on 11/21/2016.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="userlist.db";
    private static final String TABLE_NAME ="users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PWD = "pwd";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE users (id INTEGER PRIMARY KEY NOT NULL, " +
                                                            "name text NOT NULL, email text NOT NULL, pwd text NOT NULL )";

    @Override
    public void onCreate(SQLiteDatabase db){
        //RUNS THE TABLE CREATE COMMANDS
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }
    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

            String query = "DROP TABLE IF EXISTS" + TABLE_NAME;

            db.execSQL(query);

            onCreate(db);

    }
    public void insertUser(UserList user){

        db = this.getWritableDatabase();
        ContentValues vals = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();

        vals.put(COLUMN_ID, count);
        vals.put(COLUMN_NAME, user.getName());
        vals.put(COLUMN_EMAIL, user.getEmail());
        vals.put(COLUMN_PWD, user.getpwd());

        db.insert(TABLE_NAME, null, vals);
        db.close();
    }

    public String getPass(String email){

        db = this.getReadableDatabase();
        String query = "SELECT email, pwd  FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "Not Found";

        //////CURSOR.MOVETOFIRST NOT RETURNING TRUE
        if(cursor.moveToFirst()){

            do{
                a= cursor.getString(0);

                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());

        }

        return b;
    }
}
