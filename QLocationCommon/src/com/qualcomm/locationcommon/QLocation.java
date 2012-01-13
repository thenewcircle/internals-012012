package com.qualcomm.locationcommon;

import android.os.Parcel;
import android.os.Parcelable;

public class QLocation implements Parcelable {
	private double latitude;
	private double longitude;

	public QLocation() {
		super();
		latitude = 0;
		longitude = 0;
	}

	public QLocation(Parcel source) {
		latitude = source.readDouble();
		longitude = source.readDouble();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<QLocation> CREATOR = new Parcelable.Creator<QLocation>() {

		@Override
		public QLocation createFromParcel(Parcel parcel) {
			return new QLocation(parcel);
		}

		@Override
		public QLocation[] newArray(int size) {
			return new QLocation[size];
		}

	};

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeDouble(latitude);
		dest.writeDouble(longitude);
	}
	
	////// Setters and getters

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


}
