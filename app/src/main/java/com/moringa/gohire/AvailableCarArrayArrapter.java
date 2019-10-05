package com.moringa.gohire;

import android.content.Context;
import android.widget.ArrayAdapter;




public class AvailableCarArrayArrapter extends ArrayAdapter {
    public AvailableCarArrayArrapter( Context mContext, int resource,  String[] mAvailableCarModels, String[] mYearOfRelease) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mAvailableCarModels = mAvailableCarModels;
        this.mYearOfRelease = mYearOfRelease;
    }


    @Override
    public int getCount() {
        return mAvailableCarModels.length;
    }


    @Override
    public Object getItem(int position) {
        String availableCar =mAvailableCarModels[position];
        String realeseYear =mYearOfRelease[position];
        return String.format("%s \nYear of release: %s",availableCar,realeseYear);
    }

    private Context mContext;
    private String[] mAvailableCarModels;
    private String[] mYearOfRelease;
}
