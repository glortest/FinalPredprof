package com.example.finalpredprof.room.room_logic;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.finalpredprof.room.models.AllData;

@Database(entities = {AllData.class}, version = 1, exportSchema = true)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract DataDao dataDao();
}
