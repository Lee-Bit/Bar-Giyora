package com.example.bargiyora.server_api;

import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServerRequestHandler {

    public static void loginUser(String phone, String password, IOnServerRequestListener iOnServerRequestListener) {
        Call<BaseResponse<User>> call = ClientApi.getServerApi().loginUser(phone, password);
        call.enqueue(new Callback<BaseResponse<User>>() {
            @Override
            public void onResponse(Call<BaseResponse<User>> call, Response<BaseResponse<User>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<User>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }



    public static void getMessageList(final IOnServerRequestListener iOnServerRequestListener) {
        ClientApi.getServerApi().getMessageList().enqueue(new Callback<BaseResponse<List<Messages>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Messages>>> call, Response<BaseResponse<List<Messages>>> response) {
                if (iOnServerRequestListener != null) {
                    if (response.isSuccessful() && response.body() != null) {
                        BaseResponse baseResponse = response.body();
                        iOnServerRequestListener.onSuccess(baseResponse);
                    } else {
                        iOnServerRequestListener.onFailure();
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Messages>>> call, Throwable t) {
                if (iOnServerRequestListener != null) {
                    iOnServerRequestListener.onFailure();
                }
            }
        });
    }
}
