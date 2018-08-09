package com.example.sony.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.sony.roomwordsample.database.Word;
import com.example.sony.roomwordsample.database.WordRepository;

import java.util.List;


public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;


    //Constructor
    public WordViewModel(@NonNull Application application) {
        super(application);

        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }


    public void insert(Word word) {
        mRepository.insert(word);
    }
}
