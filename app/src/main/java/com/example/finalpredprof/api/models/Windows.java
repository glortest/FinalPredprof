package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Windows implements Serializable {


    @SerializedName("data")
    private Map<String, List<Boolean>> data;

    @SerializedName("description")
    private String description;


    public Map<String, List<Boolean>> getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

    public void setData(Map<String, List<Boolean>> data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
