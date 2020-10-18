package com.blogspot.cavemanbacktocave.mybleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyBLEDeviceListAdapter extends RecyclerView.Adapter<MyBLEDeviceListAdapter.MyBLEDeviceListViewHolder> {



    @NonNull
    @Override
    public MyBLEDeviceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_device_list,parent,false);
        return new MyBLEDeviceListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBLEDeviceListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyBLEDeviceListViewHolder extends RecyclerView.ViewHolder{

        public MyBLEDeviceListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
