package com.example.bargiyora.model;

import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("id")
    private String mId;
    @SerializedName("status")
    private boolean mStatus;
    @SerializedName("content")
    private String mContent;
    @SerializedName("publishDate")
    private String mPublishDate;
    @SerializedName("publishTime")
    private String mPublishTime;
    @SerializedName("finishDate")
    private String mFinishDate;
    @SerializedName("finishTime")
    private String mFinishTime;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("publisher")
    private String mPublisherId;
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("lastName")
    private String mLastName;

    public Request(String id, boolean status, String content, String publishDate,
                   String publishTime, String finishDate, String finishTime, String category,
                   String publisherId, String firsName, String lastName) {
        this.mId = id;
        this.mStatus = status;
        this.mContent = content;
        this.mPublishDate = publishDate;
        this.mPublishTime = publishTime;
        this.mFinishDate = finishDate;
        this.mFinishTime = finishTime;
        this.mCategory = category;
        this.mPublisherId = publisherId;
        this.mFirstName = firsName;
        this.mLastName = lastName;
    }

    public String getId() {
        return mId;
    }

    public boolean getStatus() {
        return mStatus;
    }

    public String getContent() {
        return mContent;
    }

    public String getPublishDate() {
        return mPublishDate;
    }

    public String getPublishTime() {
        return mPublishTime;
    }

    public String getFinishDate() {
        return mFinishDate;
    }

    public String getFinishTime() {
        return mFinishTime;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getPublisherId() {
        return mPublisherId;
    }

    public String getFullName() {
        return mFirstName +" "+ mLastName;
    }
}
