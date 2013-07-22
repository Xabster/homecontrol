package com.example.homecontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.example.homecontrol.network.PacketSenderTask;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends Activity {
    private Button button;
    private InetAddress adr;
    private int port = 13337;

    public MainActivity() throws UnknownHostException {
        adr = InetAddress.getByName("10.0.0.3");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:ON:1";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:OFF:1";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:ON:2";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:OFF:2";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:ON:3";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:OFF:3";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    protected void onResume() {
//	datasource.open();
//	super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//	datasource.close();
//	super.onPause();
//    }
}