package com.example.sony.roomwordsample.database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWords;

    //Constructor
    public Word(@NonNull String words) {
        this.mWords = words;
    }


    public String getWords() {
        return mWords;
    }

    public void setWords(@NonNull String mWords) {
        this.mWords = mWords;
    }







}
