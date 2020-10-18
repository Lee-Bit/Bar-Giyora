package com.example.bargiyora.data.model;

public class DeliveryAndSale {
    //don't forget to add price, date and publisher.
    private String mId;
    private String mType;

    public DeliveryAndSale(String id, String type){
        this.mId=id;
        this.mType=type;
    }

    public String getID(){return mId;}

    public String getType(){return mType;}

}
