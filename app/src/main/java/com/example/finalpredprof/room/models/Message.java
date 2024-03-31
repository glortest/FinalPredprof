package com.example.finalpredprof.room.models;

public class Message {
    private Date date;
    private Date roomsCount;
    private WindowsForRoom windowsForRoom;
    private Windows windows;

    public Date getDate() {
        return date;
    }

    public void setDate(Date value) {
        this.date = value;
    }

    public Date getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(Date value) {
        this.roomsCount = value;
    }

    public WindowsForRoom getWindowsForRoom() {
        return windowsForRoom;
    }

    public void setWindowsForRoom(WindowsForRoom value) {
        this.windowsForRoom = value;
    }

    public Windows getWindows() {
        return windows;
    }

    public void setWindows(Windows value) {
        this.windows = value;
    }
}
