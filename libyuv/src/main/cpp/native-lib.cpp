#include <jni.h>
#include <string>

#include "libyuv.h"

extern "C" {

    JNIEXPORT void JNICALL
    Java_arukoh_nativelib_Libyuv_ARGBToNV21(JNIEnv *env, jobject,
                                            jbyteArray rgbArray,
                                            jint width, jint height,
                                            jbyteArray yuvArray) {
        jbyte *rgb = env->GetByteArrayElements(rgbArray, NULL);
        jbyte *yuv = env->GetByteArrayElements(yuvArray, NULL);
        libyuv::ARGBToNV21((uint8_t*) rgb, width << 2,
                           (uint8_t*) yuv, width,
                           (uint8_t*) &yuv[width * height], width,
                           width, height);
        env->ReleaseByteArrayElements(yuvArray, yuv, 0);
        env->ReleaseByteArrayElements(rgbArray, rgb, 0);
    }

    JNIEXPORT
    JNICALL
    void Java_arukoh_nativelib_Libyuv_NV21ToARGB(JNIEnv *env, jobject,
                                                 jbyteArray yuvArray,
                                                 jint width, jint height,
                                                 jbyteArray rgbArray) {
        jbyte *yuv = env->GetByteArrayElements(yuvArray, NULL);
        jbyte *rgb = env->GetByteArrayElements(rgbArray, NULL);
        libyuv::NV21ToARGB((uint8_t*) yuv, width,
                           (uint8_t*) &yuv[width * height], width,
                           (uint8_t*) rgb, width << 2,
                           width, height);
        env->ReleaseByteArrayElements(yuvArray, yuv, 0);
        env->ReleaseByteArrayElements(rgbArray, rgb, 0);
    }

}