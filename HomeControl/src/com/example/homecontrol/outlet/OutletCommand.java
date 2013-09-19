package com.example.homecontrol.outlet;

import android.util.Log;
import com.example.homecontrol.network.PacketSenderTask;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: Lennon
 * Date: 19-09-13
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class OutletCommand {

    private InetAddress adr;
    private int port = 13337;

    public OutletCommand(int OutletAddress, String mode) {

        String myCommand = BuildCommand(OutletAddress, mode);

        try {
            adr = InetAddress.getByName("192.168.1.105");
        } catch (UnknownHostException e) {
            Log.e("OutletCommand", "Failed to get IP Address");
        }

        new PacketSenderTask().execute(new DatagramPacket[]{new DatagramPacket(myCommand.getBytes(), myCommand.length(), adr, port)});

    }

    private String BuildCommand(int OutletAddress, String mode)
    {
        String myCommand = "OUTLET:" + mode + ":" + Integer.toString(OutletAddress);

        return myCommand;
    }
}
