package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
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

    public void setDate(DateInf date) {
        this.date = date;
    }

    public void setRooms_count(RoomCount rooms_count) {
        this.rooms_count = rooms_count;
    }

    public void setWindowsForRoom(WindowsForRoom windowsForRoom) {
        this.windowsForRoom = windowsForRoom;
    }

    public void setWindows(Windows windows) {
        this.windows = windows;
    }
}
