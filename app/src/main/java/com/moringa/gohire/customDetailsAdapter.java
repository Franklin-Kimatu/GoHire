package com.moringa.gohire;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class customDetailsAdapter extends ArrayAdapter {
    public customDetailsAdapter( Context context, int resource,  String[] mCarModels, String[] mInsurance, String[] mVehicleConditions, String[] mAvailableDriver, String[] mAmount) {
        super(context, resource);
        this.context = context;
        this.mCarModels = mCarModels;
        this.mInsurance = mInsurance;
        this.mVehicleConditions = mVehicleConditions;
        this.mAvailableDriver = mAvailableDriver;
        this.mAmount = mAmount;
    }

    private Context context;
    private String[] mCarModels;
    private String[] mInsurance;
    private String[] mVehicleConditions;
    private String[] mAvailableDriver;
    private String[] mAmount;
    @Override
    public int getCount() {
        return mCarModels.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String model =mCarModels[position];
        String insuranceCover= mInsurance[position];
        String vehicleCondition =mVehicleConditions[position];
        String availableDriver =mAvailableDriver[position];
        String amountToPay =mAmount[position];
        return String.format("%s  %s %s %s %s ",model,insuranceCover,vehicleCondition,availableDriver,amountToPay);
    }
}
