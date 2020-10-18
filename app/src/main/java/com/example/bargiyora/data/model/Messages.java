package com.example.bargiyora.data.model;


public class Messages {
    // don't forget to add time, date and publisher
    private String mID;
    private String mTitle;
    private String mContent;

    public Messages(String id, String title, String content){
        this.mID=id;
        this.mTitle=title;
        this.mContent=content;
    }

    public String getID(){return mID;}

    public String getTitle(){return mTitle;}

    public String getContent(){return mContent;}
}
