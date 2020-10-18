package com.blogspot.cavemanbacktocave.myblelibrary;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.lang.ref.WeakReference;

public class MyPermissions implements LifecycleObserver {
    private String TAG = MyPermissions.class.getSimpleName();
    public static final int BLE_LOCATION_PERMISSION_CODE = 572;

    private static MyPermissions myPermissions = null;
    private WeakReference<Activity> loginActivityWeakRef;

    /*private MyPermissions(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        this.loginActivityWeakRef=new WeakReference<Activity>(activity);
    }*/

    private MyPermissions() {
        /**Private dummy needed for getInstance*/
    }

    public static MyPermissions getInstance() {
        /**Note: Using context within getInstance is not recommended like getInstance(Context context), it leads to
         * saving the old context, so when the app goes background and comes back, it does not get new context, it uses old
         * and becomes not usable*/
        if (myPermissions == null) {
            myPermissions = new MyPermissions();
        }
        return myPermissions;
    }

    public boolean checkLocationPermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                explainPermissionDialog(activity);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        BLE_LOCATION_PERMISSION_CODE);
            }
            return false;
        } else {
            return true;
        }
    }

    private MyPermissionDialog myPermissionDialog;

    private void explainPermissionDialog(final Activity activity) {
        if (activity != null) {
            this.loginActivityWeakRef=new WeakReference<Activity>(activity);
            myPermissionDialog = new MyPermissionDialog(activity, new MyPermissionDialog.OnDialogButtonClick() {
                @Override
                public void buttonClickEventDialog(boolean okBtnClicked) {
                    if (okBtnClicked) {
                        ActivityCompat.requestPermissions(activity,
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                BLE_LOCATION_PERMISSION_CODE);
                    } else {
                        myPermissionDialog.dismiss();
                    }
                }
            });
            //todo:check if already showing
            Log.d(TAG, "explainPermissionDialog: ");
            if (!myPermissionDialog.isShowing()) {
                Log.d(TAG, "explainPermissionDialog: isshow");
                if (loginActivityWeakRef.get() != null && !loginActivityWeakRef.get().isFinishing()) {
                    /**This if condition prevents crashes*/
                    Log.d(TAG, "explainPermissionDialog: show");
                    //https://stackoverflow.com/a/18665887/7710739
                    myPermissionDialog.show();
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        //pause logic
        Log.d(TAG, "pause: ");
        if (myPermissionDialog != null) {
            myPermissionDialog.dismiss();
        }

    }

}
