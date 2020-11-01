package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResidentServiceActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvPostDetails, tvSecuringDetails, tvBranchCollectionDetails,
            tvLumpyWasteCollectionDetails, tvSynagogueDetails, tvMikvehDetails;
    private ImageView ivPostExpand, ivSecurityExpand, ivBranchExpand, ivLumpyWasteExpand, ivSynagogueExpand, ivMikveExpand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_service);

        tvPostDetails = findViewById(R.id.tvPostDetailsID);
        tvSecuringDetails = findViewById(R.id.tvSecuringDetailsID);
        tvBranchCollectionDetails = findViewById(R.id.tvBranchCollectionDetailsID);
        tvLumpyWasteCollectionDetails = findViewById(R.id.tvLumpyWasteCollectionDetailsID);
        tvSynagogueDetails = findViewById(R.id.tvSynagogueDetailsID);
        tvMikvehDetails = findViewById(R.id.tvMikvehDetailsID);

        ivPostExpand = findViewById(R.id.ivPostExpandID);
        ivPostExpand.setOnClickListener(this);
        ivSecurityExpand = findViewById(R.id.ivSecurityExpandID);
        ivSecurityExpand.setOnClickListener(this);
        ivBranchExpand = findViewById(R.id.ivBranchExpandID);
        ivBranchExpand.setOnClickListener(this);
        ivLumpyWasteExpand = findViewById(R.id.ivLumpyWasteExpandID);
        ivLumpyWasteExpand.setOnClickListener(this);
        ivSynagogueExpand = findViewById(R.id.ivSynagogueExpandID);
        ivSynagogueExpand.setOnClickListener(this);
        ivMikveExpand = findViewById(R.id.ivMikveExpandID);
        ivMikveExpand.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.ivPostExpandID): {
                if (tvPostDetails.getVisibility() == View.GONE) {
                    tvPostDetails.setVisibility(View.VISIBLE);
                    ivPostExpand.setImageResource(R.drawable.ic_expand_less);
                } else {
                    tvPostDetails.setVisibility(View.GONE);
                    ivPostExpand.setImageResource(R.drawable.ic_expand_more);
                }
                break;
            }
            case (R.id.ivSecurityExpandID): {
                if (tvSecuringDetails.getVisibility() == View.GONE) {
                    tvSecuringDetails.setVisibility(View.VISIBLE);
                    ivSecurityExpand.setImageResource(R.drawable.ic_expand_less);
                } else {
                    tvSecuringDetails.setVisibility(View.GONE);
                    ivSecurityExpand.setImageResource(R.drawable.ic_expand_more);
                }
                break;
            }
            case (R.id.ivBranchExpandID): {
                if (tvBranchCollectionDetails.getVisibility() == View.GONE) {
                    tvBranchCollectionDetails.setVisibility(View.VISIBLE);
                    ivBranchExpand.setImageResource(R.drawable.ic_expand_less);
                } else {
                    tvBranchCollectionDetails.setVisibility(View.GONE);
                    ivBranchExpand.setImageResource(R.drawable.ic_expand_more);
                }
                break;
            }
            case (R.id.ivLumpyWasteExpandID): {
                if (tvLumpyWasteCollectionDetails.getVisibility() == View.GONE) {
                    tvLumpyWasteCollectionDetails.setVisibility(View.VISIBLE);
                    ivLumpyWasteExpand.setImageResource(R.drawable.ic_expand_less);
                } else {
                    tvLumpyWasteCollectionDetails.setVisibility(View.GONE);
                    ivLumpyWasteExpand.setImageResource(R.drawable.ic_expand_more);
                }
                break;
            }
            case (R.id.ivSynagogueExpandID): {
                if (tvSynagogueDetails.getVisibility() == View.GONE) {
                    tvSynagogueDetails.setVisibility(View.VISIBLE);
                    ivSynagogueExpand.setImageResource(R.drawable.ic_expand_less);
                } else {
                    tvSynagogueDetails.setVisibility(View.GONE);
                    ivSynagogueExpand.setImageResource(R.drawable.ic_expand_more);
                }
                break;
            }
            case (R.id.ivMikveExpandID): {
                if (tvMikvehDetails.getVisibility() == View.GONE) {
                    tvMikvehDetails.setVisibility(View.VISIBLE);
                    ivMikveExpand.setImageResource(R.drawable.ic_expand_less);
                } else {
                    tvMikvehDetails.setVisibility(View.GONE);
                    ivMikveExpand.setImageResource(R.drawable.ic_expand_more);
                }
                break;
            }
        }
    }
}
