
package qcom.wificommon;

import android.os.Parcel;
import android.os.Parcelable;

public class QWifiInfo implements Parcelable {
    private String ssid;
    private int ipAddress;
    private int linkSpeed;

    /** Constructor taking fields. */
    public QWifiInfo(String ssid, int ipAddress, int linkSpeed) {
        super();
        this.ssid = ssid;
        this.ipAddress = ipAddress;
        this.linkSpeed = linkSpeed;
    }

    /** Creates new QWifiInfo from a parcel. */
    public QWifiInfo(Parcel parcel) {
        this(parcel.readString(), parcel.readInt(), parcel.readInt());
    }

    /** Describes contents, ignore for now. */
    @Override
    public int describeContents() {
        return 0;
    }

    /** Writes current object into a parcel. */
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(ssid);
        parcel.writeInt(ipAddress);
        parcel.writeInt(linkSpeed);
    }

    /** Must have the creator like this, but Eclipse won't do it for you. */
    public static final Parcelable.Creator<QWifiInfo> CREATOR = new Parcelable.Creator<QWifiInfo>() {

        @Override
        public QWifiInfo createFromParcel(Parcel source) {
            return new QWifiInfo(source);
        }

        @Override
        public QWifiInfo[] newArray(int size) {
            return new QWifiInfo[size];
        }
    };

    /*----- Setters & Getters -----*/
    
    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(int ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getLinkSpeed() {
        return linkSpeed;
    }

    public void setLinkSpeed(int linkSpeed) {
        this.linkSpeed = linkSpeed;
    }
}
