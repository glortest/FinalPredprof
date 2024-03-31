package com.example.finalpredprof.room.room_logic;

import android.content.Context;

import androidx.room.Room;

public class RoomHandler {
    private static RoomHandler mInstance;
    private final Context mCtx;
    private final AppDatabase appDatabase;

    private RoomHandler(Context mCtx) {
        this.mCtx = mCtx;
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, "data")
                .build();
    }

    public static RoomHandler getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new RoomHandler(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}