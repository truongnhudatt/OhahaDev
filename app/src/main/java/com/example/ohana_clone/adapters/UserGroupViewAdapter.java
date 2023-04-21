package com.example.ohana_clone.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ohana_clone.R;
import com.example.ohana_clone.models.User;

import java.util.List;

public class UserGroupViewAdapter extends RecyclerView.Adapter<UserGroupViewAdapter.UserGroupViewHolder> {

    private Context context;
    private List<User> listUser;

    public UserGroupViewAdapter(Context context, List<User> listUser) {
        this.context = context;
        this.listUser = listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserGroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item, parent, false);
        return new UserGroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserGroupViewHolder holder, int position) {
        User user = listUser.get(position);
        if(user == null){
            return;
        }
        holder.imageViewGroup.setImageResource(user.getResourceId());
        holder.txtTen.setText(user.getName());
        holder.txtViTriTimKiem.setText(user.getLocation());
        holder.txtKhoangGia.setText(user.getFrom() + "VND - " + user.getTo() + " VND");
    }

    @Override
    public int getItemCount() {
        return listUser != null ? listUser.size() : 0;
    }

    public class UserGroupViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewGroup;
        private TextView txtViTriTimKiem;
        private TextView txtTen;
        private TextView txtKhoangGia;

        public UserGroupViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewGroup = itemView.findViewById(R.id.imageViewGroup);
            txtViTriTimKiem = itemView.findViewById(R.id.txtViTriTimKiem);
            txtTen = itemView.findViewById(R.id.txtTen);
            txtKhoangGia = itemView.findViewById(R.id.txtKhoangGia);

        }
    }
}
