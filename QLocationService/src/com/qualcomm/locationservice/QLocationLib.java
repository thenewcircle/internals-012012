package com.qualcomm.locationservice;

import java.util.Arrays;
import java.util.List;

import android.location.Location;

/** Wraps native calls to the C library. */
public class QLocationLib {

	/** Returns list of all available providers. */
	public static List<String> getAllProviders() {
		return Arrays.asList(_getAllProviders());
	}

	private static native String[] _getAllProviders();
	
	/** Returns last known location for given provider. */
	public static Location getLastKnownLocation(String provider) {
		Location location = new Location(provider);
		double[] locationData = _getLastKnownLocation(provider);
		location.setLatitude(locationData[0]);
		location.setLongitude(locationData[1]);
		return location;
	}
	
	private static native double[] _getLastKnownLocation(String provider);
	
	static {
		System.loadLibrary("qlocation");
	}
}
