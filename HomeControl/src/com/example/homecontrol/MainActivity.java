package com.example.homecontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.homecontrol.network.PacketSenderTask;
import com.example.homecontrol.network.UDPListener_Runable;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends Activity {
    private Button button;
    private InetAddress adr;
    private int port = 13337;

    public MainActivity() throws UnknownHostException {
        //adr = InetAddress.getByName("10.0.0.3");
        Log.d("UDP", "MainActivity");
        adr = InetAddress.getByName("192.168.1.105");
        new Thread(new UDPListener_Runable()).start();
        Log.d("UDP", "Done...!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
    /** Called when the user clicks the Send button */
    public void onClick_Outlets(View view) {
        Intent intent = new Intent(this, OutletsListView_Activity.class);
        startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}