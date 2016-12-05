package com.example.android.toqc.models;

/**
 * Created by ujjawal on 2/12/16.
 */

public class ShowCategory {
    private String text;
    private int imageBackground;
    private int textBackground;
    private int thumbnail;

    public ShowCategory() {

    }

    public ShowCategory(String text, int imageBackground, int textBackground, int thumbnail) {
        this.text = text;
        this.imageBackground = imageBackground;
        this.textBackground = textBackground;
        this.thumbnail = thumbnail;
    }

    public String getText() {
        return text;
    }

    public int getImageBackground() {
        return imageBackground;
    }

    public int getTextBackground() {
        return textBackground;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setImageBackground(int imageBackground) {
        this.imageBackground = imageBackground;
    }

    public void setTextBackground(int textBackground) {
        this.textBackground = textBackground;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setText(String text) {
        this.text = text;
    }
}
