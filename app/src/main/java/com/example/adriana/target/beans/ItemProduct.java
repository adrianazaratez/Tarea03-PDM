package com.example.adriana.target.beans;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.example.adriana.target.R;

/**
 * Created by adriana on 26/02/2018.
 */

public class ItemProduct implements Parcelable{
    private String title;
    private String store;
    private String phone;
    private String location;
    private int picture;
    private String imageResource;
    private int code;

    public ItemProduct(Parcel in){
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        picture = in.readInt();
        code = in.readInt();
 //       imageResource = in.readString();
    }

    public ItemProduct(String title, String store, String location,  String phone,int picture1,int code) {
        this.title = title;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.picture = picture1;
        this.code = code;
   //     this.imageResource = picture1.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(store);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeInt(picture);
        dest.writeInt(code);
   //     dest.writeString(imageResource);
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR =
            new Parcelable.Creator<ItemProduct>(){
                @Override
                public ItemProduct createFromParcel(Parcel source) {
                    return new ItemProduct(source);
                }

                @Override
                public ItemProduct[] newArray(int size) {
                    return new ItemProduct[size];
                }
            };

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getImageResource() {
        return imageResource;
    }

    public void setImageResource(String imageResource) {
        this.imageResource = imageResource;
    }
}
