package com.example.myapplication;

public class Player {
    private String name;
    private String description;
    private int image;
    private String detail;

    public Player(String name, String description, int image, String detail) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
