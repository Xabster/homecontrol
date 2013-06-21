package com.example.homecontrol.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import android.os.AsyncTask;

public class PacketSenderTask extends AsyncTask<DatagramPacket, Void, Void> {

	@Override
	protected Void doInBackground(DatagramPacket... params) {
		if (params == null)
			throw new IllegalArgumentException("No parameters given!");

		for (DatagramPacket dp : params) {
			DatagramSocket sock = null;
			try {
				sock = new DatagramSocket(dp.getPort());
				sock.send(dp);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (sock != null) {
					sock.close();
				}
			}
		}
		return null;
	}
}