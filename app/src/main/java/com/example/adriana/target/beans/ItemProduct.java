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
    private int code;
    private String title;
    private String description;
    private int picture;
    private Store store;
    private Category category;

    public ItemProduct(Parcel in){
        title = in.readString();
        store = in.readParcelable(Store.class.getClassLoader());
        picture = in.readInt();
        code = in.readInt();
        category = in.readParcelable(Category.class.getClassLoader());
    }

    public ItemProduct() {
    }

    public ItemProduct(String title, Store store, int picture1, int code, Category category) {
        this.title = title;
        this.store = store;
        this.picture = picture1;
        this.code = code;
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeParcelable((Parcelable)store,flags);
        dest.writeInt(picture);
        dest.writeInt(code);
        dest.writeParcelable((Parcelable)category,flags);
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
                ", picture=" + picture +
                '}';
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
