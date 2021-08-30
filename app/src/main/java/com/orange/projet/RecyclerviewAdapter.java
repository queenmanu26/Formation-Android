package com.orange.projet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder>{

    List<Movie> movieList;
    Context context;

    public RecyclerviewAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_movie, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tv_movName.setText(movieList.get(position).getNom());
        holder.tv_movDatePublication.setText(String.valueOf(movieList.get(position).getDatePublication()));
        Glide.with(this.context).load(movieList.get(position).getImageURL()).into(holder.iv_movPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddEdit.class);
                intent.putExtra("id", movieList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_movPic;
        TextView tv_movName;
        TextView tv_movDatePublication;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_movPic = itemView.findViewById(R.id.iv_moviePicture);
            tv_movName = itemView.findViewById(R.id.tv_movieName);
            tv_movDatePublication = itemView.findViewById(R.id.tv_datePublication);
            parentLayout = itemView.findViewById(R.id.oneLineMovieLayout);
        }
    }
}
