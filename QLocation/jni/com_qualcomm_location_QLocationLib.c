#include "com_qualcomm_location_QLocationLib.h"

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *vm, void *reserved) {
	return JNI_VERSION_1_6;
}

JNIEXPORT jobjectArray JNICALL Java_com_qualcomm_location_QLocationLib__1getAllProviders
  (JNIEnv *env, jclass clazz) {
	jclass type = (*env)->FindClass(env, "java/lang/String");
	jstring provider = (*env)->NewStringUTF(env, "GPS2");
	jobjectArray ret = (*env)->NewObjectArray(env, 1, type, provider);
	return ret;
}

JNIEXPORT jdoubleArray JNICALL Java_com_qualcomm_location_QLocationLib__1getLastKnownLocation
  (JNIEnv *env, jclass clazz, jstring provider) {
	double data[] = {370000, 1280000};

	jdoubleArray ret = (*env)->NewDoubleArray(env, 2);
	(*env)->SetDoubleArrayRegion(env, ret, 0, 2, data);
	return ret;
}
