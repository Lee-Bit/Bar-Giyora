package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Request;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;
import com.example.bargiyora.server_api.UpdateStatusRequest;
import com.example.bargiyora.utils.AppSettings;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {
    private List<Request> requestList;

    public RequestAdapter(List<Request> requestList) {
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public RequestAdapter.RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_request, parent, false);
        return new RequestViewHolder(view);
    }

    public void addRequest(Request request) {
        if (request != null) {
            int index = requestList.size();
            requestList.add(request);
            notifyItemInserted(index);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapter.RequestViewHolder holder, int position) {
        Request item = requestList.get(position);
        boolean isAdmin = DataManager.getInstance().getUser().isAdmin();
        boolean status = item.getStatus();
        String categoryId = item.getCategory();

        holder.tvPublishDate.setText(item.getPublishDate());
        holder.tvPublishTime.setText(item.getPublishDate());
        holder.tvContent.setText(item.getContent());
        holder.tvPublisherName.setText(item.getFullName());
        holder.tvPublisherPhone.setText(item.getPublisherId());
        holder.tvTitle.setText(getTitle(categoryId));
        holder.llRequestDetails.setVisibility(View.GONE);

        if (status) {
            holder.tvFinishDate.setText(item.getFinishDate());
            holder.tvFinishTime.setText(item.getFinishTime());
            holder.llFinishRequest.setVisibility(View.VISIBLE);
        } else holder.llFinishRequest.setVisibility(View.GONE);

        holder.cbStatus.setChecked(status);
        holder.cbStatus.setClickable(isAdmin);
        holder.cbStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStatus(position);
            }
        });
        holder.ivExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestExpand(holder);
            }
        });
    }

    @Override
    public int getItemCount() {
        return requestList != null ? requestList.size() : 0;
    }

    class RequestViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTitle, tvPublishDate, tvPublishTime, tvFinishDate,
                tvFinishTime, tvPublisherName, tvPublisherPhone, tvContent;
        private final CheckBox cbStatus;
        private final ImageView ivExpand;
        private final LinearLayout llRequestDetails, llFinishRequest;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvRequestTitleID);
            tvPublishDate = itemView.findViewById(R.id.tvPublishDateID);
            tvPublishTime = itemView.findViewById(R.id.tvPublishTimeID);
            tvFinishDate = itemView.findViewById(R.id.tvFinishDateID);
            tvFinishTime = itemView.findViewById(R.id.tvFinishTimeID);
            tvPublisherName = itemView.findViewById(R.id.tvRequestPublisherNameID);
            tvContent = itemView.findViewById(R.id.tvRequestContentID);
            tvPublisherPhone = itemView.findViewById(R.id.tvPublisherPhoneID);
            cbStatus = itemView.findViewById(R.id.cbStatusID);
            ivExpand = itemView.findViewById(R.id.ivExpandID);
            llRequestDetails = itemView.findViewById(R.id.llRequestDetailsID);
            llFinishRequest = itemView.findViewById(R.id.llFinishRequestID);
        }
    }

    private int getTitle(String categoryId) {
        switch (categoryId) {
            case AppSettings
                    .REQUEST_CATEGORY_SECURITY:
                return R.string.security;
            case AppSettings.REQUEST_CATEGORY_MAINTENANCE:
                return R.string.maintenance;
            case AppSettings.REQUEST_CATEGORY_CULTURE:
                return R.string.culture;
        }
        return R.string.other;
    }

    private void requestExpand(RequestViewHolder holder) {
        if (holder.llRequestDetails.getVisibility() == View.GONE) {
            holder.llRequestDetails.setVisibility(View.VISIBLE);
            holder.ivExpand.setImageResource(R.drawable.ic_expand_less);
            return;
        }
        holder.llRequestDetails.setVisibility(View.GONE);
        holder.ivExpand.setImageResource(R.drawable.ic_expand_more);
    }

    private void updateStatus(int position) {
        String userId = DataManager.getInstance().getUser().getPhone();
        boolean newStatus = !(requestList.get(position).getStatus());
        UpdateStatusRequest updateStatusRequest = new UpdateStatusRequest(requestList.get(position).getId(), userId, newStatus);
        ServerRequestHandler.updateStatus(updateStatusRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    Request request = (Request) baseResponse.getResults();
                    if (request != null) {
                        requestList.remove(position);
                        requestList.add(position, request);
                        notifyItemChanged(position);
                    }
                } else return;// TODO: 10/27/2020
            }

            @Override
            public void onFailure() {
// TODO: 10/27/2020 fix this
            }
        });
    }
}
