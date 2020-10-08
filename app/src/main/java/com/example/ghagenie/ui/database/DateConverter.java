package com.example.ghagenie.ui.database;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static long getTime(Date date){
        return date.getTime();
    }

    @TypeConverter
    public static Date getDate(long timeStamp){
        return new Date(timeStamp);
    }
}
