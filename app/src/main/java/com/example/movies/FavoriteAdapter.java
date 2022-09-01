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
import com.example.movies.FavoriteFragment;
import com.example.movies.FavoriteFragmentDirections;
import com.example.movies.FragmentFirst;
import com.example.movies.FragmentFirstDirections;
import com.example.movies.FragmentSecondDirections;
import com.example.movies.MovieListFragmentDirections;
import com.example.movies.R;
import com.example.movies.ItemMovieBinding;
import com.example.movies.Favorite;
import com.example.movies.Movies;

import java.util.ArrayList;
import java.util.List;

import utils.Info;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>{

    private List<Favorite> favoriteList;
    private Context context;
    private ItemMovieBinding itemMovieBinding;

    public FavoriteAdapter(Context context, List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        itemMovieBinding = ItemMovieBinding.inflate(inflater,parent,false);
        return new FavoriteViewHolder(itemMovieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {

        holder.itemMovieBinding.movieItemTitle.setText(favoriteList.get(position).getTitle());

        Glide.with(context).
                load("https://image.tmdb.org/t/p/w500/" +favoriteList.get(position).getPoster_path()) //image url
                .into(holder.itemMovieBinding.movieItemPoster);


          //When the movie item is clicked
          holder.itemMovieBinding.movieItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoriteFragmentDirections.ActionFavoriteFragmentToMovieDetailFragment action =
                        FavoriteFragmentDirections.actionFavoriteFragmentToMovieDetailFragment(favoriteList.get(position).getId());
                Navigation.findNavController(v).navigate(action);

            }
        });





    }

    @Override
    public int getItemCount() {
        if (favoriteList!=null) {
            return favoriteList.size();
        }
        return 0;
    }


    public class FavoriteViewHolder extends RecyclerView.ViewHolder {

        public ItemMovieBinding itemMovieBinding;

        public FavoriteViewHolder(ItemMovieBinding itemMovieBinding) {
            super(itemMovieBinding.getRoot());
            this.itemMovieBinding = itemMovieBinding;
        }
    }

    public void setList(List<Favorite> favoriteList){
        this.favoriteList = favoriteList;
        notifyDataSetChanged();
    }

}
