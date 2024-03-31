package com.example.finalpredprof.api.models;

import com.google.gson.annotations.SerializedName;

public class Swans {
    @SerializedName("id")
    private String id;
    @SerializedName("rate")
    private int rate;

    public Swans(String id, int rate) {
        this.id = id;
        this.rate = rate;

    }

    public String getId() {
        return this.id;
    }

    public int getRate() {
        return rate;
    }


}
