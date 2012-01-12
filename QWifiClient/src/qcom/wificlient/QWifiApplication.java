package qcom.wificlient;

import android.app.Application;

public class QWifiApplication extends Application {
    QWifiManager wifi;

    @Override
    public void onCreate() {
        super.onCreate();
        wifi = new QWifiManager(this);
    }

    @Override
    public void onTerminate() {
        wifi.close();
        super.onTerminate();
    }

    
}
