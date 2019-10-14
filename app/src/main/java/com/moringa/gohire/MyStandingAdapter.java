package com.moringa.gohire;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;

public class MyStandingAdapter extends ArrayAdapter {
    @Override
    public int getCount() {
        return mStandings.length;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        String standing = mStandings[position];
        String point = mPoints[position];
        return String.format("%s \n has :%s points",standing,point);
    }

    private Context mContext;
    private String[] mStandings;
    private  String[] mPoints;

    public MyStandingAdapter(Context mContext, int resource, String[] mStandings,String[] mPoints){
        super(mContext,resource);
        this.mContext =mContext;
        this.mStandings =mStandings;
        this.mPoints =mPoints;
    }


}
