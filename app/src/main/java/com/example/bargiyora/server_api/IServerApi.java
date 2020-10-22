package com.example.bargiyora.server_api;

import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface IServerApi {

    @GET("messages/getList")
    Call<BaseResponse<List<Messages>>> getMessageList();

    // users/login?phone={PHONE}&password={PASSWORD}
    @GET("users/login")
    Call<BaseResponse<User>> loginUser(@Query("phone") String phone, @Query("password") String password);

}
