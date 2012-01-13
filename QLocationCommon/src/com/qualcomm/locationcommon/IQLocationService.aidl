package com.qualcomm.locationcommon;

import com.qualcomm.locationcommon.QLocation;

interface IQLocationService {
	List<String>	 getAllProviders();
	QLocation getLastKnownLocation(String provider);
}