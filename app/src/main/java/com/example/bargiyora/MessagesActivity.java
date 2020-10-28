package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.model.User;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class MessagesActivity extends AppCompatActivity implements IOnServerRequestListener {

    private RecyclerView rcMessages;
    private ProgressBar progressBar;
    private Dialog dialog;
    private EditText etMessageTitle, etMessageContent;
    private View llAddMessageBtn, llSubmitBtn;
    private MessagesAdapter messagesAdapter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        user = DataManager.getInstance().getUser();
        if (user == null)
            return;// TODO: 10/28/2020 add error
        rcMessages = findViewById(R.id.rcMessagesID);
        progressBar = findViewById(R.id.progressBarID);
        llAddMessageBtn = findViewById(R.id.llAddMessageBtn);
        if (!user.isAdmin())
            llAddMessageBtn.setVisibility(View.GONE);
        llAddMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageOpenDialog();
            }
        });
        ServerRequestHandler.getMessageList(this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null) {
            List<Messages> messagesList = (List<Messages>) baseResponse.getResults();
            messagesAdapter = new MessagesAdapter(messagesList);
            rcMessages.setAdapter(messagesAdapter);
            progressBar.setVisibility(View.GONE);
        } else return;// TODO: 10/28/2020
    }

    @Override
    public void onFailure() {
        // TODO: 10/22/2020 fix this
    }

    private void messageOpenDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_message); // add the layout xml to dialog
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        // get the Views from the XML and use them
        etMessageTitle = dialog.findViewById(R.id.etMessageTitleID);
        etMessageContent = dialog.findViewById(R.id.etMessageContentID);
        llSubmitBtn = dialog.findViewById(R.id.llSubmitBtn);
        llSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewMessage();
            }
        });
        dialog.show(); // show the dialog!
    }

    private void addNewMessage() {
        String title = etMessageTitle.getText().toString();
        if (title.isEmpty())
            return;// TODO: 10/28/2020 add error
        String content = etMessageContent.getText().toString();
        if (content.isEmpty())
            return;// TODO: 10/28/2020 add error
        Messages newMessage = new Messages("", title, content, "", "", user.getPhone(), user.getFirstName(), user.getLastName());
        ServerRequestHandler.addMessage(newMessage, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    Messages messages = (Messages) baseResponse.getResults();
                    if (messagesAdapter != null && messages != null) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        messagesAdapter.addMessage(messages);
                    }
                }// TODO: 10/28/2020 add error
            }

            @Override
            public void onFailure() {
                // TODO: 10/28/2020 add error
            }
        });
    }
}
