package com.example.ahmed.animationlikefacebookusingshimmer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ahmed on 3/18/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.myViewHolder> {
    Context context;
    List<Movie> movieList;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        final Movie movie = movieList.get(position);

        holder.name.setText(movie.getName());
        holder.chef.setText("By " + movie.getChef());
        holder.description.setText(movie.getDescription());
        holder.price.setText("Price: ₹" + movie.getPrice());
        holder.timestamp.setText(movie.getTimestamp());

        Glide.with(context).load(movie.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, price, chef, timestamp;
        ImageView thumbnail;

        public myViewHolder(View view) {
            super(view);

            name = view.findViewById(R.id.name);
            chef = view.findViewById(R.id.chef);
            description = view.findViewById(R.id.description);
            price = view.findViewById(R.id.price);
            timestamp = view.findViewById(R.id.timestamp);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }
}
