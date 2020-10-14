package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryAndSaleAdapter extends RecyclerView.Adapter<DeliveryAndSaleAdapter.DeliveryAndSaleViewHolder> {

    private List<DeliveryAndSale> deliveryAndSaleList;

    public DeliveryAndSaleAdapter(List<DeliveryAndSale> deliveryAndSaleList) {
        this.deliveryAndSaleList = deliveryAndSaleList;
    }

    @NonNull
    @Override
    public DeliveryAndSaleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_delivery_and_sale_board, parent, false);
        return new DeliveryAndSaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryAndSaleViewHolder holder, int position) {
        DeliveryAndSale item = deliveryAndSaleList.get(position);
//        holder.tvItemType.setText(item.getType());
//        holder.tvSaleItem.setText(item.getItem());
    }

    @Override
    public int getItemCount() {
        return deliveryAndSaleList!= null ? deliveryAndSaleList.size() :0;
    }

    class DeliveryAndSaleViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvItemType, tvSaleItem;
//
        public DeliveryAndSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemType = itemView.findViewById(R.id.tvItemTypeID);
            tvSaleItem = itemView.findViewById(R.id.tvSaleItemID);
        }
    }
}
