package com.example.homecontrol;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.example.homecontrol.network.PacketSenderTask;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends Activity {
    private Button button;
    private InetAddress adr;
    private int port = 13337;

    public MainActivity() throws UnknownHostException {
        //adr = InetAddress.getByName("10.0.0.3");
        adr = InetAddress.getByName("192.168.1.105");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        //addListenerOnButton();
    }
    /** Called when the user clicks the Send button */
    public void onClick_Outlets(View view) {
        Intent intent = new Intent(this, OutletsActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:ON:16";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:OFF:16";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:ON:8";
                new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(msg.getBytes(), msg.length(), adr, port)});
            }
        });
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "OUTLET:OFF:8";
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
}