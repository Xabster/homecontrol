package com.example.homecontrol.network;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 17-09-13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class UDPListener_Runable implements Runnable {

    public static final int SERVERPORT = 65135;

    @Override
    public void run() {
        DatagramPacket packet;
        DatagramSocket socket;
        byte[] buf;

        try {
        Log.d("UDP", "Connecting...");
                            /* Create new UDP-Socket */
        socket = new DatagramSocket(SERVERPORT);

                            /* By magic we know, how much data will be waiting for us */
        buf = new byte[1500];
                            /* Prepare a UDP-Packet that can
                             * contain the data we want to receive */
        packet = new DatagramPacket(buf, buf.length);


            while(true)
            {
                    Log.d("UDP", "Receiving...");

                                /* Receive the UDP-Packet */
                    socket.receive(packet);
                    Log.d("UDP", "Received: '" + new String(buf, 0, packet.getLength()) + "'");
                    Log.d("UDP", "Done.");

            }

        } catch (Exception e) {
            Log.e("UDP", "Error Receiving", e);
        }
    }
}
