package com.example.bargiyora.model;

public class BusinessCategory {

    private String mName;
    private String mId;

    public BusinessCategory(String id, String name){
        this.mId = id;
        this.mName = name;
    }

    public String getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
