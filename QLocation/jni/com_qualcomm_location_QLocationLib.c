#include "com_qualcomm_location_QLocationLib.h"

JNIEXPORT jobjectArray JNICALL Java_com_qualcomm_location_QLocationLib__1getAllProviders
  (JNIEnv *env, jclass clazz) {
	return 0;
}

JNIEXPORT jdoubleArray JNICALL Java_com_qualcomm_location_QLocationLib__1getLastKnownLocation
  (JNIEnv *env, jclass clazz, jstring provider) {
	double data[] = {370000, 1280000};

	jdoubleArray ret = (*env)->NewDoubleArray(env, 2);
	(*env)->SetDoubleArrayRegion(env, ret, 0, 2, data);
	return ret;
}
