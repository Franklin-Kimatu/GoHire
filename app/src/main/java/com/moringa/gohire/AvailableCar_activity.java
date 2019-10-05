package com.moringa.gohire;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AvailableCar_activity extends AppCompatActivity {
   @BindView(R.id.listView) ListView mListView;

    private String[] carsAvailable =new String[]{"Ranger rover","Toyota V8","Mercedes C220","BMW X5","Mazda CX5","Mazda Axela","Subaru Forester","Subaru Legacy","Subaru Outback"};

    private String[] yearOfRelease =new String[]{"2019","2012","2012","2010","2015","2016","2017","2012","2015"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablecar);
        ButterKnife.bind(this);

        AvailableCarArrayArrapter adapter =new AvailableCarArrayArrapter(this,android.R.layout.simple_list_item_1,carsAvailable,yearOfRelease);
        mListView.setAdapter(adapter);
    }
}
