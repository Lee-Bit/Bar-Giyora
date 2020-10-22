package com.example.bargiyora.data.model;

public class Site {
    private String mId;
    private String mName;
    private String mPhone;
    private String mCategory;
    private String mContent;
    private String mAddress;

    public Site(String id, String name, String phone, String category, String content, String address){
        this.mId=id;
        this.mName=name;
        this.mPhone=phone;
        this.mCategory=category;
        this.mContent=content;
        this.mAddress=address;

    }

    public String getId(){return mId;}

    public String getName(){return mName;}

    public String getPhone(){return mPhone;}

    public String getCategory(){return mCategory;}

    public String getContent(){return mContent;}

    public String getAddress(){return  mAddress;}
}
