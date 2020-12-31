package com.example.RecipeManager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DataDao {

    @Query("SELECT * FROM data")
    List<Data> getAllData();

    @Query("DELETE FROM data")
    void deleteAll();

    @Insert(onConflict = REPLACE)
    void insert(Data data);

    @Delete
    void delete(Data data);

    @Update(onConflict = REPLACE)
    void update(Data data);



}
