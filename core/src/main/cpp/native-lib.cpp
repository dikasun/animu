#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_andikas_animu_core_di_CoreModuleKt_baseUrl(
        JNIEnv *env,
        jclass
) {
    std::string baseUrl = "https://animu-api.up.railway.app/";
    return env->NewStringUTF(baseUrl.c_str());
}