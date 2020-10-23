package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import com.example.bargiyora.model.Messages;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {

    private List<Messages> messagesList;

    public MessagesAdapter(List<Messages> messagesList ){
        this.messagesList=messagesList;
    }

    @NonNull
    @Override
    public MessagesAdapter.MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_messages, parent, false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesAdapter.MessagesViewHolder holder, int position) {
        Messages item = messagesList.get(position);
        holder.tvMessageTitle.setText(item.getTitle());
        holder.tvMessagePublisherName.setText(item.getFullName());
        holder.tvMessageDate.setText(item.getDate());
        holder.tvMessageTime.setText(item.getTime());
        holder.tvMessageContent.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return messagesList != null ? messagesList.size() :0;
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvMessageTitle, tvMessagePublisherName, tvMessageDate, tvMessageTime, tvMessageContent;

        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessageTitle=itemView.findViewById(R.id.tvMessageTitleID);
            tvMessagePublisherName=itemView.findViewById(R.id.tvMessagePublisherID);
            tvMessageDate=itemView.findViewById(R.id.tvMessageDateID);
            tvMessageTime=itemView.findViewById(R.id.tvMessageTimeID);
            tvMessageContent=itemView.findViewById(R.id.tvMessageContentID);
        }
    }
}
