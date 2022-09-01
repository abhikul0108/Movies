package com.example.movies;

import android.app.Application;

import androidx.room.Room;

//import com.example.movies.MovieDao;
//import com.example.movies.MoviesDb;
import com.example.movies.MovieDao;
import com.example.movies.MoviesDb;
import com.example.movies.WantDao;
import com.example.movies.WantDb;
import com.example.movies.WatchedDao;
import com.example.movies.WatchedDb;
import com.example.movies.Movies;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

// DatabaseModule will help hilt to provide  with the instance of MoviesDb, WatchedDb and WantDb databases.

//@Module and @InstallIn annotation tell hilt that this is a module and its required for application cope
@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {


    @Provides
    //@Singleton is used to have a single instance of this database over the whole app.
    @Singleton
    public static MoviesDb provideMoviesDb(Application application){
        return Room.databaseBuilder(application, MoviesDb.class,"FavoriteDB")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    //@Singleton is used to have a single instance of this database over the whole app.
    public static WatchedDb provideWatchedDb(Application application){
        return Room.databaseBuilder(application, WatchedDb.class,"WatchedDB")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }


    @Provides
    @Singleton
    public static WantDb provideWantDb(Application application){
        return Room.databaseBuilder(application, WantDb.class,"WantDB")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    public static MovieDao provideMovieDao(MoviesDb moviesDb){
        return moviesDb.movieDao();
    }

    @Provides
    @Singleton
    public static WatchedDao provideWatchedDao(WatchedDb watchedDb){
        return watchedDb.watchedDao();
    }

    @Provides
    @Singleton
    public static WantDao provideWantDao(WantDb wantDb){
        return wantDb.wantDao();
    }



}


