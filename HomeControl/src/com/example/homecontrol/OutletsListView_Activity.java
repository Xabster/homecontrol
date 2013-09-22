package com.example.homecontrol;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.example.homecontrol.outlet.OutletBaseAdapter;
import com.example.homecontrol.outlet.OutletData;
import com.example.homecontrol.outlet.OutletList;

import java.net.UnknownHostException;
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
    ArrayList<OutletData> mOutletDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.outlet_list_view);

        mOutletListView = (ListView) findViewById(R.id.listView);

        mOutletDataList = OutletList.getInstance().getList();

        getDataInList();

        mOutletListView.setAdapter(new OutletBaseAdapter(mContext, mOutletDataList));
    }

    private void getDataInList() {

        OutletList.getInstance().add("Bedroom", 8, 1);

        OutletList.getInstance().add("Living Room", 16, 0);

        OutletList.getInstance().add("New Type", 16, 1);
    }
}
