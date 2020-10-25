package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class ChangePasswordRequest {
    @SerializedName("newPassword")
    private String mNewPassword;
    @SerializedName("oldPassword")
    private String mOldPassword;
    @SerializedName("id")
    private String mId;

    public ChangePasswordRequest(String newPassword, String oldPassword, String id){
        this.mId=id;
        this.mNewPassword=newPassword;
        this.mOldPassword=oldPassword;
    }
}
