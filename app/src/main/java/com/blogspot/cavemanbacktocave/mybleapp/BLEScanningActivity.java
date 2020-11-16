package com.blogspot.cavemanbacktocave.mybleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.blogspot.cavemanbacktocave.myblelibrary.ble.MyScan;

public class BLEScanningActivity extends AppCompatActivity {

    private RecyclerView bleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_l_e_scanning);
        bleList=findViewById(R.id.bleList);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        bleList.setLayoutManager(layoutManager);


        MyScan.getInstance().startBLEScan();

    }
}