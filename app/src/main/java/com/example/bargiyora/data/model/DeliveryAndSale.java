package com.example.bargiyora.data.model;

import java.util.Date;

public class DeliveryAndSale {
    //don't forget to add publisher.
    private String mId;
    private boolean mType;
    private String mPrice;
    private String mDate;
    private String mName;
    private String mContent;

    public DeliveryAndSale(String id, boolean type, String price, String date, String name, String content){
        this.mId=id;
        this.mType=type;
        this.mPrice=price;
        this.mDate=date;
        this.mName=name;
        this.mContent=content;
    }

    public String getID(){return mId;}
    public boolean getType(){return mType;}
    public String getPrice(){return mPrice;}
    public String getDate(){return mDate;}
    public String getName(){return mName;}
    public String getContent(){return mContent;}
}
