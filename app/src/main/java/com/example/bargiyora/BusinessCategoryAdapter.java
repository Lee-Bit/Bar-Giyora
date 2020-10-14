package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.data.model.BusinessCategory;

import java.util.List;

public class BusinessCategoryAdapter extends RecyclerView.Adapter<BusinessCategoryAdapter.BusinessCategoryViewHolder> {

    private List<BusinessCategory> businessCategoryList;

    public BusinessCategoryAdapter(List<BusinessCategory> businessCategoryList) {
        this.businessCategoryList = businessCategoryList;
    }

    @NonNull
    @Override
    public BusinessCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_business_category, parent, false);
        return new BusinessCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessCategoryViewHolder holder, int position) {
        BusinessCategory item = businessCategoryList.get(position);

        holder.tvTitle.setText(item.getName());

        /*switch (item.getId()) {
            case "001":
                holder.ivIcon.setImageResource(R.drawable.ic_food_category);
                break;

            case "002":
                holder.ivIcon.setImageResource(asdasd);
                break;
        }*/
    }

    @Override
    public int getItemCount() {
        return businessCategoryList != null ? businessCategoryList.size() : 0;
    }


    class BusinessCategoryViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;
        private final ImageView ivIcon;

        public BusinessCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
