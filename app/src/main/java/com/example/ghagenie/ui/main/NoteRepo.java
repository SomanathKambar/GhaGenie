package com.example.ghagenie.ui.main;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.ghagenie.ui.database.NoteDao;
import com.example.ghagenie.ui.database.NoteDataBase;
import com.example.ghagenie.ui.model.NoteItem;

import java.util.ArrayList;
import java.util.List;

public class NoteRepo  implements NoteDao{
    private static NoteRepo sInstance;
    private MutableLiveData<List<NoteItem>> mNoteListForTesting;
    private static NoteDao mNoteDao;
    private static NoteDataBase mDB;

    public static NoteRepo getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NoteRepo(context);
        }
        return sInstance;
    }

    private NoteRepo(Context context){
        mDB = Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,
                "note_database").allowMainThreadQueries().build();
    }
    @VisibleForTesting
    public MutableLiveData<List<NoteItem>> getListForTesting(){
        if(mNoteListForTesting == null){
            mNoteListForTesting = new MutableLiveData<>();
            addNotes();
        }
        return mNoteListForTesting;
    }

    public List<NoteItem> getNoteList() {
        List<NoteItem> noteItems = new ArrayList<>();
        noteItems.add(new NoteItem("Note1","Description 1"));
        noteItems.add(new NoteItem("Note2","Description 2"));
        noteItems.add(new NoteItem("Note3","Description 3"));
        noteItems.add(new NoteItem("Note4","Description 4"));
        noteItems.add(new NoteItem("Note5","Description 5"));
        return noteItems;
    }

    public void addNotes(){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mNoteListForTesting.postValue(getNoteList());
            }
        },1000);
    }


    @Override
    public void insertNote(NoteItem item) {
        mDB.noteDao().insertNote(item);
    }

    @Override
    public void insertAll(List<NoteItem> items) {
        mNoteDao.insertAll(items);
    }

    @Override
    public LiveData<List<NoteItem>> getAllNotes() {
        return mDB.noteDao().getAllNotes();
    }
}
