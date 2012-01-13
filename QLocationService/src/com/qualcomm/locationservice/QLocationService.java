package com.qualcomm.locationservice;

import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.qualcomm.locationcommon.IQLocationService;
import com.qualcomm.locationcommon.QLocation;

public class QLocationService extends Service {
	static final String TAG = "QLocationService";

	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onBind");
		return new IQLocationServiceImpl();
	}

	/** Implementation of our service, in form of a Binder. */
	class IQLocationServiceImpl extends IQLocationService.Stub {

		@Override
		public List<String> getAllProviders() throws RemoteException {
			Log.d(TAG, "getAllProviders");
			return QLocationLib.getAllProviders();
		}

		@Override
		public QLocation getLastKnownLocation(String provider)
				throws RemoteException {
			return QLocationLib.getLastKnownLocation(provider);
		}

	}

}