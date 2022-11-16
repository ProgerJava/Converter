package com.example.newprojectwithbd.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "FeedReader.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FeedReaderContract.FeedEntry.SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(FeedReaderContract.FeedEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    public void writeToDb (String name, int id, FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.NAME_COUNTRY, name);
        values.put(FeedReaderContract.FeedEntry.ID, id + "");
        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
    }
    public void deleteToDb (String name, int id, FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection1 = FeedReaderContract.FeedEntry.NAME_COUNTRY + " LIKE ?";
        String selection2 = FeedReaderContract.FeedEntry.ID + " LIKE ?";
        String[] selectionArgs1 =  {name};
        db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection1, selectionArgs1);
        String[] selectionArgs2 = {String.valueOf(id)};
        db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection2, selectionArgs2);
    }
    public ArrayList <String> readIntoDbCountry (FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {FeedReaderContract.FeedEntry.NAME_COUNTRY};

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
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
            String itemId = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_COUNTRY));
            list.add(itemId);
        }
        cursor.close();
        return list;
    }
    public ArrayList <String> readIntoDbBoxID (FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {FeedReaderContract.FeedEntry.ID};
        Cursor cursor = db.query(FeedReaderContract.FeedEntry.TABLE_NAME, projection, null, null, null, null, null, null);
        ArrayList<String> itemIds = new ArrayList<>();
        while (cursor.moveToNext()) {
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.ID));
            itemIds.add(itemName);
        }
        cursor.close();
        return itemIds;
    }
}