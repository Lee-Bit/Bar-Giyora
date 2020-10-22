package com.example.bargiyora.model;


import com.google.gson.annotations.SerializedName;

public class Messages {
    //TODO don't forget to add publisher
    @SerializedName("id")
    private String mID;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("content")
    private String mContent;
    @SerializedName("date")
    private String mDate;
    @SerializedName("time")
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
