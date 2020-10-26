package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.User;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.ChangeEmailRequest;
import com.example.bargiyora.server_api.ChangePasswordRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
//    private LinearLayout llChangeEmail, llChangePassword;
//    private TextView tvAddNewUser;
//    private EditText etOldEmail, etNewEmail, etValidPassword, etOldPassword, etNewPassword;
    private User user;
    private TextView tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        user = DataManager.getInstance().getUser();
        if (user == null)
            // TODO: 10/26/2020 add error
            return;

        TextView tvFirstName = findViewById(R.id.tvFirstNameID);
        tvFirstName.setText(user.getFirstName());
        TextView tvLastName = findViewById(R.id.tvLastNameID);
        tvLastName.setText(user.getLastName());
        TextView tvPhone = findViewById(R.id.tvPhoneID);
        tvPhone.setText(user.getPhone());
        tvEmail = findViewById(R.id.tvEmailID);
        tvEmail.setText(user.getEmail());
        ImageView ivEditEmail = findViewById(R.id.ivEditID);
        ivEditEmail.setOnClickListener(this);
        TextView tvAddNewUser=findViewById(R.id.tvAddNewUserID);
        tvAddNewUser.setOnClickListener(this);
        if(user.isAdmin())
            tvAddNewUser.setVisibility(View.VISIBLE);
        else tvAddNewUser.setVisibility(View.GONE);

//        findViewById(R.id.tvChangeEmailID).setOnClickListener(this);
        findViewById(R.id.tvChangePasswordID).setOnClickListener(this);
//        findViewById(R.id.tvChangeEmailSubmitID).setOnClickListener(this);
//        findViewById(R.id.tvChangePasswordSubmitID).setOnClickListener(this);

//        llChangeEmail=findViewById(R.id.llChangEmailID);
//        llChangeEmail.setOnClickListener(this);
//        llChangePassword=findViewById(R.id.llChangePasswordID);
//        llChangePassword.setOnClickListener(this);

//        etNewEmail=findViewById(R.id.etNewEmailID);
//        etOldEmail=findViewById(R.id.etOldEmailID);
//        etValidPassword=findViewById(R.id.etValidPasswordID);
//        etOldPassword=findViewById(R.id.etOldPasswordID);
//        etNewPassword=findViewById(R.id.etNewPasswordID);

    }

    @Override
    protected void onResume() {
        super.onResume();
        tvEmail.setText(user.getEmail());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAddNewUserID: {
                startRegistrationActivity();
                break;
            }
//            case R.id.tvChangeEmailID:{
//                if(llChangeEmail.getVisibility() == View.GONE)
//                    llChangeEmail.setVisibility(View.VISIBLE);
//                else
//                    llChangeEmail.setVisibility(View.GONE);
//                break;
//            }
            case R.id.tvChangePasswordID:
                startChangePasswordActivity();
//                if(llChangePassword.getVisibility() == View.GONE)
//                    llChangePassword.setVisibility(View.VISIBLE);
//                else
//                    llChangePassword.setVisibility(View.GONE);
                break;
            case R.id.ivEditID:
                startChangeEmailActivity();
                break;
//            case R.id.tvChangeEmailSubmitID:
//                changeEmail();
//                break;
//            case R.id.tvChangePasswordSubmitID:
//                changePassword();
//                break;
        }
    }

//    private void changeEmail(){
//        String oldEmail, newEmail, validPassword;
//
//        User user =DataManager.getInstance().getUser();
//        ChangeEmailRequest changeEmailRequest;
//        if(user == null)
//            return;//TODO add error
//        oldEmail=etOldEmail.getText().toString();
//        newEmail=etNewEmail.getText().toString();
//        validPassword=etValidPassword.getText().toString();
//        if(!oldEmail.equals(user.getEmail()))
//            return;//TODO add error
//        changeEmailRequest = new ChangeEmailRequest(user.getPhone(),validPassword, newEmail, oldEmail);
//        ServerRequestHandler.changeEmail(changeEmailRequest, new IOnServerRequestListener() {
//            @Override
//            public <T> void onSuccess(BaseResponse<T> baseResponse) {
//                // TODO: 10/26/2020
//            }
//
//            @Override
//            public void onFailure() {
//                // TODO: 10/26/2020
//            }
//        });
//    }
//
//    private void changePassword(){
//        String oldPassword, newPassword;
//        User user=DataManager.getInstance().getUser();
//        ChangePasswordRequest changePasswordRequest;
//        if(user==null)
//            return;//TODO add error
//        oldPassword=etOldPassword.getText().toString();
//        newPassword=etNewPassword.getText().toString();
//        changePasswordRequest= new ChangePasswordRequest(newPassword,oldPassword,user.getPhone());
//        ServerRequestHandler.changePassword(changePasswordRequest, new IOnServerRequestListener() {
//            @Override
//            public <T> void onSuccess(BaseResponse<T> baseResponse) {
//                // TODO: 10/26/2020
//            }
//
//            @Override
//            public void onFailure() {
//                // TODO: 10/26/2020
//            }
//        });
//    }

    private void startRegistrationActivity(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private void startChangePasswordActivity(){
        Intent intent = new Intent(this, ChangePasswordActivity.class);
        startActivity(intent);
    }

    private void startChangeEmailActivity(){
        Intent intent = new Intent(this, ChangeEmailActivity.class);
        startActivity(intent);
    }

}
