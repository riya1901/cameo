# 🎯 Real-Time Edge Detection Viewer (Android + OpenCV + OpenGL ES)

This is a technical assessment submission for the RnD Intern role. The project demonstrates **real-time edge detection** using Android's Camera2 API, native image processing via **OpenCV (C++)**, and rendering using **OpenGL ES 2.0**, all bridged through **JNI**.

---

## 📅 Assessment Details

 
- **Stack**: Android SDK, NDK (JNI), OpenCV C++, OpenGL ES  
- **Focus**: Integration, performance, and native rendering  
- **Goal**: Process camera frames natively and render edge-detected output in real time.

---

## 🧰 Tech Stack

| Technology    | Purpose                            |
|---------------|------------------------------------|
| Java          | Android UI, camera integration     |
| C++           | Native frame processing (OpenCV)   |
| JNI / NDK     | Java ↔ C++ communication            |
| OpenCV C++    | Image filters (Canny, grayscale)   |
| OpenGL ES 2.0 | Texture-based rendering            |
| CMake         | Native build system                |

---

## 📸 Features Implemented

- ✅ Camera2 API live feed using `TextureView`
- ✅ Native C++ processing using OpenCV
  - Canny Edge Detection
  - Grayscale fallback (optional)
- ✅ OpenGL ES 2.0 rendering with real-time texture
- ✅ Smooth performance (~10–15 FPS)
- ✅ JNI bridge with optimized memory transfer

---

## 🌟 Bonus Features (Optional)

- 🔘 Toggle Button for Raw ↔ Processed feed
- ⏱️ FPS Counter on screen or Logcat
- 🌫️ Extra filters: Gaussian Blur, Threshold
- ✨ GLSL shaders for grayscale, invert

---

## 🧠 Architecture Flow

```text
[Camera2 API (Java)]
        ↓
  [ByteBuffer Frame]
        ↓
   [JNI Bridge (JNI)]
        ↓
 [OpenCV Native (C++)]
        ↓
[OpenGL ES Renderer]
        ↓
  [GLSurfaceView Output]
```
## Folder Structure
```
cameo/
├── app/
│   └── src/
│       └── main/
│           ├── cpp/
│           │   ├── native-lib.cpp
│           │   └── CMakeLists.txt
│           ├── java/com/example/cameo/
│           │   ├── MainActivity.java
│           │   └── CameraHelper.java
│           ├── res/layout/
│           │   └── activity_main.xml
│           └── AndroidManifest.xml
├── build.gradle
└── CMakeLists.txt (root)
```
## 🛠️ Build & Run Guide

### 🔧 Prerequisites

- Android Studio with:
  - NDK installed
  - CMake installed
- OpenCV Android SDK: [Download here](https://opencv.org/releases/)

---

