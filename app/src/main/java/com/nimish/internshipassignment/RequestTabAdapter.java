package com.nimish.internshipassignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RequestTabAdapter extends RecyclerView.Adapter<RequestTabAdapter.RequestTabViewHolder> {
    private ArrayList<RequestTabItems> mRequestTabItems;
    private OnItemClickListener onItemClickListener;

    public RequestTabAdapter(ArrayList<RequestTabItems> requestTabItems){
        mRequestTabItems = requestTabItems;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }

    @NonNull
    @Override
    public RequestTabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        RequestTabViewHolder requestTabViewHolder = new RequestTabViewHolder(v, onItemClickListener);
        return requestTabViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RequestTabViewHolder holder, int position) {
        RequestTabItems currentItem = mRequestTabItems.get(position);
        holder.userImg.setImageResource(currentItem.getUserImage());
        holder.userName.setText(currentItem.getUserName());
        holder.userPurpose.setText(currentItem.getUserPurpose());
        holder.dateTime.setText(currentItem.getDateTime());
        holder.location.setText(currentItem.getLocation());
        holder.description.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mRequestTabItems.size();
    }

    public static class RequestTabViewHolder extends RecyclerView.ViewHolder{
        public ImageView userImg;
        public TextView userName;
        public TextView userPurpose;
        public TextView deleteCard;
        public TextView dateTime;
        public TextView location;
        public TextView description;
        public RequestTabViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            userImg = itemView.findViewById(R.id.user_img);
            userName = itemView.findViewById(R.id.name_textview);
            userPurpose = itemView.findViewById(R.id.purpose_details_textview);
            deleteCard = itemView.findViewById(R.id.delete_option);
            dateTime = itemView.findViewById(R.id.date_time_textview);
            location = itemView.findViewById(R.id.location_textview);
            description = itemView.findViewById(R.id.description_textview);

            deleteCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

}
