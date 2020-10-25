package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bargiyora.model.Request;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {
    private List<Request> requestList;

    public RequestAdapter(List<Request> requestList){this.requestList=requestList;}
    @NonNull
    @Override
    public RequestAdapter.RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_request,parent,false);
        return new RequestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestAdapter.RequestViewHolder holder, int position) {
        Request item=requestList.get(position);
        holder.cbStatus.setChecked(item.getStatus());
        holder.tvPublishDate.setText(item.getPublishDate());
        holder.tvPublishTime.setText(item.getPublishDate());
        holder.tvFinishDate.setText(item.getFinishDate());
        holder.tvFinishTime.setText(item.getFinishTime());
        holder.tvContent.setText(item.getContent());
        //TODO add publisher and title
    }

    @Override
    public int getItemCount() { return requestList!=null? requestList.size() :0;}

    class RequestViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvTitle, tvPublishDate, tvPublishTime, tvFinishDate, tvFinishTime, tvPublisherName, tvContent;
        private final CheckBox cbStatus;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvRequestTitleID);
            tvPublishDate=itemView.findViewById(R.id.tvPublishDateID);
            tvPublishTime=itemView.findViewById(R.id.tvPublishTimeID);
            tvFinishDate=itemView.findViewById(R.id.tvFinishDateID);
            tvFinishTime=itemView.findViewById(R.id.tvFinishTimeID);
            tvPublisherName=itemView.findViewById(R.id.tvRequestPublisherNameID);
            tvContent=itemView.findViewById(R.id.tvRequestContentID);
            cbStatus=itemView.findViewById(R.id.cbStatusID);
        }
    }
}
