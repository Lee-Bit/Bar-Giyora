package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Site;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.DeleteSiteRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.example.bargiyora.utils.Util;

import java.util.List;

public class SiteListAdapter extends RecyclerView.Adapter<SiteListAdapter.SiteListViewHolder> {
    private List<Site> siteList;

    public SiteListAdapter(List<Site> siteList) {
        this.siteList = siteList;
    }

    public void addSite(Site site){
        if (site!=null){
            int index=siteList.size();
            siteList.add(site);
            notifyItemInserted(index);
        }
    }

    @NonNull
    @Override
    public SiteListAdapter.SiteListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_site, parent, false);
        return new SiteListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiteListAdapter.SiteListViewHolder holder, final int position) {
        final Site item = siteList.get(position);
        boolean isAdmin = DataManager.getInstance().getUser().isAdmin();

        holder.tvSiteName.setText(item.getName());
        holder.tvSiteContent.setText(item.getContent());
        holder.tvSitePhone.setText(item.getPhone());
        holder.tvSiteAddress.setText(item.getAddress());
        holder.ivExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siteExpand(holder);
            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siteDelete(position);
            }
        });
        if (isAdmin)
            holder.ivDelete.setVisibility(View.VISIBLE);
        else holder.ivDelete.setVisibility(View.GONE);
        holder.llSiteDetails.setVisibility(View.GONE);
        holder.ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.openDialPadWithNumber(v.getContext(), holder.tvSitePhone.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return siteList != null ? siteList.size() : 0;
    }

    class SiteListViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvSiteName, tvSiteContent, tvSitePhone, tvSiteAddress;
        private final LinearLayout llSiteDetails;
        private final ImageView ivExpand, ivDelete, ivPhone;

        public SiteListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSiteName = itemView.findViewById(R.id.tvSiteNameID);
            tvSiteContent = itemView.findViewById(R.id.tvSiteContentID);
            tvSitePhone = itemView.findViewById(R.id.tvSitePhoneID);
            tvSiteAddress = itemView.findViewById(R.id.tvSiteAddressID);
            llSiteDetails = itemView.findViewById(R.id.llSiteDetailsID);
            ivExpand = itemView.findViewById(R.id.ivExpandID);
            ivDelete = itemView.findViewById(R.id.ivDeleteID);
            ivPhone = itemView.findViewById(R.id.ivPhoneID);
        }
    }

    private void siteExpand(SiteListViewHolder holder) {
        if (holder.llSiteDetails.getVisibility() == View.GONE) {
            holder.llSiteDetails.setVisibility(View.VISIBLE);
            holder.ivExpand.setImageResource(R.drawable.ic_expand_less);
            return;
        }
        holder.llSiteDetails.setVisibility(View.GONE);
        holder.ivExpand.setImageResource(R.drawable.ic_expand_more);
    }

    private void siteDelete(int position) {
        String userId = DataManager.getInstance().getUser().getPhone();
        DeleteSiteRequest deleteSiteRequest = new DeleteSiteRequest(userId, siteList.get(position).getId());
        ServerRequestHandler.deleteSite(deleteSiteRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    if ((Integer) baseResponse.getResults() > 0) {
                        siteList.remove(position);
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
