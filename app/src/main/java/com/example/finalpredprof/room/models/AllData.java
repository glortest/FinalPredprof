package com.example.finalpredprof.room.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class AllData {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message value) {
        this.message = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
