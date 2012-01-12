#define LOG_TAG "QcomWifi"
#include <stdio.h>

int enableWifi() {
	return 1;
}

int connect( char *ssid ) {
	printf("%s", ssid);
	return 1;
}
