package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.User;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

public class LoginActivity extends AppCompatActivity implements IOnServerRequestListener {

    private EditText etPhone, etPassword;
    private View llSubmitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        llSubmitBtn = findViewById(R.id.llSubmitBtn);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);

        llSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();

                ServerRequestHandler.loginUser(phone, password, LoginActivity.this);
            }
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if(baseResponse != null) {
            User user = (User) baseResponse.getResults();
            DataManager.getInstance().setUser(user);
            startMainActivity();
        }
    }

    @Override
    public void onFailure() {
// TODO: 10/22/2020 fix this
    }
}
