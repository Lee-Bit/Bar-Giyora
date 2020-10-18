package com.example.bargiyora.data.model;

public class Business {
    //don't forget to add point  and category if it necessary
    private String mId;
    private String mName;
    private String mContent;
    private String mPhone; // integer?

    public Business(String id, String name, String content, String phone){
        this.mId=id;
        this.mName=name;
        this.mPhone=phone;
        this.mContent=content;
    }

    public String getID(){return mId;}
    public String getName(){return mName;}
    public String getPhone(){return mPhone;}
    public String getContent(){return mContent;}

}
