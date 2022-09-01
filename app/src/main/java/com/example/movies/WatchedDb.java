package com.example.movies;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.movies.Movies;

//abstract databasae class for storing watched movies


//The class annotated with a @Database annotation that includes an entities array that lists all of the data entities associated with the database.
@Database(entities = {Watched.class},version = 5,exportSchema = false)
// abstract method of WatchedDao return type
public abstract class WatchedDb extends RoomDatabase{
    public abstract WatchedDao watchedDao();
}

