package com.blogspot.cavemanbacktocave.mybleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissionDialog;
import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissions;
import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissionsDialogBuilder;

public class PermissionActivity extends AppCompatActivity {

    private String TAG = PermissionActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        MyPermissions myPermissions = MyPermissions.getInstance();
        /**This like getLifecycle() is used to manage activity lifecycle events*/
        getLifecycle().addObserver(myPermissions);/**Dont skip this lifecycle, you may encounter crashes*/

        MyPermissionDialog myPermissionsDialog = new MyPermissionsDialogBuilder().setDialogTitle("Title")
                .setDialogDescription("Desc").build(this);

        if (myPermissions.checkLocationPermission(PermissionActivity.this,myPermissionsDialog)) {
            //if permission granted proceed
        }

        //without customization
       /* if (myPermissions.checkLocationPermission(PermissionActivity.this,new MyPermissionDialog(this,this))) {
            //if permission granted proceed
        }*/

    }

    /**
     * Note: Must override onRequestPermissionsResult - include in wiki
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}