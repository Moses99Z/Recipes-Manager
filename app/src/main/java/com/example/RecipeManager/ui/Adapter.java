package com.example.RecipeManager.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.RecipeManager.R;
import com.example.RecipeManager.data.Data;
import com.example.RecipeManager.data.RoomDB;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<Data> dataList;
    View view;

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    Adapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.dish_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String serves = "Serves : " + dataList.get(position).getServes();
        String difficulty = "Difficulty : " + dataList.get(position).getDifficulty();
        Uri image = Uri.parse(dataList.get(position).getImageUri());

        holder.title.setText(dataList.get(position).getTitle());
        holder.serves.setText(serves);
        holder.difficulty.setText(difficulty);
        holder.dishImage.setImageURI(image);


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomDB db = RoomDB.getInstance(view.getContext());
                db.DataDao().delete(dataList.get(position));
                dataList.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditDish.class);
                intent.putExtra("data", dataList.get(position));
                v.getContext().startActivity(intent);

            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), showDish.class);
                intent.putExtra("data", dataList.get(position));
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, serves, difficulty;
        ImageView dishImage;

        CardView cardView;

        Button delete;
        Button edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dishImage = itemView.findViewById(R.id.dishImage);
            title = itemView.findViewById(R.id.dishTitle);
            serves = itemView.findViewById(R.id.dishServes);
            difficulty = itemView.findViewById(R.id.dishDifficulty);
            delete = itemView.findViewById(R.id.deleteDishBtn);
            edit = itemView.findViewById(R.id.editDishBtn);
            cardView = itemView.findViewById(R.id.dishCard);
        }
    }
}
