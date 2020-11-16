package com.blogspot.cavemanbacktocave.myblelibrary.utils;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.content.Intent;
import android.os.ParcelUuid;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MyBLEUtils {

    private void turnONBluetooth(Activity activity,int REQUEST_ENABLE_BT_REQUEST_CODE){
        if (isBluetoothON()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT_REQUEST_CODE);
        }
    }

    public boolean isBluetoothON(){
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!bluetoothAdapter.isEnabled()) {
           return true;
        }
        return false;
    }

    /**
     * https://medium.com/@martijn.van.welie/making-android-ble-work-part-1-a736dcd53b02
     * see - Scanning for devices with a specific service UUID
     */
    public static List<ScanFilter> getUUIDFilter(UUID[] serviceUUIDs) {
        List<ScanFilter> filters = null;
        if (serviceUUIDs != null) {
            filters = new ArrayList<>();
            for (UUID serviceUUID : serviceUUIDs) {
                ScanFilter filter = new ScanFilter.Builder()
                        .setServiceUuid(new ParcelUuid(serviceUUID))
                        .build();
                filters.add(filter);
            }
        }
        return filters;
    }

    /*So here is an example of how to scan for devices by exact name:*/
    public static List<ScanFilter> getFilterForExactDeviceName(String[] exactNames) {
        /** String[] exactNames = new String[]{"Polar H7 391BB014"};*/
        List<ScanFilter> filters = null;
        if (exactNames != null) {
            filters = new ArrayList<>();
            for (String name : exactNames) {
                ScanFilter filter = new ScanFilter.Builder()
                        .setDeviceName(name)
                        .build();
                filters.add(filter);
            }
        }
        return filters;
    }

    public static List<ScanFilter> getFilterForMACAddress(String[] peripheralAddresses) {
        /*String[] peripheralAddresses = new String[]{"01:0A:5C:7D:D0:1A"};*/
        // Build filters list
        List<ScanFilter> filters = null;
        if (peripheralAddresses != null) {
            filters = new ArrayList<>();
            for (String address : peripheralAddresses) {
                ScanFilter filter = new ScanFilter.Builder()
                        .setDeviceAddress(address)
                        .build();
                filters.add(filter);
            }
        }
        return filters;
    }


    public static boolean getIsDeviceCached(BluetoothDevice device) {
     /*   // Get device object for a mac address
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(peripheralAddress)*/
    // Check if the peripheral is cached or not
        int deviceType = device.getType();
        if (deviceType == BluetoothDevice.DEVICE_TYPE_UNKNOWN) {
            // The peripheral is not cached
            return false;
        } else {
            // The peripheral is cached
            return true;
        }
    }

}
