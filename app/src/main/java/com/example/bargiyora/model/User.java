package com.example.bargiyora.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("email")
    private String mEmail;
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("lastName")
    private String mLastName;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("isAdmin")
    private boolean mIsAdmin;
    @SerializedName("password")
    private String mPassword;

    public User(String email, String firsName, String lastName, String phone, boolean isAdmin, String password){
        this.mEmail=email;
        this.mFirstName=firsName;
        this.mLastName=lastName;
        this.mPhone=phone;
        this.mIsAdmin=isAdmin;
        this.mPassword=password;
    }
    public String getEmail() {return mEmail;}
    public String getFirstName() {return mFirstName;}
    public String getLastName() {return mLastName;}
    public String getPhone() {return mPhone;}
    public boolean isAdmin() {return mIsAdmin;}
    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}

