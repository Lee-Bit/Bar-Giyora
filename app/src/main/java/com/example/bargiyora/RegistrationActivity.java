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

public class RegistrationActivity extends AppCompatActivity implements IOnServerRequestListener {
    private EditText etFirstName, etLastName, etPhone, etEmail, etPassword, etValidPassword;
    private CheckBox cbIsAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etFirstName = findViewById(R.id.etRegFirsNameID);
        etLastName = findViewById(R.id.etRegLastNameID);
        etPhone = findViewById(R.id.etRegPhoneID);
        etEmail = findViewById(R.id.etRegEmailID);
        etPassword = findViewById(R.id.etRegPasswordID);
        etValidPassword = findViewById(R.id.etRegValidPasswordID);
        cbIsAdmin = findViewById(R.id.cbRegIsAdminID);

        findViewById(R.id.tvRegSubmitID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    private void addUser() {
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String validPassword = etValidPassword.getText().toString();
        boolean isAdmin = cbIsAdmin.isChecked();
        if (!password.equals(validPassword))
            return; //TODO: add error
        AddUserRequest addUserRequest = new AddUserRequest(email, firstName, lastName, phone, isAdmin,password,DataManager.getInstance().getUser().getPhone());
        ServerRequestHandler.addUser(addUserRequest, RegistrationActivity.this);
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
        // TODO: 10/26/2020 add error☻
    }
}
