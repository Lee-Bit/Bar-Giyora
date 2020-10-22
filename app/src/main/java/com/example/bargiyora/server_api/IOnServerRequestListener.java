package com.example.bargiyora.server_api;

public interface IOnServerRequestListener {
    <T> void onSuccess(BaseResponse<T> baseResponse);

    void onFailure();
}
