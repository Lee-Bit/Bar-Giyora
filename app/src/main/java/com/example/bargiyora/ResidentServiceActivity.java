package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResidentServiceActivity extends AppCompatActivity {

    private TextView tvPostDetails, tvSecuringDetails, tvBranchCollectionDetails,
            tvLumpyWasteCollectionDetails, tvSynagogueDetails, tvMikvehDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_service);

        tvPostDetails=findViewById(R.id.tvPostDetailsID);
        tvSecuringDetails=findViewById(R.id.tvSecuringDetailsID);
        tvBranchCollectionDetails=findViewById(R.id.tvBranchCollectionDetailsID);
        tvLumpyWasteCollectionDetails=findViewById(R.id.tvLumpyWasteCollectionDetailsID);
        tvSynagogueDetails=findViewById(R.id.tvSynagogueDetailsID);
        tvMikvehDetails=findViewById(R.id.tvMikvehDetailsID);

        findViewById(R.id.tvPostServiceID).setOnClickListener(new Listener());
        findViewById(R.id.tvSecuringServiceID).setOnClickListener(new Listener());
        findViewById(R.id.tvBranchCollectionServiceID).setOnClickListener(new Listener());
        findViewById(R.id.tvLumpyWasteCollectionServiceID).setOnClickListener(new Listener());
        findViewById(R.id.tvSynagogueServiceID).setOnClickListener(new Listener());
        findViewById(R.id.tvMikvehServiceID).setOnClickListener(new Listener());
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
