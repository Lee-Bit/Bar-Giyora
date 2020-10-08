package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResidentServiceActivity extends AppCompatActivity {

    private TextView tvPostService, tvPostDetails, tvSecuringService, tvSecuringDetails,
            tvBranchCollectionService, tvBranchCollectionDetails, tvLumpyWasteCollectionService, tvLumpyWasteCollectionDetails,
            tvSynagogueService, tvSynagogueDetails, tvMikvehService, tvMikvehDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_service);

        tvPostService=findViewById(R.id.tvPostServiceID);
        tvPostDetails=findViewById(R.id.tvPostDetailsID);
        tvSecuringService=findViewById(R.id.tvSecuringServiceID);
        tvSecuringDetails=findViewById(R.id.tvSecuringDetailsID);
        tvBranchCollectionService=findViewById(R.id.tvBranchCollectionServiceID);
        tvBranchCollectionDetails=findViewById(R.id.tvBranchCollectionDetailsID);
        tvLumpyWasteCollectionService=findViewById(R.id.tvLumpyWasteCollectionServiceID);
        tvLumpyWasteCollectionDetails=findViewById(R.id.tvLumpyWasteCollectionDetailsID);
        tvSynagogueService=findViewById(R.id.tvSynagogueServiceID);
        tvSynagogueDetails=findViewById(R.id.tvSynagogueDetailsID);
        tvMikvehService=findViewById(R.id.tvMikvehServiceID);
        tvMikvehDetails=findViewById(R.id.tvMikvehDetailsID);

        tvPostService.setOnClickListener(new Listener());
        tvSecuringService.setOnClickListener(new Listener());
        tvBranchCollectionService.setOnClickListener(new Listener());
        tvLumpyWasteCollectionService.setOnClickListener(new Listener());
        tvSynagogueService.setOnClickListener(new Listener());
        tvMikvehService.setOnClickListener(new Listener());
    }

    private class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            switch (v.getId()){
                case(R.id.tvPostServiceID): {
                    if(tvPostDetails.getVisibility()== View.GONE)
                        tvPostDetails.setVisibility(View.VISIBLE);
                    else
                        tvPostDetails.setVisibility(View.GONE);
                    break;
                }
                case(R.id.tvSecuringServiceID): {
                    if(tvSecuringDetails.getVisibility()== View.GONE)
                        tvSecuringDetails.setVisibility(View.VISIBLE);
                    else
                        tvSecuringDetails.setVisibility(View.GONE);
                    break;
                }
                case(R.id.tvBranchCollectionServiceID): {
                    if(tvBranchCollectionDetails.getVisibility()== View.GONE)
                        tvBranchCollectionDetails.setVisibility(View.VISIBLE);
                    else
                        tvBranchCollectionDetails.setVisibility(View.GONE);
                    break;
                }
                case(R.id.tvLumpyWasteCollectionServiceID): {
                    if(tvLumpyWasteCollectionDetails.getVisibility()== View.GONE)
                        tvLumpyWasteCollectionDetails.setVisibility(View.VISIBLE);
                    else
                        tvLumpyWasteCollectionDetails.setVisibility(View.GONE);
                    break;
                }
                case(R.id.tvSynagogueServiceID): {
                    if(tvSynagogueDetails.getVisibility()== View.GONE)
                        tvSynagogueDetails.setVisibility(View.VISIBLE);
                    else
                        tvSynagogueDetails.setVisibility(View.GONE);
                    break;
                }
                case(R.id.tvMikvehServiceID): {
                    if(tvMikvehDetails.getVisibility()== View.GONE)
                        tvMikvehDetails.setVisibility(View.VISIBLE);
                    else
                        tvMikvehDetails.setVisibility(View.GONE);
                    break;
                }
            }

        }
    }
}
