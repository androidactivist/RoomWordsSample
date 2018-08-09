package com.example.sony.roomwordsample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import java.util.concurrent.CopyOnWriteArrayList;

@Database(entities = {Word.class},version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase{

    private static final String LOG_TAG = WordRoomDatabase.class.getSimpleName();

    private static WordRoomDatabase isInstance;
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "word_database";



    public static WordRoomDatabase getInstance(final Context context){
        if(isInstance == null){
            synchronized (LOCK){
                Log.d(LOG_TAG,"Creating new database instance");
                //Create Database here
                    isInstance = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class,
                            DATABASE_NAME)
                            .build();
                }
            }
        Log.d(LOG_TAG,"Getting the database instance");
        return isInstance;

    }

    public abstract WordDao wordDao();

}
