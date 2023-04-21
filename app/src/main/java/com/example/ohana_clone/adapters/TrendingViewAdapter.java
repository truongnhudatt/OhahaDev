package com.example.ohana_clone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ohana_clone.R;
import com.example.ohana_clone.models.Trending;

import java.util.List;

public class TrendingViewAdapter extends RecyclerView.Adapter<TrendingViewAdapter.TrendingViewHolder> {

    private Context context;
    private List<Trending> listTrending;

    public TrendingViewAdapter(Context context, List<Trending> listTrending) {
        this.context = context;
        this.listTrending = listTrending;
    }

    public void setListTrending(List<Trending> listTrending) {
        this.listTrending = listTrending;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.trending_item, parent, false);
        return new TrendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingViewHolder holder, int position) {
        Trending trending = listTrending.get(position);
        if(trending == null){
            return;
        }
        holder.imageView.setImageResource(trending.getResourceId());
        holder.textView.setText(trending.getName());
    }

    @Override
    public int getItemCount() {
        return listTrending != null ? listTrending.size() : 0;
    }

    public class TrendingViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public TrendingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewTrending);
            textView = itemView.findViewById(R.id.textViewTrending);
        }
    }
}
