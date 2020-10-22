package com.example.bargiyora.data.model;


public class Messages {
    // don't forget to add publisher
    private String mID;
    private String mTitle;
    private String mContent;
    private String mDate;
    private String mTime;

    public Messages(String id, String title, String content, String date, String time){
        this.mID=id;
        this.mTitle=title;
        this.mContent=content;
        this.mDate=date;
        this.mTime=time;
    }

    public String getID(){return mID;}
    public String getTitle(){return mTitle;}
    public String getContent(){return mContent;}
    public String getDate(){return mDate;}
    public String getTime(){return mTime;}
}
