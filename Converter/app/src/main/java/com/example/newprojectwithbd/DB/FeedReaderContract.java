package com.example.newprojectwithbd.DB;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    public static class FeedEntry {
        public static final String TABLE_NAME = "entry";
        public static final String NAME_COUNTRY = "title";
        public static final String ID = "count";


        public static String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                        FeedEntry.NAME_COUNTRY + " TEXT," +
                        FeedEntry.ID + " TEXT)";

        public static String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    }
    public static class FeedEntry1  {
        public static final String TABLE_NAME = "entry";
        public static final String COST = "cost";
        public static final String ID = "id";
        public static final String COUNTRY = "name";

        public static String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry1.TABLE_NAME + " (" +
                        FeedEntry1.ID + " INTEGER PRIMARY KEY," +
                        FeedEntry1.COUNTRY + " TEXT," +
                        FeedEntry1.COST + " TEXT)";

        public static String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry1.TABLE_NAME;
    }
}