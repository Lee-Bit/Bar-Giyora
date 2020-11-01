package com.example.bargiyora.model;


import com.google.gson.annotations.SerializedName;

public class Messages {

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
    @SerializedName("publisher")
    private String mPublisherPhone;
    @SerializedName("firstName")
    private String mPublisherFirstName;
    @SerializedName("lastName")
    private String mPublisherLastName;

    public Messages(String id, String title, String content, String date, String time,
                    String publisherPhone, String publisherFirstName, String publisherLastName) {
        this.mID = id;
        this.mTitle = title;
        this.mContent = content;
        this.mDate = date;
        this.mTime = time;
        this.mPublisherPhone = publisherPhone;
        this.mPublisherFirstName = publisherFirstName;
        this.mPublisherLastName = publisherLastName;
    }

    public String getId() {
        return mID;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public String getPublisherPhone() {
        return mPublisherPhone;
    }

    //    public String getPublisherLastName(){return mPublisherLastName;}
//    public String getPublisherFirstName(){return mPublisherFirstName;}
    public String getFullName() {
        return mPublisherFirstName +" "+ mPublisherLastName;
    }
}
