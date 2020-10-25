package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class ChangeEmailRequest {
    @SerializedName("id")
    private String mId;
    @SerializedName("password")
    private String mPassword;
    @SerializedName("newEmail")
    private String mNewEmail;
    @SerializedName("oldEmail")
    private String mOldEmail;

    public ChangeEmailRequest(String id, String password, String newEmail, String oldEmail){
        this.mId=id;
        this.mPassword=password;
        this.mNewEmail=newEmail;
        this.mOldEmail=oldEmail;
    }
}
