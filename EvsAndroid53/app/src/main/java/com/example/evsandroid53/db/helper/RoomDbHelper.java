package com.example.evsandroid53.db.helper;

import android.content.ContentValues;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.evsandroid53.db.AppDatabase;

import java.util.Objects;

public class RoomDbHelper {

    private static final String DB_NAME = "UserDB";
    private static RoomDbHelper roomDbHelper = null;
    private AppDatabase db;

    private RoomDbHelper(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, DB_NAME).build();
    }

    public AppDatabase getDb() {
        return db;
    }

    public static RoomDbHelper getInstance(Context context) {
        if(Objects.isNull(roomDbHelper)) {
            synchronized (RoomDbHelper.class) {
                if(Objects.isNull(roomDbHelper)) {
                    roomDbHelper = new RoomDbHelper(context);
                }
            }
        }
        return roomDbHelper;
    }
}
