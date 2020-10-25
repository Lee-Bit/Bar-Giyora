package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class DeleteSiteRequest {
    @SerializedName("id")
    private String mUserId;
    @SerializedName("siteId")
    private String mSiteId;

    public DeleteSiteRequest(String userId, String siteId){
        this.mUserId=userId;
        this.mSiteId=siteId;
    }
}
