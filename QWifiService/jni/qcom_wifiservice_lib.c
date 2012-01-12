#define LOG_TAG "QcomWifi"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#include <stdio.h>
#include <android/log.h>


int enableWifi() {
	LOGI("enableWifi");
	return 47;
}

int connect( char *ssid ) {
	LOGI("connect");
	printf("%s", ssid);
	return 57;
}
