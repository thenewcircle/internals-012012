package qcom.wificommon;

import qcom.wificommon.QWifiInfo;
import qcom.wificommon.ScanListener;

interface IQWifiService {
	int connect(String ssid);
	int enableWifi();
	QWifiInfo getConnectionInfo();
	void startScan( ScanListener listener );
}