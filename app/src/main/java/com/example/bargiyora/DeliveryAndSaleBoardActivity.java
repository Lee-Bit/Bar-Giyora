package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.bargiyora.model.DeliveryAndSale;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

import java.util.List;

public class DeliveryAndSaleBoardActivity extends AppCompatActivity implements IOnServerRequestListener {

    private RecyclerView rcDeliveryAndSale;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_and_sale_board);

        rcDeliveryAndSale=findViewById(R.id.rcDeliveryAndSaleBoardID);
        progressBar=findViewById(R.id.progressBarID);
        ServerRequestHandler.getItemList(this);

    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse!=null){
            List<DeliveryAndSale> deliveryAndSaleList= (List<DeliveryAndSale>)baseResponse.getResults();
            DeliveryAndSaleAdapter deliveryAndSaleAdapter = new DeliveryAndSaleAdapter(deliveryAndSaleList);
            rcDeliveryAndSale.setAdapter(deliveryAndSaleAdapter);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFailure() {
// TODO: 10/27/2020 fix this
    }
}
