package com.example.bargiyora.model;

import com.google.gson.annotations.SerializedName;

public class Business {
    //don't forget to add category if it necessary
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("details")
    private String mContent;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("address")
    private String mAddress;

    public Business(String id, String name, String content, String phone, String address){
        this.mId=id;
        this.mName=name;
        this.mPhone=phone;
        this.mContent=content;
        this.mAddress=address;
    }

    public String getID(){return mId;}
    public String getName(){return mName;}
    public String getPhone(){return mPhone;}
    public String getContent(){return mContent;}
    public String getAddress(){return mAddress;}

}
