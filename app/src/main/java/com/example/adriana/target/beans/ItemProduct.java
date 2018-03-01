package com.example.adriana.target.beans;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.adriana.target.R;

/**
 * Created by adriana on 26/02/2018.
 */

public class ItemProduct {
    private String title;
    private String store;
    private String phone;
    private String location;
    private Drawable picture;

    @Override
    public String toString() {
        return "ItemProduct{" +
                "title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", picture=" + picture +
                '}';
    }

    public ItemProduct(String title, String store, String phone, String location, Drawable picture1) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.picture = picture1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }
}
