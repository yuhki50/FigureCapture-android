package com.yuhki50.android.figurecapture.device;

import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.IOException;

public class CameraManager implements SurfaceHolder.Callback2 {
    /**
     * Tag for logger.
     */
    private static final String TAG = CameraManager.class.getSimpleName();

    // instance variables
//    protected Preview mPreview;
    protected Camera mCamera;
//    protected int numberOfCameras;
//    protected int defaultCameraId;
//    protected int cameraCurrentlyLocked;

    public CameraManager(Camera camera) {
        mCamera = camera;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "----------------");
        Log.d(TAG, "surfaceCreated");
        Log.d(TAG, "----------------");

        // The Surface has been created, acquire the camera and tell it where
        // to draw.
        mCamera = Camera.open();
        try {
            if (mCamera != null) {
                mCamera.setPreviewDisplay(surfaceHolder);
            }
        } catch (IOException exception) {
            Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
        Log.d(TAG, "----------------");
        Log.d(TAG, "surfaceChanged");
        Log.d(TAG, "----------------");
        if (mCamera == null) return;
        Log.d(TAG, "----------------");
        Log.d(TAG, "true");
        Log.d(TAG, "----------------");

        // Now that the size is known, set up the camera parameters and begin
        // the preview.
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewSize(width, height);
//                parameters.setPreviewSize(mPreviewSize.width, mPreviewSize.height);
//                requestLayout();

        //mCamera.setParameters(parameters);
        mCamera.startPreview();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "----------------");
        Log.d(TAG, "surfaceDestroyed");
        Log.d(TAG, "----------------");
        if (mCamera == null) return;
        Log.d(TAG, "----------------");
        Log.d(TAG, "true");
        Log.d(TAG, "----------------");

        // Surface will be destroyed when we return, so stop the preview.
        if (mCamera != null) {
            mCamera.stopPreview();
        }
    }

    @Override
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {

    }
}
