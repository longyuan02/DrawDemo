package com.example.kf.thetest.sqlite;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kf on 2018/4/8.
 */

public class PlatformMessage implements Parcelable {
    private String platformId;
    private String userName;
    private String password;
    private String saveTime;

    protected PlatformMessage(Parcel in) {
        platformId = in.readString();
        userName = in.readString();
        password = in.readString();
        saveTime = in.readString();
    }

    public PlatformMessage() {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(platformId);
        dest.writeString(userName);
        dest.writeString(password);
        dest.writeString(saveTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlatformMessage> CREATOR = new Creator<PlatformMessage>() {
        @Override
        public PlatformMessage createFromParcel(Parcel in) {
            return new PlatformMessage(in);
        }

        @Override
        public PlatformMessage[] newArray(int size) {
            return new PlatformMessage[size];
        }
    };

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }
}
