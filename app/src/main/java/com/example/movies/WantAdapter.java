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
import com.example.movies.WantToWatchFragmentDirections;
import com.example.movies.ItemMovieBinding;
import com.example.movies.Want;
import com.example.movies.Watched;
import com.example.movies.Movies;

import java.util.ArrayList;
import java.util.List;

import utils.Info;

public class WantAdapter extends RecyclerView.Adapter<WantAdapter.WantViewHolder>{

    private List<Want> wantList;
    private Context context;
    private ItemMovieBinding itemMovieBinding;

    public WantAdapter(Context context, List<Want> wantList) {
        this.wantList = wantList;
        this.context = context;
    }

    @NonNull
    @Override
    public WantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        itemMovieBinding = ItemMovieBinding.inflate(inflater,parent,false);
        return new WantViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WantViewHolder holder, int position) {

        holder.itemMovieBinding.movieItemTitle.setText(wantList.get(position).getTitle());

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/" +wantList.get(position).getPoster_path()) //image url
                .into(holder.itemMovieBinding.movieItemPoster);

        //When the movie item is clicked
        holder.itemMovieBinding.movieItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WantToWatchFragmentDirections.ActionWantToWatchFragmentToMovieDetailFragment action =
                        WantToWatchFragmentDirections.actionWantToWatchFragmentToMovieDetailFragment(wantList.get(position).getId());
                Navigation.findNavController(v).navigate(action);

            }
        });


    }

    @Override
    public int getItemCount() {
        if (wantList!=null) {
            return wantList.size();
        }
        return 0;
    }


    public class WantViewHolder extends RecyclerView.ViewHolder {

        public ItemMovieBinding itemMovieBinding;

        public WantViewHolder(ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.getRoot());
            this.itemMovieBinding = itemMovieBinding;
        }
    }

    public void setList(List<Want> wantList){
        this.wantList = wantList;
        notifyDataSetChanged();
    }

}
