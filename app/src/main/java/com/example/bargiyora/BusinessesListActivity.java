package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bargiyora.model.Business;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class BusinessesListActivity extends AppCompatActivity implements IOnServerRequestListener {

    public static final String EXTRA_KEY = "extraCode";
    private RecyclerView rcBusinessList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesses_list);

        String value = "";
        if (getIntent().getExtras() != null)
            value= getIntent().getExtras().getString(EXTRA_KEY);
        rcBusinessList= findViewById(R.id.rcBusinessListID);
        progressBar=findViewById(R.id.progressBarID);
        ServerRequestHandler.getBusinessByCategory(value, BusinessesListActivity.this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse!= null){
            List<Business> businessList =(List<Business>)baseResponse.getResults();
            BusinessesListAdapter businessesListAdapter = new BusinessesListAdapter(businessList);
            rcBusinessList.setAdapter(businessesListAdapter);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailure() {
// TODO: 10/26/2020 fix this
    }
}
