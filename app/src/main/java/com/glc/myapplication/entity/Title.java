package com.glc.myapplication.entity;

import android.database.sqlite.SQLiteDatabase;

import com.glc.myapplication.db.MyHelper;

import static com.superrtc.mediamanager.EMediaManager.getContext;

public class Title {


    public Title( String title, String time, String content) {
        this.title = title;
        this.time = time;
        this.content = content;
    }

    public Title(int id, String title, String time, String content) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.content = content;
    }

    /**
     * id : 1
     * title : niha
     * time : 2019-10-23
     * content : 就爱过后
     */

    private int id;
    private String title;
    private String time;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
