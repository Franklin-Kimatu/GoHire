package com.moringa.gohire;

import android.content.Context;
import android.widget.ArrayAdapter;




public class AvailableCarArrayArrapter extends ArrayAdapter {
    public AvailableCarArrayArrapter( Context context, int resource, Context mContext, String[] mAvailableCarModels, String[] mYearOfRelease) {
        super(context, resource);
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
        String availablecar =mAvailableCarModels[position];
        String realeseYear =mYearOfRelease[position];
        return String.format("%s \n Year of release: %s",availablecar,realeseYear);
    }

    private Context mContext;
    private String[] mAvailableCarModels;
    private String[] mYearOfRelease;
}
