package qcom.wificommon;

import qcom.wificommon.QWifiInfo;

oneway interface ScanListener {
    void onScanComplete( in List<QWifiInfo> result );
}