package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class MessagesActivity extends AppCompatActivity implements IOnServerRequestListener{

    private RecyclerView rcMessages;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        rcMessages = findViewById(R.id.rcMessagesID);
        progressBar = findViewById(R.id.progressBarID);


        ServerRequestHandler.getMessageList(this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if(baseResponse != null) {
            List<Messages> messagesList = (List<Messages>) baseResponse.getResults();

            MessagesAdapter adapter = new MessagesAdapter(messagesList);
            rcMessages.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailure() {
        // TODO: 10/22/2020 fix this
    }
}
