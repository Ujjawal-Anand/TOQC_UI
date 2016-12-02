package com.example.android.toqc.models;

/**
 * Created by ujjawal on 2/12/16.
 */

public class ShowCategory {
    private String text;
    private int thumbnail;

    public ShowCategory() {

    }

    public ShowCategory(String text, int thumbnail) {
        this.text = text;
        this.thumbnail = thumbnail;
    }

    public String getText() {
        return text;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setText(String text) {
        this.text = text;
    }
}
