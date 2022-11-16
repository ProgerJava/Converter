package com.example.newprojectwithbd.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class FeedReaderDbHelper_2 extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader1.db";

    public FeedReaderDbHelper_2 (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedReaderContract.FeedEntry1.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(FeedReaderContract.FeedEntry1.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void writeToDb (int id, float cost, String country, FeedReaderDbHelper_2 dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry1.ID, id);
        values.put(FeedReaderContract.FeedEntry1.COUNTRY, country);
        values.put(FeedReaderContract.FeedEntry1.COST, cost);
        db.insert(FeedReaderContract.FeedEntry1.TABLE_NAME, null, values);
    }
    public void deleteToDb (int id, FeedReaderDbHelper_2 dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList <String> list = readIntoDbID(dbHelper);
        if (list.contains(String.valueOf(id))) {
            db.delete(FeedReaderContract.FeedEntry1.TABLE_NAME, FeedReaderContract.FeedEntry1.ID + "=" + id, null);
        }
    }
    public ArrayList<String> readIntoDbCost (FeedReaderDbHelper_2 dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry1.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList <String> list = new ArrayList<>();
        while(cursor.moveToNext()) {
            String countryName = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry1.COUNTRY));
            String itemCost = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry1.COST));
            list.add(countryName + " "  + itemCost);
        }
        cursor.close();
        return list;
    }
    public ArrayList<String> readIntoDbID (FeedReaderDbHelper_2 dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {FeedReaderContract.FeedEntry1.ID};

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry1.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null,
                null
        );
        ArrayList <String> list = new ArrayList<>();
        while(cursor.moveToNext()) {
            String itemId = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry1.ID));
            list.add(itemId);
        }
        cursor.close();
        return list;
    }
}