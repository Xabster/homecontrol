package com.example.homecontrol;

import com.example.homecontrol.network.PacketSenderTask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button;
	
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
				new PacketSenderTask().execute(new String[] {"OUTLET:ON:1"});
			}
		});
		button = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new PacketSenderTask().execute(new String[] {"OUTLET:OFF:1"});
			}
		});
		button = (Button) findViewById(R.id.button3);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new PacketSenderTask().execute(new String[] {"OUTLET:ON:2"});
			}
		});
		button = (Button) findViewById(R.id.button4);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new PacketSenderTask().execute(new String[] {"OUTLET:OFF:2"});
			}
		});
		button = (Button) findViewById(R.id.button5);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new PacketSenderTask().execute(new String[] {"OUTLET:ON:3"});
			}
		});
		button = (Button) findViewById(R.id.button6);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new PacketSenderTask().execute(new String[] {"OUTLET:OFF:3"});
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