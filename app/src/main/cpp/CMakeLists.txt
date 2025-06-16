cmake_minimum_required(VERSION 3.10.2)
project("cameo")

include_directories(
        ${CMAKE_SOURCE_DIR}/src/main/cpp/include
)

add_library(
        cameo
        SHARED
        native-lib.cpp
)

add_library(
        opencv_java4
        SHARED
        IMPORTED
)

set_target_properties(opencv_java4 PROPERTIES
        IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/src/main/jniLibs/armeabi-v7a/libopencv_java4.so
        )

find_library(
        log-lib
        log
)

target_link_libraries(
        cameo
        opencv_java4
        ${log-lib}
)
