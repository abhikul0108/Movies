package com.example.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.example.movies.Movies;

//Search query for single movie request
public class MovieResponse {

    //finding the movie object (all data stored in results in json file )
    @SerializedName("results")
    @Expose
    private Movies movies;

    public Movies getMovies(){
        return movies;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movies=" + movies +
                '}';
    }
}
