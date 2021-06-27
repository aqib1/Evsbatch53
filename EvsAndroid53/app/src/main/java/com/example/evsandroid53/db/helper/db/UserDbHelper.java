package com.example.evsandroid53.db.helper.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.evsandroid53.db.contract.DBReaderContract;
import com.example.evsandroid53.db.helper.query.UserQueryHelper;
import com.example.evsandroid53.entities.User;

import java.util.ArrayList;
import java.util.List;


public class UserDbHelper extends SQLiteOpenHelper {

    public UserDbHelper(Context contexts){
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

    private List<User> getUsersInside(Cursor cursor){
        List<User> users=null;
        if(cursor.getCount() > 0){
            users = new ArrayList<>();
            cursor.moveToFirst();
            do{
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(DBReaderContract.DBEntry._ID)));
                user.setUserName(cursor.getString(cursor.getColumnIndex(DBReaderContract.DBEntry.COLUMN_USERNAME)));
                user.setUserPassword(cursor.getString(cursor.getColumnIndex(DBReaderContract.DBEntry.COLUMN_USER_PASSWORD)));
                users.add(user);
            } while (cursor.moveToNext());
        }
        return users;
    }
    public List<User> getUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<User> users=null;
        Cursor cursor=db.rawQuery(UserQueryHelper.SQL_USER_READ_TABLE,null);
        users= getUsersInside(cursor);
        db.close();
        return users;
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
