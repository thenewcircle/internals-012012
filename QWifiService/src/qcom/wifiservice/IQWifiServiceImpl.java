package qcom.wifiservice;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;

import qcom.wificommon.IQWifiService;
import qcom.wificommon.QWifiInfo;
import qcom.wificommon.ScanListener;

import java.util.ArrayList;
import java.util.List;

public class IQWifiServiceImpl extends IQWifiService.Stub {
    static final String TAG = "QWifi";
    
    QWifiLib qWifiLib;
    
    public IQWifiServiceImpl() {
        qWifiLib = new QWifiLib();
    }
    
    @Override
    public int connect(String ssid) throws RemoteException {
        Log.d(TAG, "connect with ssid: "+ssid);
        return qWifiLib.connect(ssid);
    }

    @Override
    public int enableWifi() throws RemoteException {
        Log.d(TAG, "enableWifi");
        return qWifiLib.enableWifi();
    }

    @Override
    public QWifiInfo getConnectionInfo() throws RemoteException {
        return new QWifiInfo("MySSID", 123, 456);
    }

    @Override
    public void startScan(ScanListener listener) throws RemoteException {
        List<QWifiInfo> results = new ArrayList<QWifiInfo>();
        results.add( new QWifiInfo("SSID1", 123, 456) );
        results.add( new QWifiInfo("SSID2", 234, 567) );
        results.add( new QWifiInfo("SSID3", 345, 678) );
        listener.onScanComplete(results);
        Log.d(TAG, "startScan");
    }
}
