package com.example.cameo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("cameo");
    }

    private TextureView textureView;
    private native void initCamera(Surface surface);
    private native void stopCamera();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textureView = findViewById(R.id.textureView);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        } else {
            setupTexture();
        }
    }

    private void setupTexture() {
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int w, int h) {
                initCamera(new Surface(surface));
            }

            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int w, int h) {}
            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
                stopCamera();
                return true;
            }
            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {}
        });
    }

    @Override
    protected void onDestroy() {
        stopCamera();
        super.onDestroy();
    }
}
