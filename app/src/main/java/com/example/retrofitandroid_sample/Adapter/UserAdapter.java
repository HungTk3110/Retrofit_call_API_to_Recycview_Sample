package com.example.retrofitandroid_sample.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandroid_sample.R;
import com.example.retrofitandroid_sample.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterHolder> {

    List<User> list;

    public UserAdapter(List<User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rcv , parent , false);
        return new UserAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterHolder holder, int position) {
        User user = list.get(position);
        holder.tv_id.setText(String.valueOf(user.getId()));
        holder.tv_title.setText(user.getTitle());
    }

    @Override
    public int getItemCount() {
        if(list != null)
            return list.size();
        return 0;
    }

    public static class UserAdapterHolder extends RecyclerView.ViewHolder {

        private final TextView tv_id , tv_title ;

        public UserAdapterHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
