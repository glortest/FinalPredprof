package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

public class RoomCount {
    @SerializedName("data")
    private int data;

    @SerializedName("description")
    private String description;

    public int getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }
}
