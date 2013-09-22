package com.example.homecontrol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.ListView;
import com.example.homecontrol.groups.GroupBaseAdapter;
import com.example.homecontrol.groups.GroupData;
import com.example.homecontrol.groups.GroupList;
import com.example.homecontrol.network.PacketSenderTask;
import com.example.homecontrol.network.UDPListener_Runable;
import com.example.homecontrol.outlet.OutletBaseAdapter;
import com.example.homecontrol.outlet.OutletData;
import com.example.homecontrol.outlet.OutletList;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private Button button;
    private InetAddress adr;
    private int port = 13337;

    ListView mOutletListView;
    Context mContext = MainActivity.this;
    ArrayList<GroupData> mOutletDataList;

    public MainActivity() throws UnknownHostException {
        //adr = InetAddress.getByName("10.0.0.3");
        Log.d("UDP", "MainActivity");
        adr = InetAddress.getByName("192.168.1.105");
        new Thread(new UDPListener_Runable()).start();
        Log.d("UDP", "Done...!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.outlet_list_view);

        mOutletListView = (ListView) findViewById(R.id.listView);

        mOutletDataList = GroupList.getInstance().getList();

        getDataInList();

        mOutletListView.setAdapter(new GroupBaseAdapter(mContext, mOutletDataList));
    }
    /** Called when the user clicks the Send button */
    public void onClick_Outlets(View view) {
        Intent intent = new Intent(this, OutletsListView_Activity.class);
        startActivity(intent);
    }

    private void getDataInList() {

        GroupList.getInstance().clear();
        GroupList.getInstance().add("Køkken");
        GroupList.getInstance().add("Bedroom");
        GroupList.getInstance().add("Livingroom");
    }
    /** Called when the user clicks the Send button */
    public void onClick_Blackout(View view) {
        //Intent intent = new Intent(this, OutletsListView_Activity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
       // startActivity(intent);
        Intent intent = new Intent(this, GroupListView_Activity.class);
        startActivity(intent);
    }

}