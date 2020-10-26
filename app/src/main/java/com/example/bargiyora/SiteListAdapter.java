package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    public void onBindViewHolder(@NonNull SiteListAdapter.SiteListViewHolder holder, final int position) {
        final Site item =siteList.get(position);
        holder.tvSiteName.setText(item.getName());
        holder.tvSiteContent.setText(item.getContent());
        holder.tvSitePhone.setText(item.getPhone());
        holder.tvSiteAddress.setText(item.getAddress());

        /*
        // TODO: 10/26/2020 fix this
        holder.tvSitePhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = DataManager.getInstance().getUser().getPhone();
                DeleteSiteRequest deleteSiteRequest = new DeleteSiteRequest(userId ,item.getId());
                ServerRequestHandler.deleteSite(deleteSiteRequest, new IOnServerRequestListener() {
                    @Override
                    public <T> void onSuccess(BaseResponse<T> baseResponse) {
                        notifyItemRemoved(position);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
        });
         */

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
