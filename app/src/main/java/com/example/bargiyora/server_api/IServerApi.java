package com.example.bargiyora.server_api;

import com.example.bargiyora.model.Business;
import com.example.bargiyora.model.BusinessCategory;
import com.example.bargiyora.model.DeliveryAndSale;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.Request;
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

//users requests
    @GET("users/login")
    Call<BaseResponse<User>> loginUser(@Query("phone") String phone, @Query("password") String password);

    @POST("users/add")
    Call<BaseResponse<Integer>> addUser(@Body AddUserRequest addUserRequest);

    @POST("users/changePassword")
    Call<BaseResponse<Integer>>  changePassword(@Body ChangePasswordRequest changePasswordRequest);

    @POST("users/changeEmail")
    Call<BaseResponse<Integer>> changeEmail(@Body ChangeEmailRequest changeEmailRequest);


//messages requests
    @GET("messages/getList")
    Call<BaseResponse<List<Messages>>> getMessageList();

    @POST("messages/delete")
    Call<BaseResponse<Integer>> deleteMessage(@Body DeleteMessageRequest deleteMessageRequest);

    @POST("messages/add")
    Call<BaseResponse<Messages>> addMessage(@Body Messages message);


//sites requests
    @GET("sites/getSitesByCategoryId")
    Call<BaseResponse<List<Site>>> getSitesByCategoryId(@Query("categoryId") String categoryId);

    @POST("sites/delete")
    Call<BaseResponse<Integer>> deleteSite(@Body DeleteSiteRequest deleteSiteRequest);

    @POST("sites/add")
    Call<BaseResponse<Site>> addSite(@Body AddSiteRequest addSiteRequest);


    //business requests
    //TODO delete businessCategory?
    @GET("business/getBusinessCategoryList")
    Call<BaseResponse<List<BusinessCategory>>> getBusinessCategoryList();

    @GET("business/getAllBusinessByCategory")
    Call<BaseResponse<List<Business>>> getBusinessByCategory(@Query("categoryId") String categoryId);

    @POST("business/delete")
    Call<BaseResponse<Integer>> deleteBusiness(@Body DeleteBusinessRequest deleteBusinessRequest);

    @POST("business/add")
    Call<BaseResponse<Business>> addBusiness(@Body AddBusinessRequest addBusinessRequest);



    //item requests
    @GET("item/getList")
    Call<BaseResponse<List<DeliveryAndSale>>> getItemList();

    @POST("item/add")
    Call<BaseResponse<DeliveryAndSale>> addItem(@Body DeliveryAndSale deliveryAndSale);

    @POST("item/delete")
    Call<BaseResponse<Integer>> deleteItem(@Body DeleteDeliveryAndSaleRequest deleteDeliveryAndSaleRequest);

//    @POST("item/update")
//    Call<BaseResponse<DeliveryAndSale>> updateItem(@Body DeliveryAndSale deliveryAndSale);


    //Request requests
    @GET("requests/getList")
    Call<BaseResponse<List<Request>>> getRequestList(@Query("userId") String userId);

    @POST("requests/updateStatus")
    Call<BaseResponse<Request>> updateStatus(@Body UpdateStatusRequest updateStatusRequest);

    @POST("requests/add")
    Call<BaseResponse<Request>> addRequest(@Body Request request);
}
