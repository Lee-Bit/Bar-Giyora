package com.example.bargiyora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        holder.tvMessages.setText("ajshds");
    }

    @Override
    public int getItemCount() {
        return messagesList != null ? messagesList.size() :0;
    }

    class MessagesViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvMessages;

        public MessagesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessages= itemView.findViewById(R.id.tvMessagesID);
        }
    }
}
