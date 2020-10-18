package com.blogspot.cavemanbacktocave.mybleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissionDialog;
import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissions;
import com.blogspot.cavemanbacktocave.myblelibrary.MyPermissionsDialogBuilder;

public class PermissionActivity extends AppCompatActivity {

    private String TAG = PermissionActivity.class.getSimpleName();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        textView=findViewById(R.id.textView);
        getSupportActionBar().setTitle("Permissions");
        MyPermissions myPermissions = MyPermissions.getInstance();
        /**This like getLifecycle() is used to manage activity lifecycle events*/
        getLifecycle().addObserver(myPermissions);/**Dont skip this lifecycle, you may encounter crashes*/

        MyPermissionDialog myPermissionsDialog = new MyPermissionsDialogBuilder()
                .setDialogTitle("Title")
                .setDialogDescription("Desc")
                .setFontNameInAssetsFontsFolder("fonts/SansitaSwashedRegular.ttf")
                .build(this);

        if (myPermissions.checkLocationPermission(PermissionActivity.this,myPermissionsDialog)) {
            //if permission granted proceed
           moveToScanningActivity();
        }

        //without customization
       /* if (myPermissions.checkLocationPermission(PermissionActivity.this,new MyPermissionDialog(this,this))) {
            //if permission granted proceed
        }*/

    }

    private void moveToScanningActivity() {
        Intent intent=new Intent(this,BLEScanningActivity.class);
        startActivity(intent);
    }

    /**
     * Note: Must override onRequestPermissionsResult - include in wiki
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MyPermissions.BLE_LOCATION_PERMISSION_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    moveToScanningActivity();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    textView.setText("Permission Not Granted, so cannot continue BLE scan");
                }
                return;
            }
            // other 'switch' lines to check for other
            // permissions this app might request
        }
    }
}