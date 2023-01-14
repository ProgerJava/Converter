package com.example.newprojectwithbd.DB;


public final class FeedReaderContract {
    public static class FeedEntry {

        public static final String TABLE_NAME = "table1";

        public static final String STATE_BOX = "state";
        public static final String NAME_COUNTRY = "country";
        public static final String NAME_CURRENCY = "currency";
        public static final String NAME_COST = "cost";

        public static String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                        FeedEntry.STATE_BOX + " TEXT," +
                        FeedEntry.NAME_COUNTRY + " TEXT," +
                        FeedEntry.NAME_COST + " TEXT," +
                        FeedEntry.NAME_CURRENCY + " TEXT)";

        public static String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;
    }
}