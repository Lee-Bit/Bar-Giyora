package com.example.bargiyora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.DeliveryAndSale;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DeliveryAndSaleBoardActivity extends AppCompatActivity implements IOnServerRequestListener {

    private RecyclerView rcDeliveryAndSale;
    private ProgressBar progressBar;
    private Dialog dialog;
    private EditText etPrice, etItemName, etItemDetails;
    private View llAddItemBtn, llSubmitBtn;
    private LinearLayout llItemPrice;
    private CheckBox cbForSale;
    private DeliveryAndSaleAdapter deliveryAndSaleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_and_sale_board);

        rcDeliveryAndSale = findViewById(R.id.rcDeliveryAndSaleBoardID);
        progressBar = findViewById(R.id.progressBarID);
        llAddItemBtn = findViewById(R.id.llAddItemBtn);
        llAddItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOpenDialog();
            }
        });
        ServerRequestHandler.getItemList(this);
    }

    @Override
    public <T> void onSuccess(BaseResponse<T> baseResponse) {
        if (baseResponse != null) {
            List<DeliveryAndSale> deliveryAndSaleList = (List<DeliveryAndSale>) baseResponse.getResults();
            deliveryAndSaleAdapter = new DeliveryAndSaleAdapter(deliveryAndSaleList);
            rcDeliveryAndSale.setAdapter(deliveryAndSaleAdapter);
            progressBar.setVisibility(View.GONE);
        } else return;// TODO: 10/28/2020
    }

    @Override
    public void onFailure() {
// TODO: 10/27/2020 fix this
    }

    private void itemOpenDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_delivery_and_sale); // add the layout xml to dialog
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        // get the Views from the XML and use them
        etPrice = dialog.findViewById(R.id.etItemPriceID);
        etItemName = dialog.findViewById(R.id.etItemNameID);
        etItemDetails = dialog.findViewById(R.id.etItemDetailsID);
        llSubmitBtn = dialog.findViewById(R.id.llSubmitBtn);
        llItemPrice = dialog.findViewById(R.id.llItemPriceID);
        cbForSale = dialog.findViewById(R.id.cbItemTypeID);

        cbForSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemChangeType();
            }
        });
        llSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewItem();
            }
        });

        dialog.show(); // show the dialog!
    }

    private void itemChangeType() {
        if (cbForSale.isChecked())
            llItemPrice.setVisibility(View.VISIBLE);
        else llItemPrice.setVisibility(View.GONE);
    }

    private void addNewItem() {
        boolean forSale = cbForSale.isChecked();
        String price = "";
        if (forSale)
            price = etPrice.getText().toString();
        String userId = DataManager.getInstance().getUser().getPhone();
        String userFirstName = DataManager.getInstance().getUser().getFirstName();
        String userLastName = DataManager.getInstance().getUser().getLastName();
        String itemName = etItemName.getText().toString();
        if (itemName.isEmpty()) {
            return;// TODO: 10/28/2020 add error
        }
        String itemDetails = etItemDetails.getText().toString();
        if (itemDetails.isEmpty()) {
            return; // TODO: 10/28/2020 add error
        }
        DeliveryAndSale newItem = new DeliveryAndSale("", forSale, price, "", itemName, itemDetails, userFirstName, userLastName, userId);
        ServerRequestHandler.addItem(newItem, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    DeliveryAndSale deliveryAndSale = (DeliveryAndSale) baseResponse.getResults();
                    if (deliveryAndSaleAdapter != null && deliveryAndSale != null) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }
                        deliveryAndSaleAdapter.addItem(deliveryAndSale);
                    }
                }// TODO: 10/28/2020 add error
            }

            @Override
            public void onFailure() {
// TODO: 10/28/2020
            }
        });
    }


}
