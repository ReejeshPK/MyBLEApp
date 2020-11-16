package com.blogspot.cavemanbacktocave.mybleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.Bundle;

import com.blogspot.cavemanbacktocave.myblelibrary.ble.MyScan;
import com.blogspot.cavemanbacktocave.myblelibrary.builder.MyBLEScanParameters;
import com.blogspot.cavemanbacktocave.myblelibrary.builder.MyBLEScanParametersBuilder;
import com.blogspot.cavemanbacktocave.myblelibrary.utils.MyBLEUtils;

import java.util.List;
import java.util.UUID;

public class BLEScanningActivity extends AppCompatActivity {

    private RecyclerView bleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l_e_scanning);
        bleList=findViewById(R.id.bleList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        bleList.setLayoutManager(layoutManager);

        startNormalScan();


    }

    private void startNormalScan(){
        MyBLEScanParameters myBLEScanParameters=
                new MyBLEScanParametersBuilder(10)
                        .setFilters(null)/*Filter is optional, set null if you dont want any*/
                        .setScanSettings(null)
                        .build();
        MyScan.getInstance().startBLEScan(this,myBLEScanParameters);
    }

    private void startScanWithScanSettings(){
        ScanSettings scanSettings = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            scanSettings = new ScanSettings.Builder()
                    .setScanMode(ScanSettings.SCAN_MODE_LOW_POWER)
                    .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES)
                    .setMatchMode(ScanSettings.MATCH_MODE_AGGRESSIVE)
                    .setNumOfMatches(ScanSettings.MATCH_NUM_ONE_ADVERTISEMENT)
                    .setReportDelay(0L)
                    .build();
        }else{
            scanSettings = new ScanSettings.Builder()
                    .setScanMode(ScanSettings.SCAN_MODE_LOW_POWER)
                    .setReportDelay(0L)
                    .build();
        }
        MyBLEScanParameters myBLEScanParameters=
                new MyBLEScanParametersBuilder(10)
                        .setFilters(null)/*Filter is optional, set null if you dont want any*/
                        .setScanSettings(scanSettings)
                        .build();
        MyScan.getInstance().startBLEScan(this,myBLEScanParameters);
    }


    private void startScanWithUUID(){
        /**Here is an example showing how to scan for a blood pressure service:
         * https://medium.com/@martijn.van.welie/making-android-ble-work-part-1-a736dcd53b02
         * https://www.bluetooth.com/specifications/assigned-numbers/service-discovery/*/
        UUID BLP_SERVICE_UUID = UUID.fromString("00001810-0000-1000-8000-00805f9b34fb");
        UUID[] serviceUUIDs = new UUID[]{BLP_SERVICE_UUID};
        List<ScanFilter> filters= MyBLEUtils.getUUIDFilter(serviceUUIDs);
        filters=null;//for testing
        MyBLEScanParameters myBLEScanParameters=
                new MyBLEScanParametersBuilder(10)
                        .setFilters(filters)/*Filter is optional, set null if you dont want any*/
                        .build();
        MyScan.getInstance().startBLEScan(this,myBLEScanParameters);
    }



}