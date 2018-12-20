#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_fernandez_adrian_scaletor_Scaletor_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
