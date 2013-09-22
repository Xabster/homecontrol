package com.example.homecontrol.groups;

import com.example.homecontrol.outlet.OutletData;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 20-09-13
 * Time: 00:29
 * To change this template use File | Settings | File Templates.
 */
public class GroupList {

    // declare singleton instance
    protected static GroupList mInstance;

    ArrayList<GroupData> mList = new ArrayList<GroupData>();

    // get instance of class - singleton
    public static GroupList getInstance(){
        if (mInstance == null){
            mInstance = new GroupList();
        }
        return mInstance;
    }

    public void add(String mName)
    {
        GroupData myGroupData = new GroupData(mName);
        mList.add(myGroupData);
    }

    public void clear()
    {
        mList.clear();
    }

    public ArrayList<GroupData> getList() {
        return mList;
    }
}
