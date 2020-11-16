package com.blogspot.cavemanbacktocave.myblelibrary.builder;

import android.bluetooth.le.ScanFilter;

import java.util.List;

public class MyBLEScanParameters {
    private int scanPeriod;
    private List<ScanFilter> filters;

    public MyBLEScanParameters(int scanPeriod,List<ScanFilter> filters) {
        this.scanPeriod = scanPeriod;
        this.filters=filters;
    }

    public int getScanPeriod() {
        return scanPeriod;
    }

    public List<ScanFilter> getFilters() {
        return filters;
    }
}
