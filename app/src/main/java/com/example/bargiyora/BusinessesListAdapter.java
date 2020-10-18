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
    }

    @Override
    public int getItemCount() {
        return businessesList != null ? businessesList.size() :0;
    }

    class BusinessesListViewHolder extends RecyclerView.ViewHolder{
         private final TextView tvBusinessListItem;

        public BusinessesListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBusinessListItem = itemView.findViewById(R.id.tvBusinessListItemID);
        }
    }
}
