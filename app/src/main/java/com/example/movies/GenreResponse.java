package com.example.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.example.movies.Genres;
import com.example.movies.Movies;

import java.util.List;

public class GenreResponse {

    @SerializedName("results")
    @Expose()
    private List<Genres> genres;

    public List<Genres> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "GenreResponse{" +
                "genres=" + genres +
                '}';
    }
}
