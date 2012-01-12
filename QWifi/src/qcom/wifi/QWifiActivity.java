package qcom.wifi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class QWifiActivity extends Activity {
    QWifiLib wifi;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        wifi = new QWifiLib();
    }
    
    public void onClick(View v) {
        wifi.enableWifi();
        wifi.connect("MySSID");        
    }
}