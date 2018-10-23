package com.example.kf.thetest.drawview;

import android.os.Parcel;
import android.os.Parcelable;

public class DistancePointData implements Parcelable {
    private float x;
    private float y;

    public DistancePointData() {

    }

    public DistancePointData(float inputX, float inputY) {
        x = inputX;
        y = inputY;
    }

    protected DistancePointData(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(x);
        dest.writeFloat(y);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DistancePointData> CREATOR = new Creator<DistancePointData>() {
        @Override
        public DistancePointData createFromParcel(Parcel in) {
            return new DistancePointData(in);
        }

        @Override
        public DistancePointData[] newArray(int size) {
            return new DistancePointData[size];
        }
    };

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
