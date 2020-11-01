package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.User;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.ChangePasswordRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

public class ChangePasswordActivity extends AppCompatActivity implements IOnServerRequestListener {

    private User user;
    private EditText etOldPassword, etNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        user = DataManager.getInstance().getUser();
        if (user == null)
            return;// TODO: 10/26/2020 add error 

        etOldPassword = findViewById(R.id.etOldPasswordID);
        etNewPassword = findViewById(R.id.etNewPasswordID);
        findViewById(R.id.llSubmitBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }

    private void changePassword() {
        String oldPassword, newPassword;
        ChangePasswordRequest changePasswordRequest;
        oldPassword = etOldPassword.getText().toString();
        newPassword = etNewPassword.getText().toString();
        if (oldPassword.isEmpty() || newPassword.isEmpty())
            return; // TODO: 10/26/2020 add error 
        changePasswordRequest = new ChangePasswordRequest(newPassword, oldPassword, user.getPhone());
        ServerRequestHandler.changePassword(changePasswordRequest, ChangePasswordActivity.this);
    }


    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null)
            if ((Integer) baseResponse.getResults() > 0)
                finish();
        return; // TODO: 10/26/2020 add error 
    }

    @Override
    public void onFailure() {
        // TODO: 10/26/2020 fix this 
    }
}
