package com.example.wayupbeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView boulderName, boulderGrade;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.list_image);
            imageView.setOnClickListener(this);
            boulderName = itemView.findViewById(R.id.list_name);
            boulderGrade = itemView.findViewById(R.id.list_grade);
        }
        @Override
        public void onClick(View view) {

            int position = this.getAdapterPosition();
            Model contact = mList.get(position);
            String name = contact.getBoulderName();
            Toast.makeText(context, "The position is " + String.valueOf(position) +
                    " Name: " + name, Toast.LENGTH_SHORT).show();


        }
    }
}
