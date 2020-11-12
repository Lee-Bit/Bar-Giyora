package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.DeliveryAndSale;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.DeleteDeliveryAndSaleRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.example.bargiyora.utils.Util;

import java.util.List;

public class DeliveryAndSaleAdapter extends RecyclerView.Adapter<DeliveryAndSaleAdapter.DeliveryAndSaleViewHolder> {

    private List<DeliveryAndSale> deliveryAndSaleList;

    public DeliveryAndSaleAdapter(List<DeliveryAndSale> deliveryAndSaleList) {
        this.deliveryAndSaleList = deliveryAndSaleList;
    }

    public void addItem(DeliveryAndSale deliveryAndSale) {
        if(deliveryAndSale != null) {
            int index = deliveryAndSaleList.size();
            deliveryAndSaleList.add(deliveryAndSale);
            notifyItemInserted(index);
        }
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
        String userId = DataManager.getInstance().getUser().getPhone();
        boolean isAdmin = DataManager.getInstance().getUser().isAdmin();

        if (item.getType())
            holder.tvItemType.setText(R.string.forSale);
        else holder.tvItemType.setText(R.string.forDelivery);
        holder.tvItemDate.setText(item.getDate());
        holder.tvItemName.setText(item.getName());
        holder.tvItemPrice.setText(item.getPrice());
        holder.tvPublisherName.setText(item.getFullName());
        holder.tvPublisherPhone.setText(item.getPublisherPhone());
        holder.tvItemContent.setText(item.getContent());
        if(userId.equals(item.getPublisherPhone()) || isAdmin)
            holder.ivDelete.setVisibility(View.VISIBLE);
        else holder.ivDelete.setVisibility(View.GONE);
        holder.llItemDetails.setVisibility(View.GONE);
        holder.ivExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemExpand(holder);
            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemDelete(position, userId);
            }
        });
        holder.ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.openDialPadWithNumber(v.getContext(), holder.tvPublisherPhone.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return deliveryAndSaleList!= null ? deliveryAndSaleList.size() :0;
    }

    class DeliveryAndSaleViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvItemType, tvItemDate, tvItemName, tvItemPrice, tvPublisherName, tvPublisherPhone, tvItemContent;
        private final LinearLayout llItemDetails;
        private final ImageView ivExpand, ivDelete, ivPhone;

        public DeliveryAndSaleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItemType = itemView.findViewById(R.id.tvItemTypeID);
            tvItemDate = itemView.findViewById(R.id.tvItemDateID);
            tvItemName = itemView.findViewById(R.id.tvItemNameID);
            tvItemPrice = itemView.findViewById(R.id.tvItemPriceID);
            tvPublisherName = itemView.findViewById(R.id.tvItemPublisherNameID);
            tvPublisherPhone = itemView.findViewById(R.id.tvItemPublisherPhoneID);
            tvItemContent = itemView.findViewById(R.id.tvItemContentID);
            llItemDetails=itemView.findViewById(R.id.llItemDetailsID);
            ivExpand=itemView.findViewById(R.id.ivExpandID);
            ivDelete=itemView.findViewById(R.id.ivDeleteID);
            ivPhone=itemView.findViewById(R.id.ivPhoneID);
        }
    }

    private void itemExpand(DeliveryAndSaleViewHolder holder){
        if (holder.llItemDetails.getVisibility()==View.GONE){
            holder.llItemDetails.setVisibility(View.VISIBLE);
            holder.ivExpand.setImageResource(R.drawable.ic_expand_less);
            return;
        }
        holder.llItemDetails.setVisibility(View.GONE);
        holder.ivExpand.setImageResource(R.drawable.ic_expand_more);
    }

    private void itemDelete(int position, String userId){
        DeleteDeliveryAndSaleRequest deleteDeliveryAndSaleRequest
                = new DeleteDeliveryAndSaleRequest(userId, deliveryAndSaleList.get(position).getID());
        ServerRequestHandler.deleteItem(deleteDeliveryAndSaleRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    if ((Integer) baseResponse.getResults() > 0) {
                        deliveryAndSaleList.remove(position);
                        notifyItemRemoved(position);
                    }
                } else
                    return; // TODO: 10/27/2020 add error
            }

            @Override
            public void onFailure() {
                // TODO: 10/27/2020 fix this
            }
        });
    }
}
