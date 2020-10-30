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
import android.widget.TextView;

import com.example.bargiyora.model.Business;
import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.server_api.AddBusinessRequest;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class BusinessesListActivity extends AppCompatActivity implements IOnServerRequestListener {

    public static final String EXTRA_KEY = "extraCode";
    private RecyclerView rcBusinessList;
    private ProgressBar progressBar;
    private Dialog dialog;
    private View llAddBusinessBtn, llSubmitBtn;
    private EditText etBusinessName, etBusinessPhone, etBusinessAddress, etBusineesDetails;
    private BusinessesListAdapter businessesListAdapter;
    private String categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesses_list);

        categoryId = "";
        if (getIntent().getExtras() != null)
            categoryId = getIntent().getExtras().getString(EXTRA_KEY);
        rcBusinessList = findViewById(R.id.rcBusinessListID);
        progressBar = findViewById(R.id.progressBarID);
        llAddBusinessBtn = findViewById(R.id.llAddBusinessBtn);
        if (!DataManager.getInstance().getUser().isAdmin())
            llAddBusinessBtn.setVisibility(View.GONE);

        llAddBusinessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessOpenDialog();
            }
        });
        ServerRequestHandler.getBusinessByCategory(categoryId, BusinessesListActivity.this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null) {
            List<Business> businessList = (List<Business>) baseResponse.getResults();
            businessesListAdapter = new BusinessesListAdapter(businessList);
            rcBusinessList.setAdapter(businessesListAdapter);
            progressBar.setVisibility(View.GONE);
        }// TODO: 10/29/2020 add error 
    }

    @Override
    public void onFailure() {
// TODO: 10/26/2020 fix this
    }

    private void businessOpenDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_business); // add the layout xml to dialog
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        // get the Views from the XML and use them
        etBusinessName = dialog.findViewById(R.id.etBusinessNameID);
        etBusinessPhone = dialog.findViewById(R.id.etBusinessPhoneID);
        etBusinessAddress = dialog.findViewById(R.id.etBusinessAddressID);
        etBusineesDetails = dialog.findViewById(R.id.etBusinessDetailsID);
        llSubmitBtn = dialog.findViewById(R.id.llSubmitBtn);
        llSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewBusiness();
            }
        });
        dialog.show(); // show the dialog!
    }

    private void addNewBusiness() {
        String userId = DataManager.getInstance().getUser().getPhone();
        String name = etBusinessName.getText().toString();
        String phone = etBusinessPhone.getText().toString();
        String address = etBusinessAddress.getText().toString();
        String details = etBusineesDetails.getText().toString();
        AddBusinessRequest addBusinessRequest = new AddBusinessRequest(userId, name, phone, details, address, categoryId);
        ServerRequestHandler.addBusiness(addBusinessRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    Business business = (Business) baseResponse.getResults();
                    if (businessesListAdapter != null && business != null) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        businessesListAdapter.addBusiness(business);
                    }
                }// TODO: 10/29/2020  
            }

            @Override
            public void onFailure() {
// TODO: 10/29/2020  
            }
        });
    }
}
