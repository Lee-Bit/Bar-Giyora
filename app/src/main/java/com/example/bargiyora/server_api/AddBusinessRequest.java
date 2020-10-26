package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class AddBusinessRequest {
    @SerializedName("id")
    private String mUserId;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("details")
    private String mDetails;
    @SerializedName("address")
    private String mAddress;
    @SerializedName("categoryId")
    private String mCategoryId;

    public AddBusinessRequest(String id, String name, String phone, String details, String address, String categoryId){
        this.mUserId=id;
        this.mName=name;
        this.mPhone=phone;
        this.mDetails=details;
        this.mAddress=address;
        this.mCategoryId=categoryId;
    }
}
