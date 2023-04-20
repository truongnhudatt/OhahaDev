package com.example.ohana_clone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ohana_clone.R;
import com.example.ohana_clone.fragments.HomeFragment;

import java.util.List;

public class ImageIntroAdapter extends RecyclerView.Adapter<ImageIntroAdapter.ImageIntroViewHolder> {

    private Context context;
    private List<Integer> listResourceId;

    public ImageIntroAdapter(Context context, List<Integer> listResourceId) {
        this.context = context;
        this.listResourceId = listResourceId;
    }

    public ImageIntroAdapter(){}


    public List<Integer> getResourceId() {
        return listResourceId;
    }

    public void setResourceId(List<Integer> listResourceId) {
        this.listResourceId = listResourceId;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageIntroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_intro, parent, false);
        view.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return new ImageIntroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageIntroViewHolder holder, int position) {
        Integer resourceId = listResourceId.get(position);
        if(resourceId == null){
            return;
        }
        holder.imageView.setImageResource(resourceId);
    }


    @Override
    public int getItemCount() {
        return listResourceId != null ? listResourceId.size() : 0;
    }

    public class ImageIntroViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public ImageIntroViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
