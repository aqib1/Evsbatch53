package com.example.evsandroid53.db.contract;


import android.provider.BaseColumns;

public final class DBReaderContract {
    private DBReaderContract(){

    }
    public static class DBEntry implements BaseColumns {
        // Database information
        public static final int DB_VERSION = 1;
        public static final String DB_NAME="client.db";


        //User table information
        public static final String TABLE_NAME="USER";
        public static final String COLUMN_USERNAME="USERNAME";
        public static final String COLUMN_USER_PASSWORD="USERPASSWORD";

    }
}
