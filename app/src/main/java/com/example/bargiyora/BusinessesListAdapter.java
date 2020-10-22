package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.data.model.Business;

import java.util.List;

public class BusinessesListAdapter extends RecyclerView.Adapter<BusinessesListAdapter.BusinessesListViewHolder> {

    private List<Business> businessesList;

    public BusinessesListAdapter(List<Business> businessesList) {
        this.businessesList = businessesList;
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
            holder.tvBusinessName.setText(item.getName());
            holder.tvBusinessContent.setText(item.getContent());
            holder.tvBusinessPhone.setText(item.getPhone());
            holder.tvBusinessAddress.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return businessesList != null ? businessesList.size() :0;
    }

    class BusinessesListViewHolder extends RecyclerView.ViewHolder{
         private final TextView tvBusinessName, tvBusinessContent, tvBusinessPhone, tvBusinessAddress;

        public BusinessesListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusinessName=itemView.findViewById(R.id.tvBusinessNameID);
            tvBusinessContent=itemView.findViewById(R.id.tvBusinessContentID);
            tvBusinessPhone=itemView.findViewById(R.id.tvBusinessPhoneID);
            tvBusinessAddress=itemView.findViewById(R.id.tvBusinessAddressID);
        }
    }
}
