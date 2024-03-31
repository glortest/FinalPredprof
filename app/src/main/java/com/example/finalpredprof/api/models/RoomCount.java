package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RoomCount implements Serializable  {
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

    public void setData(int data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
