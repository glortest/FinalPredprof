package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class InfPost implements Serializable {

    public InfPost(int count, List<Integer> rooms) {
        this.count = count;
        this.rooms = rooms;
    }

    @SerializedName("count")
    private int count;

    @SerializedName("rooms")
    private List<Integer> rooms;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(List<Integer> rooms) {
        this.rooms = rooms;
    }
}
