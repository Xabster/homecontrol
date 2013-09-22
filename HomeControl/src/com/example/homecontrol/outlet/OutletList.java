package com.example.homecontrol.outlet;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 20-09-13
 * Time: 00:29
 * To change this template use File | Settings | File Templates.
 */
public class OutletList {

    // declare singleton instance
    protected static OutletList mInstance;

    ArrayList<OutletData> mList = new ArrayList<OutletData>();

    // get instance of class - singleton
    public static OutletList getInstance(){
        if (mInstance == null){
            mInstance = new OutletList();
        }
        return mInstance;
    }

    public void add(String mName,  int mAddress, int type)
    {
        OutletData myOutletData = new OutletData();
        myOutletData.setName(mName);
        myOutletData.setAddress(mAddress);
        myOutletData.setType(type);
        mList.add(myOutletData);
    }

    public ArrayList<OutletData> getList() {
        return mList;
    }
}
