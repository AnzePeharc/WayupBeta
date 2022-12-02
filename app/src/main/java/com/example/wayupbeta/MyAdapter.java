package com.example.wayupbeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mList;
    private Context context;

    public MyAdapter(Context context , ArrayList<Model> mList){

        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_listview_item , parent ,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // insert image into holderView
        Glide.with(context).load(mList.get(position).getImageUrl()).into(holder.imageView);
        // insert boulder name into holderView
        holder.boulderName.setText(mList.get(position).getBoulderName());
        // insert boulder grade into holderView
        holder.boulderGrade.setText(mList.get(position).getBoulderGrade());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView boulderName, boulderGrade;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.list_image);
            boulderName = itemView.findViewById(R.id.list_name);
            boulderGrade = itemView.findViewById(R.id.list_grade);
        }
    }
}
