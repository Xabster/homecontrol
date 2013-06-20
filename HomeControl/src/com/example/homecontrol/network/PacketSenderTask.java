package com.example.homecontrol.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import android.os.AsyncTask;

public class PacketSenderTask extends AsyncTask<String, Void, Void> {

	@Override
	protected Void doInBackground(String... params) {
		if (params == null || params.length == 0)
			throw new IllegalArgumentException("No parameters");
		
		DatagramSocket sock = null;
		try {
			String msg = params[0];
			InetAddress adr = InetAddress.getByName("10.0.0.3");
			DatagramPacket pack = new DatagramPacket(msg.getBytes(), msg.length(), adr, 13337);
			sock = new DatagramSocket(13337);
			sock.send(pack);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sock != null) {
				sock.close();
			}
		}
		return null;
	}
}
