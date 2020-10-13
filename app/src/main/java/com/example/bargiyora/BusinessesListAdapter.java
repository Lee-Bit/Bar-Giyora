package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BusinessesListAdapter extends RecyclerView.Adapter<BusinessesListAdapter.BusinessesListViewHolder> {

    private List<BusinessesList> businessesListList;

    public BusinessesListAdapter(List<BusinessesList> businessesListList) {
        this.businessesListList = businessesListList;
    }

    @NonNull
    @Override
    public BusinessesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_businesses_list, parent, false);
        return new BusinessesListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessesListViewHolder holder, int position) {
        BusinessesList item = businessesListList.get();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BusinessesListViewHolder extends RecyclerView.ViewHolder{
         private final TextView tvMessagesList;

        public BusinessesListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvMessagesList = itemView.findViewById(R.id.tvBusinessesListID);
        }
    }
}
