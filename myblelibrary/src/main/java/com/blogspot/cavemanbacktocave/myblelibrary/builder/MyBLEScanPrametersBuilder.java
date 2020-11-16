package com.blogspot.cavemanbacktocave.myblelibrary.builder;

import android.bluetooth.le.ScanFilter;

import java.util.List;

public class MyBLEScanPrametersBuilder {
    private int scanPeriod;
    private List<ScanFilter> filters;

    public MyBLEScanPrametersBuilder(int scanPeriod) {
        this.scanPeriod = scanPeriod;
    }


    public MyBLEScanPrametersBuilder setScanPeriod(int scanPeriod) {
        this.scanPeriod = scanPeriod;
        return this;
    }

    public MyBLEScanPrametersBuilder setFilters(List<ScanFilter> filters) {
        this.filters = filters;
        return this;
    }

    public MyBLEScanParameters build(){
        return new MyBLEScanParameters(scanPeriod,filters);
    }
}
