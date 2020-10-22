package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.data.model.DeliveryAndSale;

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
        if (item.getType())
            holder.tvItemType.setText(R.string.forSale);
        else holder.tvItemType.setText(R.string.forDelivery);
        holder.tvItemDate.setText(item.getDate());
        holder.tvItemName.setText(item.getName());
        holder.tvItemPrice.setText(item.getPrice());
//        holder.tvPublisherName.setText();
//        holder.tvPublisherPhone.setText();
        holder.tvItemContent.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return deliveryAndSaleList!= null ? deliveryAndSaleList.size() :0;
    }

    class DeliveryAndSaleViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvItemType, tvItemDate, tvItemName, tvItemPrice, tvPublisherName, tvPublisherPhone, tvItemContent;
//
        public DeliveryAndSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemType = itemView.findViewById(R.id.tvItemTypeID);
            tvItemDate = itemView.findViewById(R.id.tvItemDateID);
            tvItemName = itemView.findViewById(R.id.tvItemNameID);
            tvItemPrice = itemView.findViewById(R.id.tvItemPriceID);
            tvPublisherName = itemView.findViewById(R.id.tvItemPublisherNameID);
            tvPublisherPhone = itemView.findViewById(R.id.tvItemPublisherPhoneID);
            tvItemContent = itemView.findViewById(R.id.tvItemContentID);
        }
    }
}
