package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataPost implements Serializable {
    @SerializedName("data")
    private InfPost data;

    @SerializedName("date")
    private String date;

    public DataPost(InfPost data, String date) {
        this.data = data;
        this.date = date;
    }

    public InfPost getData() {
        return data;
    }

    public void setData(InfPost data) {
        this.data = data;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
