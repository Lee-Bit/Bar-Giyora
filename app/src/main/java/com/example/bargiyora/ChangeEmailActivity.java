package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.User;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.ChangeEmailRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

public class ChangeEmailActivity extends AppCompatActivity implements IOnServerRequestListener {

    private User user;
    private EditText etNewEmail, etOldEmail, etPassword;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        user = DataManager.getInstance().getUser();
        if (user == null)
            // TODO: 10/26/2020 add error
            return;
        etOldEmail = findViewById(R.id.etOldEmailID);
        etNewEmail = findViewById(R.id.etNewEmailID);
        etPassword = findViewById(R.id.etValidPasswordID);

        findViewById(R.id.tvChangeEmailSubmitID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEmail();
            }
        });

    }

    private void changeEmail(){
        String oldEmail, newEmail, validPassword;
        ChangeEmailRequest changeEmailRequest;
        oldEmail=etOldEmail.getText().toString();
        newEmail=etNewEmail.getText().toString();
        validPassword=etPassword.getText().toString();
        if(!oldEmail.equals(user.getEmail()))
            return;//TODO add error
        if (newEmail.isEmpty())
            return; // TODO: 10/26/2020 add error 
        changeEmailRequest = new ChangeEmailRequest(user.getPhone(),validPassword, newEmail, oldEmail);
        ServerRequestHandler.changeEmail(changeEmailRequest, ChangeEmailActivity.this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse == null)
            return; // TODO: 10/26/2020 add error 
        if ((Integer) baseResponse.getResults()== 0)
            return; // TODO: 10/26/2020 add error 
        String newEmail = etNewEmail.getText().toString();
        DataManager.getInstance().getUser().setEmail(newEmail);
        finish();
    }

    @Override
    public void onFailure() {
// TODO: 10/26/2020 fix this
    }
}
