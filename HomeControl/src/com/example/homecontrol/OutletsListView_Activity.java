package com.example.homecontrol;

import android.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.example.homecontrol.outlets.OutletsBaseAdapter;
import com.example.homecontrol.outlets.OutletsData;
import com.example.homecontrol.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 19-09-13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class OutletsListView_Activity extends Activity {

    ListView mOutletListView;
    Context mContext = OutletsListView_Activity.this;
    ArrayList<OutletsData> mOutletDataList = new ArrayList<OutletsData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.outlet_list_view);

        mOutletListView = (ListView) findViewById(R.id.listView);

        getDataInList();
        mOutletListView.setAdapter(new OutletsBaseAdapter(mContext, mOutletDataList));

    }

    private void getDataInList() {

        OutletsData myOutletData = new OutletsData();
        myOutletData.setName("Outlet 1");
        myOutletData.setAddress(10);
        mOutletDataList.add(myOutletData);

        myOutletData = new OutletsData();
        myOutletData.setName("Outlet 2");
        myOutletData.setAddress(20);
        mOutletDataList.add(myOutletData);
    }
}
