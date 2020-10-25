package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class DeleteBusinessRequest {
    @SerializedName("id")
    private String mUserId;
    @SerializedName("businessId")
    private String mBusinessId;

    public DeleteBusinessRequest(String userId, String businessId){
        this.mUserId=userId;
        this.mBusinessId=businessId;
    }
}
