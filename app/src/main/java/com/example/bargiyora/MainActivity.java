package com.example.bargiyora;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
    private ImageView ivRequest, ivMessage, ivSettings, ivSaleAndDeliveryBord,
            ivFindRide, ivResidentService, ivLocalBusiness, ivGallery, ivAroundUs;
    private TextView tvRequest, tvMessage, tvSettings, tvSaleAndDeliveryBord,
            tvFindRide, tvResidentService, tvLocalBusiness, tvGallery, tvAroundUs;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        tvRequest = findViewById(R.id.tvRequestID);
        tvMessage = findViewById(R.id.tvMessagesID);
        tvSettings = findViewById(R.id.tvSettingsID);
        tvSaleAndDeliveryBord = findViewById(R.id.tvDeliveryAndSaleID);
        tvFindRide = findViewById(R.id.tvRideID);
        tvResidentService = findViewById(R.id.tvResidentServiceID);
        tvLocalBusiness = findViewById(R.id.tvBusinessesID);
        tvGallery = findViewById(R.id.tvGalleryID);
        tvAroundUs = findViewById(R.id.tvAroundUsID);

        ivRequest = findViewById(R.id.ivRequestIconID);
        ivRequest.setOnClickListener(this);
        ivMessage = findViewById(R.id.ivMessagesIconID);
        ivMessage.setOnClickListener(this);
        ivSettings = findViewById(R.id.ivSettingsIconID);
        ivSettings.setOnClickListener(this);
        ivSaleAndDeliveryBord = findViewById(R.id.ivDeliveryAndSaleIconID);
        ivSaleAndDeliveryBord.setOnClickListener(this);
        ivFindRide = findViewById(R.id.ivRideIconID);
        ivFindRide.setOnClickListener(this);
        ivResidentService = findViewById(R.id.ivResidentServiceIconID);
        ivResidentService.setOnClickListener(this);
        ivLocalBusiness = findViewById(R.id.ivBusinessesIconID);
        ivLocalBusiness.setOnClickListener(this);
        ivGallery = findViewById(R.id.ivGalleryIconID);
        ivGallery.setOnClickListener(this);
        ivAroundUs = findViewById(R.id.ivAroundUsIconID);
        ivAroundUs.setOnClickListener(this);
         */

        findViewById(R.id.ivRequestIconID).setOnClickListener(this);
        findViewById(R.id.ivMessagesIconID).setOnClickListener(this);
        findViewById(R.id.ivSettingsIconID).setOnClickListener(this);
        findViewById(R.id.ivDeliveryAndSaleIconID).setOnClickListener(this);
        findViewById(R.id.ivRideIconID).setOnClickListener(this);
        findViewById(R.id.ivResidentServiceIconID).setOnClickListener(this);
        findViewById(R.id.ivBusinessesIconID).setOnClickListener(this);
        findViewById(R.id.ivGalleryIconID).setOnClickListener(this);
        findViewById(R.id.ivAroundUsIconID).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivRequestIconID:
                startRequestActivity();
                break;
            case R.id.ivMessagesIconID:
                startMessageActivity();
                break;
            case R.id.ivSettingsIconID:
                startSettingsActivity();
                break;
            case R.id.ivDeliveryAndSaleIconID:
                startDeliveryAndSaleBoardActivity();
                break;
            case R.id.ivRideIconID:
                startFindRideActivity();
                break;
            case R.id.ivResidentServiceIconID:
                startResidentServiceActivity();
                break;
            case R.id.ivBusinessesIconID:
                startLocalBusinessActivity();
                break;
            case R.id.ivGalleryIconID:

                break;
            case R.id.ivAroundUsIconID:
                startAroundUsActivity();
                break;
        }

    }

    private void startRequestActivity() {
        Intent intent = new Intent(this, NewRequestActivity.class);
        startActivity(intent);
    }

    private void startMessageActivity() {
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }

        private void startSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
    private void startDeliveryAndSaleBoardActivity() {
        Intent intent = new Intent(this, DeliveryAndSaleBoardActivity.class);
        startActivity(intent);
    }

    private void startFindRideActivity() {
        Intent intent = new Intent(this, RideActivity.class);
        startActivity(intent);
    }

    private void startResidentServiceActivity() {
        Intent intent = new Intent(this, ResidentServiceActivity.class);
        startActivity(intent);
    }

    private void startLocalBusinessActivity() {
        Intent intent = new Intent(this, BusinessCategoryActivity.class);
        startActivity(intent);
    }

    //    private void startGalleryActivity() {
//        Intent intent = new Intent(this, NewRequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
    private void startAroundUsActivity() {
        Intent intent = new Intent(this, AroundUsCategoryActivity.class);
        startActivity(intent);
    }
}