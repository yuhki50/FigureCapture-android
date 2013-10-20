package com.yuhki50.android.figurecapture.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EFragment;
import com.yuhki50.android.figurecapture.R;

/**
 * Fragment used for managing interactions for and presentation of a navigation drawer.
 * See the <a href="https://developer.android.com/design/patterns/navigation-drawer.html#Interaction">
 * design guidelines</a> for a complete explanation of the behaviors implemented here.
 */
@EFragment(R.layout.fragment_submit)
public class SubmitFragment extends Fragment {
    /**
     * Tag for logger.
     */
    private static final String TAG = SubmitFragment.class.getSimpleName();


    public SubmitFragment() {

    }

    @AfterViews
    protected void afterViews() {
        Log.d(TAG, "Fragment-afterViews");
    }

    @Override
    public void onAttach(Activity act) {
        super.onAttach(act);
        Log.d(TAG, "Fragment-onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment-onCreate");
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.d(TAG, "Fragment-onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment-onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment-onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment-onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment-onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "Fragment-onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment-onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "Fragment-onDetach");
    }
}
