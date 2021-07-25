package com.example.evsandroid53.db.helper.query;

import com.example.evsandroid53.db.contract.DBReaderContract;

public final class UserQueryHelper {
    private UserQueryHelper(){

    }
    public static final String SQL_USER_CREATE_TABLE = "CREATE TABLE " + DBReaderContract.DBEntry.TABLE_NAME + " (" + DBReaderContract.DBEntry._ID + " INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL," + DBReaderContract.DBEntry.COLUMN_USERNAME + " TEXT NOT NULL," + DBReaderContract.DBEntry.COLUMN_USER_PASSWORD + " TEXT);";
    public static final String SQL_USER_READ_TABLE = "SELECT * FROM "+ DBReaderContract.DBEntry.TABLE_NAME;
    public static final String SQL_USER_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBReaderContract.DBEntry.TABLE_NAME;

}
