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

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Site;
import com.example.bargiyora.server_api.AddSiteRequest;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.example.bargiyora.utils.AppSettings;

import java.util.List;

public class SiteListActivity extends AppCompatActivity implements IOnServerRequestListener {

    public static final String EXTRA_KEY = "extraCode";
    private RecyclerView rcSiteList;
    private ProgressBar progressBar;
    private Dialog dialog;
    private TextView tvSiteTitle, tvDialogSiteTitle;
    private View llAddSiteBtn, llSubmitBtn;
    private EditText etSiteName, etSitePhone, etSiteAddress, etSiteDetails;
    private SiteListAdapter siteListAdapter;
    private int title;
    private String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_list);
        value = "";
        if (getIntent().getExtras() != null) {
            value = getIntent().getExtras().getString(EXTRA_KEY);
        }
        rcSiteList = findViewById(R.id.rcSiteListID);
        progressBar = findViewById(R.id.progressBarID);
        llAddSiteBtn = findViewById(R.id.llAddSiteBtn);
        if (!DataManager.getInstance().getUser().isAdmin())
            llAddSiteBtn.setVisibility(View.GONE);
        title = getSiteTitle();
        tvSiteTitle = findViewById(R.id.tvSiteTitleID);
        if (title != 0)
            tvSiteTitle.setText(title);
        llAddSiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siteOpenDialog();
            }
        });
        ServerRequestHandler.getSitesByCategoryId(value, SiteListActivity.this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null) {
            List<Site> siteList = (List<Site>) baseResponse.getResults();
            siteListAdapter = new SiteListAdapter(siteList);
            rcSiteList.setAdapter(siteListAdapter);
            progressBar.setVisibility(View.GONE);
        }// TODO: 10/28/2020 add error 
    }

    @Override
    public void onFailure() {
        //TODO
    }

    private int getSiteTitle() {
        switch (value) {
            case AppSettings.AROUND_US_CATEGORY_RESTAURANTS:
                return R.string.add_restaurant_title;
            case AppSettings.AROUND_US_CATEGORY_POOLS:
                return R.string.add_pool_title;
            case AppSettings.AROUND_US_CATEGORY_TRIPS:
                return R.string.add_trip_title;
            case AppSettings.AROUND_US_CATEGORY_OTHERS:
                return R.string.add_various_title;
        }
        return 0;
    }

    private void siteOpenDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_site); // add the layout xml to dialog
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        // get the Views from the XML and use them
        tvDialogSiteTitle = dialog.findViewById(R.id.tvDialogSiteTitleID);
        if (title != 0)
            tvDialogSiteTitle.setText(title);
        etSiteName = dialog.findViewById(R.id.etSiteNameID);
        etSitePhone = dialog.findViewById(R.id.etSitePhoneID);
        etSiteAddress = dialog.findViewById(R.id.etSiteAddressID);
        etSiteDetails = dialog.findViewById(R.id.etSiteDetailsID);
        llSubmitBtn = dialog.findViewById(R.id.llSubmitBtn);
        llSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewSite();
            }
        });
        dialog.show(); // show the dialog!
    }

    private void addNewSite() {
        String userId = DataManager.getInstance().getUser().getPhone();
        String name = etSiteName.getText().toString();
        String phone = etSitePhone.getText().toString();
        String address = etSiteAddress.getText().toString();
        String details = etSiteDetails.getText().toString();
        AddSiteRequest addSiteRequest = new AddSiteRequest(userId, name, phone, details, address, value);
        ServerRequestHandler.addSite(addSiteRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    Site site = (Site) baseResponse.getResults();
                    if (siteListAdapter != null && site != null) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        siteListAdapter.addSite(site);
                    }
                }// TODO: 10/28/2020 add error 
            }

            @Override
            public void onFailure() {
// TODO: 10/28/2020 fix this
            }
        });
    }
}
