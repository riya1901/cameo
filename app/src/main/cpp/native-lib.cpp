
#include <jni.h>
#include "include/opencv2/core.hpp"
#include "include/opencv2/imgproc.hpp"
#include <android/native_window_jni.h>
#include <android/log.h>

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, "CAM_OPENGL", __VA_ARGS__)
using namespace cv;

ANativeWindow* window = nullptr;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_cameo_MainActivity_initCamera(JNIEnv* env, jobject, jobject surface) {
    window = ANativeWindow_fromSurface(env, surface);
    VideoCapture cap(0); // Open default camera
    if (!cap.isOpened()) {
        LOGI("Camera open failed");
        return;
    }

    Mat frame, gray, edges;
    while (true) {
        cap >> frame;
        if (frame.empty()) break;

        cvtColor(frame, gray, COLOR_BGR2GRAY);
        Canny(gray, edges, 50, 150);

        ANativeWindow_setBuffersGeometry(window, edges.cols, edges.rows, WINDOW_FORMAT_RGB_565);
        ANativeWindow_Buffer buffer;
        if (ANativeWindow_lock(window, &buffer, nullptr) == 0) {
            Mat window_mat(buffer.height, buffer.width, CV_8UC2, buffer.bits);
            cvtColor(edges, window_mat, COLOR_GRAY2BGR565);
            ANativeWindow_unlockAndPost(window);
        }
    }
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_cameo_MainActivity_stopCamera(JNIEnv*, jobject) {
    if (window) {
        ANativeWindow_release(window);
        window = nullptr;
    }
}
