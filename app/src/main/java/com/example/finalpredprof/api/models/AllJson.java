package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AllJson implements Serializable {
    @SerializedName("message")
    private Data data;


    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }



}
