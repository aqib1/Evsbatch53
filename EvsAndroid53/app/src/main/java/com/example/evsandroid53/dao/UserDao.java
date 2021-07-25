package com.example.evsandroid53.dao;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.evsandroid53.entities.UserEntity;
import java.util.List;

public interface UserDao {

    @Query("SELECT * FROM USERENTITY")
    List<UserEntity> getAll();

    @Query("SELECT * FROM USERENTITY WHERE first_name LIKE :firstName and last_Name LIKE :lastName")
    UserEntity getByFirstAndLastName(String firstName, String  lastName);

    @Insert
    void insertAll(UserEntity... users);
}
