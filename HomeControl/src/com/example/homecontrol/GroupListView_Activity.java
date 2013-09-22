package com.example.homecontrol;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import com.example.homecontrol.groups.GroupBaseAdapter;
import com.example.homecontrol.groups.GroupData;
import com.example.homecontrol.groups.GroupList;
import com.example.homecontrol.outlet.OutletBaseAdapter;
import com.example.homecontrol.outlet.OutletData;
import com.example.homecontrol.outlet.OutletList;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 19-09-13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class GroupListView_Activity extends Activity {

    ListView mOutletListView;
    Context mContext = GroupListView_Activity.this;
    ArrayList<GroupData> mOutletDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.outlet_list_view);

        mOutletListView = (ListView) findViewById(R.id.listView);

        mOutletDataList = GroupList.getInstance().getList();

        getDataInList();

        mOutletListView.setAdapter(new GroupBaseAdapter(mContext, mOutletDataList));
    }

    private void getDataInList() {

        GroupList.getInstance().clear();
        GroupList.getInstance().add("Køkken");
        GroupList.getInstance().add("Bedroom");
        GroupList.getInstance().add("Livingroom");
    }
}
