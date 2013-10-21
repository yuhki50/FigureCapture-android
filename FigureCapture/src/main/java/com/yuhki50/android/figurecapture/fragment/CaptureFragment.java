package com.yuhki50.android.figurecapture.fragment;

import android.app.AlertDialog;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EFragment;
import com.googlecode.androidannotations.annotations.ViewById;
import com.yuhki50.android.figurecapture.R;
import com.yuhki50.android.figurecapture.view.CameraView;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
@EFragment(R.layout.fragment_capture)
public class CaptureFragment extends BaseFragment {
    /**
     * Tag for logger.
     */
    private static final String TAG = CaptureFragment.class.getSimpleName();


    @ViewById(R.id.cameraView1)
    protected CameraView mCameraView;


//    private Preview mPreview;
    Camera mCamera;
    int numberOfCameras;
    int cameraCurrentlyLocked;

    // The first rear facing camera
    int defaultCameraId;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
    @AfterViews
    protected void afterViews() {
//        super.onCreate(savedInstanceState);

        // Hide the window title.
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create a RelativeLayout container that will hold a SurfaceView,
        // and set it as the content of our activity.
//        mCameraView = new CameraView(this);
//        setContentView(mCameraView);

        // Find the total number of cameras available
        numberOfCameras = Camera.getNumberOfCameras();

        // Find the ID of the default camera
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) {
                defaultCameraId = i;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        // Open the default i.e. the first rear facing camera.
        mCamera = Camera.open();
        cameraCurrentlyLocked = defaultCameraId;
        mCameraView.setCamera(mCamera);
    }

    @Override
    public void onPause() {
        super.onPause();

        // Because the Camera object is a shared resource, it's very
        // important to release it when the activity is paused.
        if (mCamera != null) {
            mCameraView.setCamera(null);
            mCamera.release();
            mCamera = null;
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate our menu which can gather user input for switching camera.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.camera_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.switch_cam:
                // check for availability of multiple cameras
                if (numberOfCameras == 1) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("this.getString(R.string.camera_alert)").setNeutralButton("Close", null);
                    AlertDialog alert = builder.create();
                    alert.show();
                    return true;
                }

                // OK, we have multiple cameras.
                // Release this camera -> cameraCurrentlyLocked
                if (mCamera != null) {
                    mCamera.stopPreview();
                    mCameraView.setCamera(null);
                    mCamera.release();
                    mCamera = null;
                }

                // Acquire the next camera and request Preview to reconfigure parameters.
                mCamera = Camera.open((cameraCurrentlyLocked + 1) % numberOfCameras);
                cameraCurrentlyLocked = (cameraCurrentlyLocked + 1) % numberOfCameras;
                mCameraView.switchCamera(mCamera);

                // Start the preview
                mCamera.startPreview();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}
