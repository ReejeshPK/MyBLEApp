package com.blogspot.cavemanbacktocave.myblelibrary.builder;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;

import java.util.List;

public class MyBLEScanParameters {
    private int scanPeriod;
    private List<ScanFilter> filters;
    private ScanSettings scanSettings;

    private MyBLEScanParameters() {
        /** Use the builder */
    }

    public MyBLEScanParameters(int scanPeriod, List<ScanFilter> filters,ScanSettings scanSettings) {
        this.scanPeriod = scanPeriod;
        this.filters=filters;
        this.scanSettings=scanSettings;
    }

    public int getScanPeriod() {
        return scanPeriod;
    }

    public List<ScanFilter> getFilters() {
        return filters;
    }

    public ScanSettings getScanSettings() {
        return scanSettings;
    }
}
