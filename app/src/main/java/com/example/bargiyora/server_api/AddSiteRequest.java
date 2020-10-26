package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class AddSiteRequest {
    @SerializedName("id")
    private String mUserId;
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

    public AddSiteRequest(String id, String name, String phone, String content, String address, String categoryId){
        this.mUserId = id;
        this.mName = name;
        this.mPhone = phone;
        this.mContent = content;
        this.mAddress = address;
        this.mCategoryId = categoryId;
    }
}
