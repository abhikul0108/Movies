package com.example.movies;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movies.Favorite;
import com.example.movies.Want;
import com.example.movies.Watched;
import com.example.movies.RepositoryMovie;

import java.util.List;

public class WantViewModel extends ViewModel {

    private RepositoryMovie repository;
    private LiveData<List<Want>> wantMoviesList;

    @ViewModelInject
    public WantViewModel(RepositoryMovie repository) {
        this.repository = repository;
        wantMoviesList = repository.getWantList();
    }

    public LiveData<List<Want>> getWantListMovieList() {
        return wantMoviesList;
    }

    public void deleteAllWant(){
        repository.deleteAllWant();
    }

}
