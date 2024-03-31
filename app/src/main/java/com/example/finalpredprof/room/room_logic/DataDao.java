package com.example.finalpredprof.room.room_logic;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.finalpredprof.room.models.AllData;

import java.util.List;

@Dao
public interface DataDao {
    @Transaction
    @Query("SELECT * FROM AllData")
    public List<AllData> getAllData();


    @Insert
    void insertAll(AllData... data);

    @Delete
    void delete(AllData data);

    @Query("DELETE FROM AllData")
    void delete_all();
}