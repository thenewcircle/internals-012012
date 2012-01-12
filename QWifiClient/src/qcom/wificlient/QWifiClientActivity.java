
package qcom.wificlient;

import android.app.Activity;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import qcom.wificommon.QWifiInfo;
import qcom.wificommon.ScanListener;

import java.util.List;

public class QWifiClientActivity extends Activity {
    static final String TAG = "QWifi";
    TextView out;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        out = (TextView) findViewById(R.id.out);
        
//        Debug.startMethodTracing("QWifi.trace");
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Debug.stopMethodTracing();
    }


    /** Called when button in clicked. */
    public void onClick(View v) {
        out.setText("Output:\n");

        QWifiManager wifi = ((QWifiApplication) getApplication()).wifi;

        wifi.startScan(new ScanListenerImpl());

        wifi.enableWifi();
        out.append("Wifi enabled.\n");

        Log.d(TAG, "onClick got: " + wifi.connect("MySSID"));
        out.append("Wifi connected.\n");

        QWifiInfo info = wifi.getConnectionInfo();
        out.append(String.format("Connection:\nSSID:\t%s\nIP Address:\t%d\nSpeed:\t%d",
                info.getSsid(), info.getIpAddress(), info.getLinkSpeed()));
    }

    static final int SCAN_RESULTS = 47;
    private final Handler scanHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == SCAN_RESULTS) {
                out.append("\nGot results:\n");
                List<QWifiInfo> results = (List<QWifiInfo>) msg.obj;
                for (QWifiInfo info : results) {
                    out.append(String.format("\n\nSSID:\t%s\nIP Address:\t%d\nSpeed:\t%d",
                            info.getSsid(), info.getIpAddress(), info.getLinkSpeed()));
                }
            }
        }

    };

    /** Implementation of ScanListner. */
    class ScanListenerImpl extends ScanListener.Stub {

        @Override
        public void onScanComplete(List<QWifiInfo> results) throws RemoteException {
            Message msg = Message.obtain(scanHandler, SCAN_RESULTS, results);
            scanHandler.sendMessage(msg);
        }
    }
}
