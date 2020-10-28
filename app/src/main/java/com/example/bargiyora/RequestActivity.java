package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Request;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class RequestActivity extends AppCompatActivity implements IOnServerRequestListener {

    private RecyclerView rcRequest;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        rcRequest = findViewById(R.id.rcRequestID);
        progressBar = findViewById(R.id.progressBarID);
        String userId = DataManager.getInstance().getUser().getPhone();
        ServerRequestHandler.getRequestList(userId, RequestActivity.this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null) {
            List<Request> requestList = (List<Request>) baseResponse.getResults();
            RequestAdapter requestAdapter = new RequestAdapter(requestList);
            rcRequest.setAdapter(requestAdapter);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailure() {
// TODO: 10/27/2020 fix this
    }
}
