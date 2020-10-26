package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class UpdateStatusRequest {
    @SerializedName("id")
    private String mRequestId;
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("status")
    private boolean mStatus;

    public UpdateStatusRequest(String id, String userId, boolean status){
        this.mRequestId=id;
        this.mUserId=userId;
        this.mStatus=status;
    }
}
