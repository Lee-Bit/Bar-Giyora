package com.example.bargiyora.server_api;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("error")
    private String mError;

    @SerializedName("results")
    private T mResults;

    public String getError() {
        return mError;
    }

    public T getResults() {
        return mResults;
    }
}
