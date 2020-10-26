package com.example.bargiyora.server_api;

import com.example.bargiyora.model.DeliveryAndSale;
import com.google.gson.annotations.SerializedName;

public class DeleteDeliveryAndSaleRequest extends DeliveryAndSale {
    @SerializedName("userId")
    private String mUserId;

    public DeleteDeliveryAndSaleRequest(String id, boolean type, String price, String date, String name,
                                        String details, String firstName, String lastName, String phone, String userId){
        super(id, type, price, date, name, details, firstName, lastName, phone);
        this.mUserId=userId;
    }
}

