package com.qualcomm.locationclient;

import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qualcomm.location.R;
import com.qualcomm.locationcommon.IQLocationService;

public class QLocationActivity extends Activity {
	static final String TAG = "QLocation";
	TextView output;
	IQLocationService service;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		output = (TextView) findViewById(R.id.output);

		Intent intent = new Intent(
				"com.qualcomm.locationcommon.IQLocationService");
		QServiceConnection serviceConnection = new QServiceConnection();
		bindService(intent, serviceConnection, BIND_AUTO_CREATE);
	}

	/** Called when button is clicked. */
	public void onClick(View v) {
		Log.d(TAG, "onClicked");

		if(service==null) {
			Log.d(TAG, "Service is null");
			return;
		}
		
		try {
			List<String> providers = service.getAllProviders();
			for (String provider : providers) {
				output.append("\n" + provider);
			}
		} catch (RemoteException e) {
			Log.e(TAG, "Failed to call getAllProviders()", e);
		}

		// Location location = QLocationLib.getLastKnownLocation("GPS2");
		// output.append("\n"+location.toString());
	}

	class QServiceConnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder binder) {
			service = IQLocationService.Stub.asInterface(binder);
			Log.d(TAG, "onServiceConnected");
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			service = null;
			Log.d(TAG, "onServiceDisconnected");
		}
	}
}