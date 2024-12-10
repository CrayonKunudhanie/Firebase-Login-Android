package com.example.signuplogin;
public class DataClass {
    private String title, desc, lang, image;

    public DataClass() {
        // Required for Firebase
    }

    public DataClass(String title, String desc, String lang, String image) {
        this.title = title;
        this.desc = desc;
        this.lang = lang;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getLang() {
        return lang;
    }

    public String getImage() {
        return image;
    }
}
