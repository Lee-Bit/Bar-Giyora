package com.example.bargiyora.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.R;
import com.example.bargiyora.data.model.Site;

import java.util.List;

public class SiteListAdapter extends RecyclerView.Adapter<SiteListAdapter.SiteListViewHolder>{
    private List<Site> siteList;

    public SiteListAdapter(List<Site> siteList) {
        this.siteList = siteList;
    }

    @NonNull
    @Override
    public SiteListAdapter.SiteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_site,parent,false);
        return new SiteListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteListAdapter.SiteListViewHolder holder, int position) {
        Site item =siteList.get(position);
        holder.tvSiteName.setText(item.getName());
        holder.tvSiteContent.setText(item.getContent());
        holder.tvSitePhone.setText(item.getPhone());
        holder.tvSiteAddress.setText(item.getAddress());
    }

    @Override
    public int getItemCount() {
        return siteList != null ? siteList.size() :0;
    }

    class SiteListViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvSiteName, tvSiteContent, tvSitePhone, tvSiteAddress;

        public SiteListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSiteName = itemView.findViewById(R.id.tvSiteNameID);
            tvSiteContent = itemView.findViewById(R.id.tvSiteContentID);
            tvSitePhone = itemView.findViewById(R.id.tvSitePhoneID);
            tvSiteAddress = itemView.findViewById(R.id.tvSiteAddressID);
        }
    }
}
