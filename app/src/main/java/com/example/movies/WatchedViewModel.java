package com.example.movies;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.Favorite;
import com.example.movies.Watched;
import com.example.movies.RepositoryMovie;

import java.util.List;

public class WatchedViewModel extends ViewModel {
    private RepositoryMovie repository;
    private LiveData<List<Watched>> watchedMoviesList;

    @ViewModelInject
    public WatchedViewModel(RepositoryMovie repository) {
        this.repository = repository;
        watchedMoviesList = repository.getWatchedList();
    }

    public LiveData<List<Watched>> getWatchedListMovieList() {
        return watchedMoviesList;
    }

    public void deleteAllWatched(){
        repository.deleteAllWatched();
    }

}
