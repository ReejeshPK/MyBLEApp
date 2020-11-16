package com.blogspot.cavemanbacktocave.myblelibrary.ble;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.Log;
import android.view.View;

import com.blogspot.cavemanbacktocave.myblelibrary.builder.MyBLEScanParameters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MyScan {
    /***
     * https://medium.com/@martijn.van.welie/making-android-ble-work-part-1-a736dcd53b02
     *
     * To start scan what all we need:
     * 1.Filters if any
     * 2.Scan type
     * 3.How much seconds to scan
     *
     * Perhaps needless to mention, but make sure you do all your Bluetooth stuff outside of an Activity.
     * Activities get created and recreated many times by Android, so if you do your scanning in an Activity
     * the scan may be started several times. Or worse, you connection may break because Android decided to
     * recreate your Activity…you have been warned!
     *
     * 1.Setup scan filters
     *
     */


    /**
     *
     * Check your permissions and Bluetooth state
     * Before we end this article I need to mention some things about acquiring the appropriate permissions.
     * Scanning only works if you have the following permission AND you have Location Service activated.
     * <uses-permission android:name="android.permission.BLUETOOTH" />
     * <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
     * <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
     * */

    private String TAG = MyScan.class.getSimpleName();

    private static MyScan myScan = null;

    private BluetoothAdapter mBluetoothAdapter;
    private static final long SCAN_PERIOD = 10000; //scanning for 10 seconds
    private Map<String, Integer> devRssiValues = new HashMap<String, Integer>();/*This is for signal strength*/


    private MyScan() {

    }

    public static synchronized MyScan getInstance() {
        if (myScan == null) {
            myScan = new MyScan();
        }
        return myScan;
    }

    public void startBLEScan(Activity activity, MyBLEScanParameters myBLEScanParameters) {
        initializeBLEAdapter(activity,myBLEScanParameters);
    }

    private void initializeBLEAdapter(Activity activity, MyBLEScanParameters myBLEScanParameters) {

        mBluetoothAdapter =  BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            Log.e(TAG, "initializeBLEAdapter: BLE Not supported");
            return;
        }
        BluetoothLeScanner scanner = mBluetoothAdapter.getBluetoothLeScanner();

        if (scanner != null) {
            /*todo: allow use of filters*/
            scanner.startScan(myBLEScanParameters.getFilters(), myBLEScanParameters.getScanSettings(), scanCallback);
            Log.d(TAG, "scan started");
        }  else {
            Log.e(TAG, "could not get scanner object");
        }
        devRssiValues = new HashMap<String, Integer>();//reset

    }

    private final ScanCallback scanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            BluetoothDevice device = result.getDevice();
            // ...do whatever you want with this found device
        }

        @Override
        public void onBatchScanResults(List<ScanResult> results) {
            // Ignore for now
        }

        @Override
        public void onScanFailed(int errorCode) {
            // Ignore for now
        }
    };


}
