package com.example.ghagenie.ui.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "note_table")
public class NoteItem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String heading;
    private String description;

    private Date createdDate;

    public NoteItem(String heading, String description) {
        this.heading = heading;
        this.description = description;
        createdDate = new Date();
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public int getId() {
        return id;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(int id) {
        this.id = id;
    }
}
