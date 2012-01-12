LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := com_qualcomm_location_QLocationLib.c
LOCAL_MODULE    := qlocation
include $(BUILD_SHARED_LIBRARY)
