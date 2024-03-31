package com.example.finalpredprof.grid;

public class ItemModel {
    private String text;
    private int backgroundColor;

    public ItemModel(String text, int backgroundColor) {
        this.text = text;
        this.backgroundColor = backgroundColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
