package com.example.evsandroid53.db.helper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.evsandroid53.db.contract.DBReaderContract;
import com.example.evsandroid53.db.helper.query.UserQueryHelper;
import com.example.evsandroid53.entities.User;
import com.example.evsandroid53.exceptions.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class UserDbHelper extends SQLiteOpenHelper {

    public UserDbHelper(Context contexts) {
        super(contexts, DBReaderContract.DBEntry.DB_NAME, null, DBReaderContract.DBEntry.DB_VERSION);
    }

    public long insert(User user) {
        long rowId = 0L;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBReaderContract.DBEntry.COLUMN_USERNAME, user.getUserName());
        contentValues.put(DBReaderContract.DBEntry.COLUMN_USER_PASSWORD, user.getUserPassword());
        // nullable columns
        rowId = db.insert(DBReaderContract.DBEntry.TABLE_NAME, null, contentValues);
        db.close();
        return rowId;
    }

    private List<User> getUsersInside(Cursor cursor) {
        List<User> users = null;
        if (cursor.getCount() > 0) {
            users = new ArrayList<>();
            cursor.moveToFirst();
            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(DBReaderContract.DBEntry._ID)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(DBReaderContract.DBEntry.COLUMN_USERNAME)));
                user.setUserPassword(cursor.getString(cursor.getColumnIndex(DBReaderContract.DBEntry.COLUMN_USER_PASSWORD)));
                users.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }

    public List<User> getUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> users = null;
        Cursor cursor = db.rawQuery(UserQueryHelper.SQL_USER_READ_TABLE, null);
        users = getUsersInside(cursor);
        db.close();
        return users;
    }

    public List<User> getUsersBySelectionArgs(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DBReaderContract.DBEntry._ID,
                DBReaderContract.DBEntry.COLUMN_USERNAME,
                DBReaderContract.DBEntry.COLUMN_USER_PASSWORD
        };
        // Filter results WHERE "title" = 'My Title'
        String selection = DBReaderContract.DBEntry.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = { user.getUserName() };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                DBReaderContract.DBEntry.COLUMN_USERNAME  + " DESC";
        Cursor cursor = db.query(
                DBReaderContract.DBEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );
        List<User> users = getUsersInside(cursor);
        db.close();
        return users;
    }

    public int delete(User user) {
        if(getUsersBySelectionArgs(user).isEmpty()) {
            // something
            throw new DataNotFoundException("user does not exists");
        }
        SQLiteDatabase db = this.getWritableDatabase();
        // Define 'where' part of query.
        String selection =
                DBReaderContract.DBEntry.COLUMN_USERNAME + " = ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = {user.getUserName()};
        // Issue SQL statement.
        int deletedRows = db.delete(DBReaderContract.DBEntry.TABLE_NAME, selection, selectionArgs); // 0

        db.close();
        if(deletedRows == 0)
            throw new DataNotFoundException("User does not exists against USER = "+ user.getUserName());

        return deletedRows;
    }

    public int update(User existingUser, User updatedUser) {
        SQLiteDatabase db = this.getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(DBReaderContract.DBEntry.COLUMN_USERNAME, updatedUser.getUserName());
        values.put(DBReaderContract.DBEntry.COLUMN_USER_PASSWORD, updatedUser.getUserPassword());

        // Which row to update, based on the title
        String selection = DBReaderContract.DBEntry.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {existingUser.getUserName() };

        int count = db.update(
                DBReaderContract.DBEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        db.close();

        return count;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserQueryHelper.SQL_USER_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserQueryHelper.SQL_USER_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
