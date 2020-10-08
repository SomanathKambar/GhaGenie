package com.example.ghagenie.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ghagenie.ui.model.NoteItem;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private NoteRepo mNoteRepo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mNoteRepo = NoteRepo.getInstance(application);
    }


    @VisibleForTesting
    public MutableLiveData<List<NoteItem>> getNotesForTesting(){
        return mNoteRepo.getListForTesting();
    }

    @VisibleForTesting
    public void addItemsForTest(){
        NoteRepo.getInstance(getApplication().getApplicationContext()).addNotes();
    }

}