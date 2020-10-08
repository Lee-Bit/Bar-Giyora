package com.example.bargiyora;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRequest = findViewById(R.id.btnRequestID);
        btnRequest.setOnClickListener(new Listener());
        Button btnMessage = findViewById(R.id.btnMessageID);
        btnMessage.setOnClickListener(new Listener());
        Button btnSchedule = findViewById(R.id.btnScheduleID);
        btnSchedule.setOnClickListener(new Listener());
        Button btnSellAndDeliveryBord = findViewById(R.id.btnSellAndDeliveryBoardID);
        btnSellAndDeliveryBord.setOnClickListener(new Listener());
        Button btnFindRide = findViewById(R.id.btnFindRideID);
        btnFindRide.setOnClickListener(new Listener());
        Button btnResidenService = findViewById(R.id.btnResidentServiceID);
        btnResidenService.setOnClickListener(new Listener());
        Button btnLocalBusiness = findViewById(R.id.btnLocalBusinessID);
        btnLocalBusiness.setOnClickListener(new Listener());
        Button btnGallery = findViewById(R.id.btnGalleryID);
        btnGallery.setOnClickListener(new Listener());
        Button btnNearUs = findViewById(R.id.btnNNearUsID);
        btnNearUs.setOnClickListener(new Listener());

    }

    private class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.btnRequestID:
                    startRequestActivity();
                    break;
                case R.id.btnMessageID:
                    startLoginActivity();
                    break;
                case R.id.btnScheduleID:

                    break;
                case R.id.btnSellAndDeliveryBoardID:

                    break;
                case R.id.btnFindRideID:
                    startRegistrationActivity();
                    break;
                case R.id.btnResidentServiceID:
                    startResidentServiceActivity();
                    break;
                case R.id.btnLocalBusinessID:

                    break;
                case R.id.btnGalleryID:

                    break;
                case R.id.btnNNearUsID:

                    break;
            }
        }
    }


    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
    }
    private void startRegistrationActivity() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
    private void startRequestActivity() {
        Intent intent = new Intent(this, RequestActivity.class);
        startActivity(intent);
    }
//    private void startMessageActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
//    private void startScheduleActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
//    private void startSellAndDeliveryBoardActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
//    private void startFindRideActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
    private void startResidentServiceActivity() {
        Intent intent = new Intent(this, ResidentServiceActivity.class);
        startActivity(intent);
    }
//    private void startLocalBusinessActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
//    private void startGalleryActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
//    private void startNearUsActivity() {
//        Intent intent = new Intent(this, RequestActivity.class); need to change the activity
//        startActivity(intent);
//    }
}