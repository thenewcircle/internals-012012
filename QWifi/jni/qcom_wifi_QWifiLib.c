#define LOG_TAG "QCOM_WIFI"

#include <stdio.h>
#include "qcom_wifi_lib.h"
#include "qcom_wifi_QWifiLib.h"

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
	return JNI_VERSION_1_6;
}

JNIEXPORT jboolean JNICALL Java_qcom_wifi_QWifiLib_enableWifi
  (JNIEnv *env, jobject obj) {
	return enableWifi();
}

JNIEXPORT jboolean JNICALL Java_qcom_wifi_QWifiLib_connect
  (JNIEnv *env, jobject obj, jstring ssid) {
	const jbyte *str;
	str = (*env)->GetStringUTFChars(env, ssid, NULL);
	printf("ssid: %s",str);
	(*env)->ReleaseStringUTFChars(env, ssid, str);
	return connect((char*)str);
}
