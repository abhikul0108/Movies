package com.example.movies;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.movies.FavoriteFragmentDirections;
import com.example.movies.FragmentFirst;
import com.example.movies.FragmentFirstDirections;
import com.example.movies.FragmentSecondDirections;
import com.example.movies.MovieListFragmentDirections;
import com.example.movies.R;
import com.example.movies.WatchedFragmentDirections;
import com.example.movies.databinding.ItemMovieBinding;
import com.example.movies.Watched;
import com.example.movies.Movies;

import java.util.ArrayList;
import java.util.List;

import utils.Info;

public class WatchedAdapter extends RecyclerView.Adapter<WatchedAdapter.WatchedViewHolder>{


    private List<Watched> watchedList;
    private Context context;
    private ItemMovieBinding itemMovieBinding;

    public WatchedAdapter(Context context, List<Watched> watchedList) {
        this.watchedList = watchedList;
        this.context = context;
    }

    @NonNull
    @Override
    public WatchedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        itemMovieBinding = ItemMovieBinding.inflate(inflater,parent,false);
        return new WatchedViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchedViewHolder holder, int position) {

        holder.itemMovieBinding.movieItemTitle.setText(watchedList.get(position).getTitle());

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/" +watchedList.get(position).getPoster_path()) //image url
                .into(holder.itemMovieBinding.movieItemPoster);


        //When the movie item is clicked
        holder.itemMovieBinding.movieItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WatchedFragmentDirections.ActionWatchedFragmentToMovieDetailFragment action =
                        WatchedFragmentDirections.actionWatchedFragmentToMovieDetailFragment(watchedList.get(position).getId());
                Navigation.findNavController(v).navigate(action);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (watchedList!=null) {
            return watchedList.size();
        }
        return 0;
    }


    public class WatchedViewHolder extends RecyclerView.ViewHolder {

        public ItemMovieBinding itemMovieBinding;

        public WatchedViewHolder(ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.getRoot());
            this.itemMovieBinding = itemMovieBinding;
        }
    }

    public void setList(List<Watched> watchedList){
        this.watchedList = watchedList;
        notifyDataSetChanged();
    }

}
