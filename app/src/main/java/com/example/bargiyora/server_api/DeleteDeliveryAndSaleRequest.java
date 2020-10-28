package com.example.bargiyora.server_api;

import com.example.bargiyora.model.DeliveryAndSale;
import com.google.gson.annotations.SerializedName;

public class DeleteDeliveryAndSaleRequest {
    @SerializedName("userId")
    private String mUserId;
    @SerializedName("itemId")
    private String mItemId;

    public DeleteDeliveryAndSaleRequest(String userId, String itemId) {
        this.mItemId = itemId;
        this.mUserId = userId;
    }
}

