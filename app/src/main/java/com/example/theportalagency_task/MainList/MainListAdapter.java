package com.example.theportalagency_task.MainList;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.theportalagency_task.Models.MovieModel;
import com.example.theportalagency_task.MovieProfile.ProfileActivity;
import com.example.theportalagency_task.R;

import java.util.ArrayList;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder>  {



    private LayoutInflater mInflater;
    ArrayList<MovieModel> movieModels;
    Context context;

    public MainListAdapter(Context context, ArrayList<MovieModel> movieModels) {
        LayoutInflater.from(context);
        this.context = context;
        this.movieModels = movieModels;
    }
    @NonNull
    @Override
    public MainListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        return new MainListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainListAdapter.ViewHolder viewHolder,final int i) {

        viewHolder.title.setText(movieModels.get(i).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+movieModels.get(i).getPoster_path()).into(viewHolder.imageView);

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent(movieModels.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }
    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout layout;
        ImageView imageView;
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.title);
            layout = itemView.findViewById(R.id.layout);

        }


    }
    public void sendIntent(MovieModel movieModel)
    {
        Intent i = new Intent(context,ProfileActivity.class);
        i.putExtra("movie",movieModel);
        context.startActivity(i);
    }
}
