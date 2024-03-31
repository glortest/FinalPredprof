package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WindowsForRoom {
    @SerializedName("data")
    private List<Integer> data;

    @SerializedName("description")
    private String description;

    public List<Integer> getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }
}
