LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional
LOCAL_SHARED_LIBRARIES := libcutils libutils libc
LOCAL_MODULE    := qwifi
LOCAL_LDLIBS := -llog
LOCAL_SRC_FILES := qcom_wifi_QWifiLib.c qcom_wifi_lib.c

include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := main.c
LOCAL_C_INCLUDES := $(LOCAL_PATH)
LOCAL_SHARED_LIBRARIES := libc
LOCAL_MODULE := qcom_wifi

include $(BUILD_EXECUTABLE)
