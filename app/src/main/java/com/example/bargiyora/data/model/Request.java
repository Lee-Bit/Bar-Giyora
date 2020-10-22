package com.example.bargiyora.data.model;

import java.util.Date;

public class Request {
    //don't forget to add type, publisher
    private String mId;
    private boolean mStatus;
    private String mContent;
    private String mPublishDate;
    private String mPublishTime;
    private String mFinishDate;
    private String mFinishTime;

    public Request(String id, boolean status, String content, String publishDate, String publishTime, String finishDate, String finishTime){
        this.mId=id;
        this.mStatus=status;
        this.mContent=content;
        this.mPublishDate=publishDate;
        this.mPublishTime=publishTime;
        this.mFinishDate=finishDate;
        this.mFinishTime=finishTime;
    }

    public String getId(){return mId;}

    public boolean getStatus(){return mStatus;}

    public String getContent(){return mContent;}

    public String getPublishDate(){return mPublishDate;}

    public String getPublishTime(){return mPublishTime;}

    public String getFinishDate(){return mFinishDate;}

    public String getFinishTime(){return mFinishTime;}
}
