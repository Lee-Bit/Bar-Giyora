package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.model.Business;
import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.DeleteBusinessRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.example.bargiyora.utils.Util;

import java.util.List;

public class BusinessesListAdapter extends RecyclerView.Adapter<BusinessesListAdapter.BusinessesListViewHolder> {

    private List<Business> businessesList;

    public BusinessesListAdapter(List<Business> businessesList) {
        this.businessesList = businessesList;
    }

    public void addBusiness(Business business){
        if (business!=null){
            int index = businessesList.size();
            businessesList.add(business);
            notifyItemInserted(index);
        }
    }
    @NonNull
    @Override
    public BusinessesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_businesses_list, parent, false);
        return new BusinessesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessesListViewHolder holder, int position) {
        Business item = businessesList.get(position);
        boolean isAdmin = DataManager.getInstance().getUser().isAdmin();

        holder.tvBusinessName.setText(item.getName());
        holder.tvBusinessContent.setText(item.getContent());
        holder.tvBusinessPhone.setText(item.getPhone());
        holder.tvBusinessAddress.setText(item.getAddress());
        holder.ivExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessExpand(holder);
            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessDelete(position);
            }
        });
        if (isAdmin)
            holder.ivDelete.setVisibility(View.VISIBLE);
        else holder.ivDelete.setVisibility(View.GONE);
        holder.llBusinessDetails.setVisibility(View.GONE);
        holder.ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.openDialPadWithNumber(v.getContext(), holder.tvBusinessPhone.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return businessesList != null ? businessesList.size() : 0;
    }

    class BusinessesListViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvBusinessName, tvBusinessContent, tvBusinessPhone, tvBusinessAddress;
        private final LinearLayout llBusinessDetails;
        private final ImageView ivExpand, ivDelete, ivPhone;

        public BusinessesListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusinessName = itemView.findViewById(R.id.tvBusinessNameID);
            tvBusinessContent = itemView.findViewById(R.id.tvBusinessContentID);
            tvBusinessPhone = itemView.findViewById(R.id.tvBusinessPhoneID);
            tvBusinessAddress = itemView.findViewById(R.id.tvBusinessAddressID);
            llBusinessDetails = itemView.findViewById(R.id.llBusinessDetailsID);
            ivExpand = itemView.findViewById(R.id.ivExpandID);
            ivDelete = itemView.findViewById(R.id.ivDeleteID);
            ivPhone = itemView.findViewById(R.id.ivPhoneID);
        }
    }

    private void businessExpand(BusinessesListViewHolder holder) {
        if (holder.llBusinessDetails.getVisibility() == View.GONE) {
            holder.llBusinessDetails.setVisibility(View.VISIBLE);
            holder.ivExpand.setImageResource(R.drawable.ic_expand_less);
            return;
        }
        holder.llBusinessDetails.setVisibility(View.GONE);
        holder.ivExpand.setImageResource(R.drawable.ic_expand_more);
    }

    private void businessDelete(int position) {
        String userId = DataManager.getInstance().getUser().getPhone();
        DeleteBusinessRequest deleteBusinessRequest = new DeleteBusinessRequest(userId, businessesList.get(position).getID());
        ServerRequestHandler.deleteBusiness(deleteBusinessRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    if ((Integer) baseResponse.getResults() > 0) {
                        businessesList.remove(position);
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
