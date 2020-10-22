package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bargiyora.utils.AppSettings;


public class AroundUsCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    // private ImageView ivRestaurant, ivPool, ivTrip, ivOther;
    // private TextView tvRestaurant, tvPool, tvTrip, tvOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_around_us_category);

        findViewById(R.id.ivRestaurantIconID).setOnClickListener(this);
        findViewById(R.id.ivPoolsIconID).setOnClickListener(this);
        findViewById(R.id.ivTripsIconID).setOnClickListener(this);
        findViewById(R.id.ivOtherIconID).setOnClickListener(this);

        /*
        tvRestaurant = findViewById(R.id.tvRestaurantID);
        tvPool = findViewById(R.id.tvPoolsID);
        tvTrip = findViewById(R.id.tvTripsID);
        tvOther = findViewById(R.id.tvOtherID);

        ivRestaurant = findViewById(R.id.ivRestaurantIconID);
        ivRestaurant.setOnClickListener(this);
        ivPool = findViewById(R.id.ivPoolsIconID);
        ivPool.setOnClickListener(this);
        ivTrip = findViewById(R.id.ivTripsIconID);
        ivTrip.setOnClickListener(this);
        ivOther = findViewById(R.id.ivOtherIconID);
        ivOther.setOnClickListener(this);
        */


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivRestaurantIconID:
                startActivity(AppSettings.AROUND_US_CATEGORY_RESTAURANTS);
                break;

            case R.id.ivPoolsIconID:
                startActivity(AppSettings.AROUND_US_CATEGORY_POOLS);
                break;

            case R.id.ivTripsIconID:
                startActivity(AppSettings.AROUND_US_CATEGORY_TRIPS);
                break;

            case R.id.ivOtherIconID:
                startActivity(AppSettings.AROUND_US_CATEGORY_OTHERS);
                break;
        }

    }

    private void startActivity(String value) {
        Intent intent = new Intent(this, SiteListActivity.class);
        intent.putExtra(SiteListActivity.EXTRA_KEY, value);
        startActivity(intent);
    }
}
