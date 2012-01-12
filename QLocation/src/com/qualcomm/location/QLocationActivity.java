package com.qualcomm.location;

import java.util.List;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class QLocationActivity extends Activity {
	static final String TAG = "QLocation";
	TextView output;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        output = (TextView)findViewById(R.id.output);
    }
    
    /** Called when button is clicked. */
    public void onClick(View v) {
    		Log.d(TAG, "onClicked");
    		
//    		List<String> providers = QLocationLib.getAllProviders();
//    		for(String provider: providers) {
//    			output.append("\n" + provider);
//    		}
    		
    		Location location = QLocationLib.getLastKnownLocation("GPS2");
    		output.append("\n"+location.toString());
    }
}