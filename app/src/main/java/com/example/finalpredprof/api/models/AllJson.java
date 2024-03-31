package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllJson {
    @SerializedName("message")
    private Data data;




    public Data getAll() {
        return data;
    }
}
