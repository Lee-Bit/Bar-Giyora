package com.example.bargiyora.model;

import com.google.gson.annotations.SerializedName;

public class DeliveryAndSale {
    @SerializedName("id")
    private String mId;
    @SerializedName("type")
    private boolean mType;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("date")
    private String mDate;
    @SerializedName("name")
    private String mName;
    @SerializedName("details")
    private String mContent;
    @SerializedName("firstName")
    private String mPublisherFirstName;
    @SerializedName("lastName")
    private String mPublisherLastName;
    @SerializedName("phone")
    private String mPublisherPhone;

    public DeliveryAndSale(String id, boolean type, String price, String date, String name, String content,
                           String publisherFirstName, String publisherLastName, String publisherPhone){
        this.mId=id;
        this.mType=type;
        this.mPrice=price;
        this.mDate=date;
        this.mName=name;
        this.mContent=content;
        this.mPublisherFirstName=publisherFirstName;
        this.mPublisherLastName=publisherLastName;
        this.mPublisherPhone=publisherPhone;
    }

    public String getID(){return mId;}
    public boolean getType(){return mType;}
    public String getPrice(){return mPrice;}
    public String getDate(){return mDate;}
    public String getName(){return mName;}
    public String getContent(){return mContent;}
    public String getPublisherPhone(){return mPublisherPhone;}
    public String getFullName(){return mPublisherFirstName+mPublisherLastName;}
}
