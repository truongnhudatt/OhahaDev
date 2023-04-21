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
import com.example.ohana_clone.models.Room;

import java.util.List;

public class RoomViewAdapter extends RecyclerView.Adapter<RoomViewAdapter.RoomViewHolder> {

    private Context context;
    private List<Room> listRoom;
    private List<Room> listRoomOld;

    public RoomViewAdapter(Context context, List<Room> listRoom) {
        this.context = context;
        this.listRoom = listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_item, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = listRoom.get(position);
        if(room == null){
            return;
        }
        holder.imageRoomView.setImageResource(room.getResourceId());
        holder.txtTieuDe.setText(room.getTieude());
        holder.txtGiaPhong.setText(room.getGia() + " triệu VND/phòng");
        holder.txtSoNguoi.setText("TÌM NGƯỜI THUÊ. " + room.getSoluong());
        holder.txtDiaChi.setText(room.getDiachi());
        holder.txtQuan.setText(room.getDiachi());
    }

    @Override
    public int getItemCount() {
        return listRoom != null ? listRoom.size() : 0;
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder{

        private TextView txtSoNguoi;
        private TextView txtGiaPhong;
        private TextView txtTieuDe;
        private TextView txtDiaChi;
        private TextView txtQuan;
        private ImageView imageRoomView;
        private ImageView addToFavorite;
        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSoNguoi = itemView.findViewById(R.id.txtSoNguoi);
            txtGiaPhong = itemView.findViewById(R.id.txtGiaPhong);
            txtTieuDe = itemView.findViewById(R.id.txtTieuDe);
            txtDiaChi = itemView.findViewById(R.id.txtDiaChi);
            txtQuan = itemView.findViewById(R.id.txtQuan);
            imageRoomView = itemView.findViewById(R.id.imageRoomView);
            addToFavorite = itemView.findViewById(R.id.addToFavorite);
        }
    }
}
