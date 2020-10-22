package com.example.bargiyora.model;

public class DataManager {

    private static DataManager mDataManager;

    private User mUser;

    private DataManager() {

    }

    public static DataManager getInstance() {
        if(mDataManager == null) {
            mDataManager = new DataManager();
        }

        return mDataManager;
    }


    public User getUser() {
        return mUser;
    }

    public void setUser(User mUser) {
        this.mUser = mUser;
    }
}
