package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SiteListActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "extraCode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_list);

        String value = "";
        if (getIntent().getExtras() != null) {
            value = getIntent().getExtras().getString(EXTRA_KEY);
        }
    }
}
