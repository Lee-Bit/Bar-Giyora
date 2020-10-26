package com.example.bargiyora.model;

import com.google.gson.annotations.SerializedName;

public class Site {
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("content")
    private String mContent;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("categoryId")
    private String mCategoryId;

    public Site(String id, String name, String phone, String content, String address, String categoryId){
        this.mId=id;
        this.mName=name;
        this.mPhone=phone;
        this.mContent=content;
        this.mAddress=address;
        this.mCategoryId=categoryId;
    }

    public String getId(){return mId;}
    public String getName(){return mName;}
    public String getPhone(){return mPhone;}
    public String getContent(){return mContent;}
    public String getAddress(){return  mAddress;}
    public String getCategoryId(){return mCategoryId;}
}
