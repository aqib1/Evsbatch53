package com.example.evsandroid53.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.evsandroid53.dao.UserDao;
import com.example.evsandroid53.entities.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}