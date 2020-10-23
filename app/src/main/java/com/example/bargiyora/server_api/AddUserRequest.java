package com.example.bargiyora.server_api;

import com.example.bargiyora.model.User;
import com.google.gson.annotations.SerializedName;

public class AddUserRequest extends User {
    @SerializedName("id")
    private String adminId;

    public AddUserRequest(String email, String firsName, String lastName, String phone, boolean isAdmin, String adminId) {
        super(email, firsName, lastName, phone, isAdmin);
        this.adminId = adminId;
    }
}
