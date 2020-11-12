package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Request;
import com.example.bargiyora.model.User;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.example.bargiyora.utils.AppSettings;

import java.util.List;

public class RequestActivity extends AppCompatActivity implements IOnServerRequestListener, View.OnClickListener {

    private RecyclerView rcRequest;
    private ProgressBar progressBar;
    private Dialog dialog;
    private EditText etContent;
    private CheckBox cbSecurity, cbMaintenance, cbCulture, cbOther;
    private View llAddRequestBtn, llSubmitBtn;
    private RequestAdapter requestAdapter;
    private User user;
    private String categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        rcRequest = findViewById(R.id.rcRequestID);
        progressBar = findViewById(R.id.progressBarID);
        llAddRequestBtn = findViewById(R.id.llAddRequestBtn);
        llAddRequestBtn.setOnClickListener(this);
        user = DataManager.getInstance().getUser();
        if (user != null) {
            ServerRequestHandler.getRequestList(user.getPhone(), RequestActivity.this);
        }// TODO: 11/1/2020 add error

    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null) {
            List<Request> requestList = (List<Request>) baseResponse.getResults();
            requestAdapter = new RequestAdapter(requestList);
            rcRequest.setAdapter(requestAdapter);
            progressBar.setVisibility(View.GONE);
        }// TODO: 11/1/2020 add error
    }

    @Override
    public void onFailure() {
// TODO: 10/27/2020 fix this
    }

    private void requestOpenDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_request); // add the layout xml to dialog
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        // get the Views from the XML and use them
        cbSecurity = dialog.findViewById(R.id.cbSecurityID);
        cbSecurity.setOnClickListener(this);
        cbMaintenance = dialog.findViewById(R.id.cbMaintenanceID);
        cbMaintenance.setOnClickListener(this);
        cbCulture = dialog.findViewById(R.id.cbCultureID);
        cbCulture.setOnClickListener(this);
        cbOther = dialog.findViewById(R.id.cbOtherID);
        cbOther.setOnClickListener(this);
        etContent = dialog.findViewById(R.id.etRequestContentID);
        llSubmitBtn = dialog.findViewById(R.id.llSubmitBtn);
        llSubmitBtn.setOnClickListener(this);
        dialog.show(); // show the dialog!
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llAddRequestBtn: {
                requestOpenDialog();
                break;
            }
            case R.id.cbOtherID:
            case R.id.cbMaintenanceID:
            case R.id.cbCultureID:
            case R.id.cbSecurityID: {
                selectCategory();
                break;
            }
            case R.id.llSubmitBtn: {
                addNewRequest();
                break;
            }
        }
    }

    private void addNewRequest() {
        String content = etContent.getText().toString();
        if (content.isEmpty())
            return; // TODO: 11/1/2020 add error
        selectCategory();
        Request newRequest = new Request("", false, content, "", "",
                "", "", categoryId, user.getPhone(), user.getFirstName(), user.getLastName());
        ServerRequestHandler.addRequest(newRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    Request request = (Request) baseResponse.getResults();
                    if (requestAdapter != null && request != null) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        requestAdapter.addRequest(request);
                    }
                } // TODO: 11/1/2020 add error
            }

            @Override
            public void onFailure() {
// TODO: 11/1/2020 add error
            }
        });
    }

    private void selectCategory() {
        if (cbSecurity.isChecked()) {
            cbMaintenance.setChecked(false);
            cbCulture.setChecked(false);
            cbOther.setChecked(false);
            categoryId = AppSettings.REQUEST_CATEGORY_SECURITY;
            return;
        }
        if (cbMaintenance.isChecked()) {
            cbSecurity.setChecked(false);
            cbCulture.setChecked(false);
            cbOther.setChecked(false);
            categoryId = AppSettings.REQUEST_CATEGORY_MAINTENANCE;
            return;
        }
        if (cbCulture.isChecked()) {
            cbMaintenance.setChecked(false);
            cbSecurity.setChecked(false);
            cbOther.setChecked(false);
            categoryId = AppSettings.REQUEST_CATEGORY_CULTURE;
            return;
        }
        if (cbOther.isChecked()) {
            cbMaintenance.setChecked(false);
            cbSecurity.setChecked(false);
            cbCulture.setChecked(false);
            categoryId = AppSettings.REQUEST_CATEGORY_OTHER;
            return;
        }
    }
}
