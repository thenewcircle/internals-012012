
package qcom.wificlient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import qcom.wificommon.IQWifiService;
import qcom.wificommon.QWifiInfo;
import qcom.wificommon.ScanListener;

public class QWifiManager {
    static final String TAG = "QWifi";
    static final Intent INTENT = new Intent("qcom.wificommon.IQWifiService");
    Context context;
    IQWifiService service;
    QWifiServiceConnection connection;

    /** Responsible for binding to the service. */
    public QWifiManager(Context context) {
        this.context = context;

        connection = new QWifiServiceConnection();
        context.bindService(INTENT, connection, Context.BIND_AUTO_CREATE);

    }

    /** Should be called to release the service connection. */
    public void close() {
        context.unbindService(connection);
    }

    /** Responsible for handling connection/disconnection to remote service. */
    class QWifiServiceConnection implements ServiceConnection {

        /** Called once we successfully bound to remote service. */
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = IQWifiService.Stub.asInterface(binder);
            Log.d(TAG, "onServiceConnected");
        }

        /** Remote service got disconnected. */
        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
            Log.d(TAG, "onServiceDisconnected");
        }
    }
    
    /*----- Proxy methods -----*/
    public int connect(String ssid) {
        int ret = -1;
        try {
            ret = service.connect(ssid);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to connect", e);
        }
        return ret;
    }
    
    public int enableWifi() {
        int ret = -1;
        try {
            ret = service.enableWifi();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to enable wifi", e);
        }
        return ret;
    }

    public QWifiInfo getConnectionInfo() {
        try {
            return service.getConnectionInfo();
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to getConnectionInfo", e);
            return null;
        }
    }
    
    public void startScan( ScanListener listener ) {
        try {
            service.startScan(listener);
        } catch (RemoteException e) {
            Log.e(TAG, "Failed to startScan", e);
        }
    }
}
