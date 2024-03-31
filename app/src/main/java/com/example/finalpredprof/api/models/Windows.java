package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class Windows {


    @SerializedName("data")
    private List<Map<String, List<Boolean>>> data;

    @SerializedName("description")
    private String description;


    public List<Map<String, List<Boolean>>> getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }
}
