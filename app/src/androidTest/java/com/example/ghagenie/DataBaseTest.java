package com.example.ghagenie;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.espresso.internal.inject.InstrumentationContext;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.ghagenie.ui.database.NoteDao;
import com.example.ghagenie.ui.database.NoteDataBase;
import com.example.ghagenie.ui.main.NoteRepo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DataBaseTest {
    public static final String TAG = "AndroidJunit";
    private NoteDataBase mDB;
    private NoteDao mDao;

    @Before
    public void CreateDB(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        mDB =
                Room.inMemoryDatabaseBuilder(context,NoteDataBase.class).build();
        mDao = mDB.noteDao();
        Log.i(TAG,"createDB");
    }

    @After
    public void closeDB(){
        mDB.close();
        Log.i(TAG,"close DB");
    }

    @Test
    public void createAndTestNotes(){
        mDao.insertAll(NoteRepo.getInstance(
                InstrumentationRegistry.getInstrumentation()
                .getTargetContext()).getNoteList());
    }
}
