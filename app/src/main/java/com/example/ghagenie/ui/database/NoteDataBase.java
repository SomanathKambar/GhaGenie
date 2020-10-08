package com.example.ghagenie.ui.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.ghagenie.ui.model.NoteItem;

@TypeConverters(DateConverter.class)
@Database(entities = {NoteItem.class}, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    private static final String DATABASE_NAME = "note_database";
    private static volatile NoteDataBase sInstance;
    private static Object LOCK = new Object();
    public abstract NoteDao noteDao();

    public static NoteDataBase getsInstance(Context contetx) {
        if(sInstance == null){
            synchronized (LOCK){
                if(sInstance == null) {
                    sInstance =
                            Room.databaseBuilder(contetx.getApplicationContext(),NoteDataBase.class,
                                    DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
}
