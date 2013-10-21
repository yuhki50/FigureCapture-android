package com.yuhki50.android.figurecapture.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.FragmentById;
import com.googlecode.androidannotations.annotations.OptionsItem;
import com.yuhki50.android.figurecapture.R;
import com.yuhki50.android.figurecapture.fragment.CaptureFragment_;
import com.yuhki50.android.figurecapture.fragment.NavigationDrawerFragment;
import com.yuhki50.android.figurecapture.fragment.SubmitFragment_;
import com.yuhki50.android.figurecapture.fragment.ThumbnailFragment_;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    /**
     * Tag for logger.
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    @FragmentById(R.id.navigation_drawer)
    protected NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @AfterViews
    protected void calledAfterViewInjection() {
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        switch (position) {
            case 0:
                mTitle = getString(R.string.title_section1);
                fragmentTransaction.replace(R.id.container, new CaptureFragment_());
                break;
            case 1:
                mTitle = getString(R.string.title_section2);
                fragmentTransaction.replace(R.id.container, new ThumbnailFragment_());
                break;
            case 2:
                mTitle = getString(R.string.title_section3);
                fragmentTransaction.replace(R.id.container, new SubmitFragment_());
                break;
        }

        fragmentTransaction.commit();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @OptionsItem(R.id.action_login)
    protected void actionLoginSelected() {
        Toast.makeText(this, "actionLoginSelected", Toast.LENGTH_SHORT).show();
    }

    @OptionsItem(R.id.action_change_camera)
    protected void actionChangeCameraSelected() {
        Toast.makeText(this, "actionChangeCameraSelected", Toast.LENGTH_SHORT).show();
    }

    @OptionsItem(R.id.action_settings)
    protected void actionSettingsSelected() {
        Toast.makeText(this, "actionSettingsSelected", Toast.LENGTH_SHORT).show();
    }

    @OptionsItem(R.id.action_help)
    protected void actionHelpSelected() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/yuhki50/FigureCapture-android")));
    }
}
