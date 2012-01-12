package qcom.wifiservice;

public class QWifiLib {

    public native int enableWifi();
    public native int connect(String ssid);
    
    static {
        System.loadLibrary("qwifi");
    }    
}
