package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bargiyora.model.Site;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class SiteListActivity extends AppCompatActivity implements IOnServerRequestListener {

    public static final String EXTRA_KEY = "extraCode";
    private RecyclerView rcSiteList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_list);

        String value = "";
        if (getIntent().getExtras() != null) {
            value = getIntent().getExtras().getString(EXTRA_KEY);
        }
        rcSiteList= findViewById(R.id.rcSiteListID);
        progressBar=findViewById(R.id.progressBarID);

        ServerRequestHandler.getSitesByCategoryId(value, SiteListActivity.this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if(baseResponse != null){
            List<Site> siteList = (List<Site>)baseResponse.getResults();
            SiteListAdapter adapter = new SiteListAdapter(siteList);
            rcSiteList.setAdapter(adapter);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailure() {
        //TODO
    }
}
