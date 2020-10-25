package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;

public class RequestActivity extends AppCompatActivity implements IOnServerRequestListener {

    private RecyclerView rcRequest;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        rcRequest= findViewById(R.id.rcRequestID);
        progressBar=findViewById(R.id.progressBarID);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {

    }

    @Override
    public void onFailure() {

    }
}
