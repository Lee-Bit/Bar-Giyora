package com.example.bargiyora.data.model;


public class Ride {
    //don't forget to add passenger, driver
    private int mRadius;
    private String mDate;
    private String mTime;

    public Ride(int radius, String date, String time){
        this.mRadius=radius;
        this.mDate=date;
        this.mTime=time;
    }

    public int getRadius(){return mRadius;}

    public String getDate(){return mDate;}

    public String getTime(){return mTime;}
}
