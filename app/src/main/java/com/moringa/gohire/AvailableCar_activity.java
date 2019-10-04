package com.moringa.gohire;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AvailableCar_activity extends AppCompatActivity {
    @BindView(R.id.carModelsAvailableId) TextView mCarAvailableModel;
    @BindView(R.id.yearOfReleaseId) TextView mYearOfRealese;

    private String[] carsAvailable =getResources().getStringArray(R.array.carmodels);
    private String[] yearOfRelease =getResources().getStringArray(R.array.caryearofrelease);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablecar);
        ButterKnife.bind(this);
    }
}
