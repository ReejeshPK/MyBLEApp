package com.blogspot.cavemanbacktocave.mybleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissions;

public class PermissionActivity extends AppCompatActivity {

    private String TAG=PermissionActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        MyPermissions myPermissions=MyPermissions.getInstance(PermissionActivity.this,PermissionActivity.this);
        /**This like getLifecycle() is used to manage activity lifecycle events*/
        getLifecycle().addObserver(myPermissions);
        myPermissions.checkLocationPermission();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}