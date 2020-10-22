package com.example.bargiyora.server_api;

import com.example.bargiyora.utils.AppSettings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ClientApi {
    private static final int REQUEST_CONNECT_TIMEOUT_KEY = 60;
    private static final int REQUEST_READ_TIMEOUT_KEY = 55;
    private static final int REQUEST_WRITE_TIMEOUT_KEY = 55;

    private static OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_CONNECT_TIMEOUT_KEY, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .readTimeout(REQUEST_READ_TIMEOUT_KEY, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_WRITE_TIMEOUT_KEY, TimeUnit.SECONDS)
            .build();


    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(AppSettings.API_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build();

    private static IServerApi mServerApi = retrofit.create(IServerApi.class);

    public static IServerApi getServerApi() {
        return mServerApi;
    }
}
