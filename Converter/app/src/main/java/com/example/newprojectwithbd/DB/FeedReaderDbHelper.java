package com.example.newprojectwithbd.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "FeedReader.db";

    ////////////////////////////////////////////////////////////
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

    ////////////////////////////////////////////////////////////
    public void writeToDb(String state, String nameCountry, String nameCurrency, String nameCost, FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.STATE_BOX, state);
        values.put(FeedReaderContract.FeedEntry.NAME_COUNTRY, nameCountry);
        values.put(FeedReaderContract.FeedEntry.NAME_COST, nameCost);
        values.put(FeedReaderContract.FeedEntry.NAME_CURRENCY, nameCurrency);
        db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
    }

//    public void deleteIntoToDb(String idBox, FeedReaderDbHelper dbHelper) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, FeedReaderContract.FeedEntry.STATE_BOX + "=" + idBox, null);
//    }

    public ArrayList<ArrayList<String>> readIntoDbData(FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry.STATE_BOX,
                FeedReaderContract.FeedEntry.NAME_COUNTRY,
                FeedReaderContract.FeedEntry.NAME_COST,
                FeedReaderContract.FeedEntry.NAME_CURRENCY};

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
        ArrayList<ArrayList<String>> listWithArray = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.STATE_BOX)));
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_COUNTRY)));
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_COST)));
            list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_CURRENCY)));
            listWithArray.add(list);
        }
        cursor.close();
        return listWithArray;
    }
    public ArrayList<ArrayList<String>> readIntoDbDataStateTrue (FeedReaderDbHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry.STATE_BOX,
                FeedReaderContract.FeedEntry.NAME_COUNTRY,
                FeedReaderContract.FeedEntry.NAME_COST,
                FeedReaderContract.FeedEntry.NAME_CURRENCY};

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
        ArrayList<ArrayList<String>> listWithArray = new ArrayList<>();
        while (cursor.moveToNext()) {
            ArrayList<String> list = new ArrayList<>();
            boolean state = Boolean.parseBoolean(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.STATE_BOX)));
            if (state) {
                list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_COUNTRY)));
                list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_COST)));
                list.add(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.NAME_CURRENCY)));
                listWithArray.add(list);
            }
        }
        cursor.close();
        return listWithArray;
    }
    public void updateState (String state, String nameCountry,FeedReaderDbHelper dbHelper) {
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.STATE_BOX, state);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.update(FeedReaderContract.FeedEntry.TABLE_NAME,
                values,
                FeedReaderContract.FeedEntry.NAME_COUNTRY + "= ?", new String[]{nameCountry});
    }
    public void updateCost (String cost, String nameCountry,FeedReaderDbHelper dbHelper) {
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.NAME_COST, cost);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db.update(FeedReaderContract.FeedEntry.TABLE_NAME,
                values,
                FeedReaderContract.FeedEntry.NAME_COUNTRY + "= ?", new String[]{nameCountry});
    }
}