package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.bargiyora.model.DataManager;
import com.example.bargiyora.model.Messages;
import com.example.bargiyora.server_api.BaseResponse;
import com.example.bargiyora.server_api.DeleteMessageRequest;
import com.example.bargiyora.server_api.IOnServerRequestListener;
import com.example.bargiyora.server_api.ServerRequestHandler;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {

    private List<Messages> messagesList;

    public MessagesAdapter(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public MessagesAdapter.MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_messages, parent, false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.MessagesViewHolder holder, int position) {
        Messages item = messagesList.get(position);
        boolean isAdmin = DataManager.getInstance().getUser().isAdmin();

        holder.tvMessageTitle.setText(item.getTitle());
        holder.tvMessagePublisherName.setText(item.getFullName());
        holder.tvMessageDate.setText(item.getDate());
        holder.tvMessageTime.setText(item.getTime());
        holder.tvMessageContent.setText(item.getContent());
        holder.ivExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageExpand(holder);
            }
        });
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageDelete(position);
            }
        });
        if (isAdmin)
            holder.ivDelete.setVisibility(View.VISIBLE);
        else holder.ivDelete.setVisibility(View.GONE);
        holder.llMessageDetails.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return messagesList != null ? messagesList.size() : 0;
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvMessageTitle, tvMessagePublisherName, tvMessageDate, tvMessageTime, tvMessageContent;
        private final LinearLayout llMessageDetails;
        private final ImageView ivExpand, ivDelete;

        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessageTitle = itemView.findViewById(R.id.tvMessageTitleID);
            tvMessagePublisherName = itemView.findViewById(R.id.tvMessagePublisherID);
            tvMessageDate = itemView.findViewById(R.id.tvMessageDateID);
            tvMessageTime = itemView.findViewById(R.id.tvMessageTimeID);
            tvMessageContent = itemView.findViewById(R.id.tvMessageContentID);
            llMessageDetails = itemView.findViewById(R.id.llMessageDetailsID);
            ivExpand = itemView.findViewById(R.id.ivExpandID);
            ivDelete = itemView.findViewById(R.id.ivDeleteID);
        }
    }

    private void messageExpand(MessagesViewHolder holder){
        if (holder.llMessageDetails.getVisibility()== View.GONE){
            holder.llMessageDetails.setVisibility(View.VISIBLE);
            holder.ivExpand.setImageResource(R.drawable.ic_expand_less);
            return;
        }
        holder.llMessageDetails.setVisibility(View.GONE);
        holder.ivExpand.setImageResource(R.drawable.ic_expand_more);
    }

    private void messageDelete(int position){
        String userId = DataManager.getInstance().getUser().getPhone();
        DeleteMessageRequest deleteMessageRequest = new DeleteMessageRequest(userId, messagesList.get(position).getId());
        ServerRequestHandler.deleteMessage(deleteMessageRequest, new IOnServerRequestListener() {
            @Override
            public <T> void onSuccess(BaseResponse<T> baseResponse) {
                if (baseResponse != null) {
                    if ((Integer) baseResponse.getResults() > 0) {
                        messagesList.remove(position);
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
