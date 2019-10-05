package com.moringa.gohire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.viewAvailableCarsButton) Button mViewAvailableCarsButton;
    @BindView(R.id.textViewHeader) TextView mTextViewHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewAvailableCarsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==mViewAvailableCarsButton){
            Intent intent= new Intent(MainActivity.this,AvailableCar_activity.class);
            startActivity(intent);
        }
    }
}
