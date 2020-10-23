package com.example.bargiyora.server_api;

import com.example.bargiyora.model.BusinessCategory;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.Site;
import com.example.bargiyora.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IServerApi {

    // users/login?phone={PHONE}&password={PASSWORD}
    @GET("users/login")
    Call<BaseResponse<User>> loginUser(@Query("phone") String phone, @Query("password") String password);

    @POST("users/add")
    Call<BaseResponse<Integer>> addUser(@Body AddUserRequest addUserRequest);

    @POST("users/changePassword")
    Call<BaseResponse<Integer>>  changePassword(@Body String newPassword, String oldPassword, String id);

    @POST("users/changeEmail")
    Call<BaseResponse<Integer>> changeEmail(@Body String id, String password, String newEmail, String oldEmail);



    @GET("messages/getList")
    Call<BaseResponse<List<Messages>>> getMessageList();

    @DELETE("messages/delete")
    Call<BaseResponse<Integer>> deleteMessage(@Body DeleteMessageRequest deleteMessageRequest);

    @POST("messages/add")
    Call<BaseResponse<Messages>> addMessage(@Body Messages message);


//TODO add sites?
    @GET("sites/getSitesByCategoryId")
    Call<BaseResponse<List<Site>>> getSitesByCategoryId(@Query("categoryId") String categoryId);


    @GET("business/getBusinessCategoryList")
    Call<BaseResponse<List<BusinessCategory>>> getBusinessCategoryList();
}
