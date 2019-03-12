#include <jni.h>
#include <string>

extern "C" {
    JNIEXPORT
    JNICALL
    jstring Java_arukoh_libyuv_Utils_stringFromJNI(
            JNIEnv* env,
            jobject /* this */) {
        std::string hello = "Hello from C++";
        return env->NewStringUTF(hello.c_str());
    }
}