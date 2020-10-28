package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bargiyora.utils.AppSettings;

public class BusinessCategoryActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_category);

        findViewById(R.id.llFoodID).setOnClickListener(this);
        findViewById(R.id.llConstructionID).setOnClickListener(this);
        findViewById(R.id.llElectricID).setOnClickListener(this);
        findViewById(R.id.llCosmeticID).setOnClickListener(this);
        findViewById(R.id.llWoodID).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.llFoodID:
                startBusinessesListActivity(AppSettings.BUSINESS_CATEGORY_FOOD);
                break;
            case R.id.llConstructionID:
                startBusinessesListActivity(AppSettings.BUSINESS_CATEGORY_CONSTRUCTION);
                break;
            case R.id.llElectricID:
                startBusinessesListActivity(AppSettings.BUSINESS_CATEGORY_ELECTRIC);
                break;
            case R.id.llCosmeticID:
                startBusinessesListActivity(AppSettings.BUSINESS_CATEGORY_COSMETIC);
                break;
            case R.id.llWoodID:
                startBusinessesListActivity(AppSettings.BUSINESS_CATEGORY_WOOD);
                break;
        }
    }

    private void startBusinessesListActivity(String value) {
        Intent intent = new Intent(this, BusinessesListActivity.class);
        intent.putExtra(BusinessesListActivity.EXTRA_KEY, value);
        startActivity(intent);
    }
}
