package com.blogspot.cavemanbacktocave.myblelibrary;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MyPermissions {
    public static final int BLE_LOCATION_PERMISSION_CODE=572;
    private Context context;
    private Activity activity;
    private static MyPermissions myPermissions=null;

    private MyPermissions(Context context, Activity activity) {
        this.context = context;
        this.activity=activity;
    }

    private MyPermissions() {
        /**Private dummy needed for getInstance*/
    }

    public static MyPermissions getInstance(Context context, Activity activity){
        if(myPermissions==null){
            myPermissions=new MyPermissions(context,activity);
        }
        return myPermissions;
    }

    public boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //explainPermissionDialog();
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
}
