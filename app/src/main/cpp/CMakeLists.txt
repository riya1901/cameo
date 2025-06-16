cmake_minimum_required(VERSION 3.10.2)
project("cameo")

# ✅ Native source file
add_library(
        cameo
        SHARED
        native-lib.cpp
)

# ✅ OpenCV library (IMPORTED)
add_library(opencv_java4 SHARED IMPORTED)

# ✅ Detect ABI and set path accordingly
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,--no-undefined")

if(${ANDROID_ABI} STREQUAL "armeabi-v7a")
    set_target_properties(opencv_java4 PROPERTIES
            IMPORTED_LOCATION
            ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi-v7a/libopencv_java4.so)
elseif(${ANDROID_ABI} STREQUAL "arm64-v8a")
    set_target_properties(opencv_java4 PROPERTIES
            IMPORTED_LOCATION
            ${CMAKE_SOURCE_DIR}/../jniLibs/${ANDROID_ABI}/libopencv_java4.so)
endif()

# ✅ Android log
find_library(
        log-lib
        log
)

# ✅ Link all libs
target_link_libraries(
        cameo
        opencv_java4
        ${log-lib}
)
