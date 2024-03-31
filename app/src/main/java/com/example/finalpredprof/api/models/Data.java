package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("date")
    private DateInf date;

    @SerializedName("rooms_count")
    private RoomCount rooms_count;

    @SerializedName("windows_for_room")
    private WindowsForRoom windowsForRoom;

    @SerializedName("windows")
    private Windows windows;

    public DateInf getDate() {
        return date;
    }

    public RoomCount getRooms_count() {
        return rooms_count;
    }

    public WindowsForRoom getWindowsForRoom() {
        return windowsForRoom;
    }

    public Windows getWindows() {
        return windows;
    }
}
