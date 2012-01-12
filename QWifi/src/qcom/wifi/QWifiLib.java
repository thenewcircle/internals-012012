package qcom.wifi;

public class QWifiLib {

    public native boolean enableWifi();
    public native boolean connect(String ssid);
    
    static {
        System.loadLibrary("qwifi");
    }
    
}
