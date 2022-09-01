package com.example.movies;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.Favorite;
import com.example.movies.RepositoryMovie;

import java.util.List;

public class FavoriteViewModel extends ViewModel {
    private RepositoryMovie repository;
    private LiveData<List<Favorite>> favoriteMoviesList;

    @ViewModelInject
    public FavoriteViewModel(RepositoryMovie repository) {
        this.repository = repository;
        favoriteMoviesList = repository.getFavoriteList();
    }

    public LiveData<List<Favorite>> getFavoriteListMovieList() {
        return favoriteMoviesList;
    }

    public void deleteAll(){
        repository.deleteAll();
    }

}
