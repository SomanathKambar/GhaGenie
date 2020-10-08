package com.example.ghagenie.ui.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Room;

import com.example.ghagenie.ui.model.NoteItem;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNote(NoteItem item);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<NoteItem> items);

    @Query("SELECT * FROM note_table")
    public LiveData<List<NoteItem>> getAllNotes();
}
