package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WindowsForRoom implements Serializable {
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

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
