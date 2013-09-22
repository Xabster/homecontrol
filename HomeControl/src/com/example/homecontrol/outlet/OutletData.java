package com.example.homecontrol.outlet;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 19-09-13
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class OutletData {
    private String mName;
    private int mAddress;
    private int mType;

    public int getType() {
        return mType;
    }

    public void setType(int mType) {
        this.mType = mType;
    }


    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getAddress() {
        return mAddress;
    }

    public void setAddress(int mAddress) {
        this.mAddress = mAddress;
    }
}
