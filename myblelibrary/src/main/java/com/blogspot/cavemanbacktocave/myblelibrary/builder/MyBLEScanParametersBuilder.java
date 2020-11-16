package com.blogspot.cavemanbacktocave.myblelibrary.builder;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.ParcelUuid;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MyBLEScanParametersBuilder {
    /**https://www.vogella.com/tutorials/DesignPatternBuilder/article.html*/
    private int scanPeriodSeconds;
    private List<ScanFilter> filters=null;
    private ScanSettings scanSettings;

    public MyBLEScanParametersBuilder(int scanPeriodSeconds) {
        this.scanPeriodSeconds = scanPeriodSeconds;
    }




    public MyBLEScanParametersBuilder setFilters(List<ScanFilter> filters) {
        this.filters = filters;
        return this;
    }

    public MyBLEScanParametersBuilder setScanSettings(ScanSettings scanSettings){
        this.scanSettings=scanSettings;
        return this;
    }

    public MyBLEScanParameters build(){
        return new MyBLEScanParameters(scanPeriodSeconds,filters,scanSettings);
    }


}
