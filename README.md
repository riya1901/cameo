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
## 🌐 Push to GitHub – Step-by-Step Guide

Use these steps to push your Android project to GitHub using the command line:

---

### 🧱 Step 1: Initialize Git

```bash
git init
```

---

### 🔗 Step 2: Add Remote Repository

```bash
git remote add origin https://github.com/your-username/cameo.git
```

⚠️ Replace `your-username` with your actual GitHub username.

---

### 📦 Step 3: Add All Project Files

```bash
git add .
```

---

### 📝 Step 4: Commit Your Changes

```bash
git commit -m "Initial commit"
```

---

### 🔄 Step 5: Pull README or Existing Files (if needed)

```bash
git pull origin main --allow-unrelated-histories
```

---

### ☁️ Step 6: Push Code to GitHub

```bash
git push origin main
```

---

## ⚠️ Common Errors and Fixes

### ❌ Error: Updates were rejected because the tip of your current branch is behind

✅ Run:

```bash
git pull origin main --allow-unrelated-histories
```

### ❌ Error: RPC failed; curl 22 The requested URL returned error: 408

✅ Solution:

```bash
git config http.postBuffer 524288000
```

### ❌ Warning: File too large (e.g., .so files > 50MB)

✅ Solution: Use Git Large File Storage (LFS)

```bash
git lfs install
git lfs track "*.so"
git add .gitattributes
git add path/to/your/largefile.so
git commit -m "Track large files with Git LFS"
git push origin main
```

👉 Install Git LFS from: [https://git-lfs.github.com](https://git-lfs.github.com)

