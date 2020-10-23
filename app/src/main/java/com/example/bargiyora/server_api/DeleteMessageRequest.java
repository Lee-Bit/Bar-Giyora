package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class DeleteMessageRequest {

    @SerializedName("id")
    private String mUserId;

    @SerializedName("messageId")
    private String mMessageId;

    public DeleteMessageRequest(String userId, String messageId) {
        this.mUserId = userId;
        this.mMessageId = messageId;
    }

}
