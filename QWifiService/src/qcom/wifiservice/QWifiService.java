package qcom.wifiservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class QWifiService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("QWifi", "onBind");
        return new IQWifiServiceImpl();
    }

}
