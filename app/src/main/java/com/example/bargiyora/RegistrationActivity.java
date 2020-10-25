package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.server_api.AddUserRequest;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

public class RegistrationActivity extends AppCompatActivity implements  IOnServerRequestListener {
    private EditText etFirstName, etLastName, etPhone, etEmail, etPassword, etValidPassword;
    private CheckBox cbIsAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etFirstName=findViewById(R.id.etRegFirsNameID);
        etLastName=findViewById(R.id.etRegLastNameID);
        etPhone=findViewById(R.id.etRegPhoneID);
        etEmail=findViewById(R.id.etRegEmailID);
        etPassword=findViewById(R.id.etRegPasswordID);
        etValidPassword=findViewById(R.id.etRegValidPasswordID);
        cbIsAdmin=findViewById(R.id.cbRegIsAdminID);

        findViewById(R.id.tvRegSumbitID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName, lastName, phone, email, password, validPassword;
                Boolean isAdmin;
                firstName=etFirstName.getText().toString();
                lastName=etLastName.getText().toString();
                phone=etPhone.getText().toString();
                email=etEmail.getText().toString();
                password=etPassword.getText().toString();
                validPassword=etValidPassword.getText().toString();
                isAdmin=cbIsAdmin.isChecked();
                if(!password.equals(validPassword))
                    return; //TODO: add error
                AddUserRequest addUserRequest = new AddUserRequest(email,firstName,lastName,phone,isAdmin, DataManager.getInstance().getUser().getPhone());
                ServerRequestHandler.addUser(addUserRequest, RegistrationActivity.this);
            }
        });
    }


    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        //TODO add
    }

    @Override
    public void onFailure() {

    }
}
