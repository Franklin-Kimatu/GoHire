package com.moringa.gohire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AvailableCar_activity extends AppCompatActivity {
@BindView(R.id.nameTextView) TextView mNameTextView;
    @BindView(R.id.listView) ListView mListView;



    private String[] carsAvailable =new String[]{"Ranger rover","Toyota V8","Mercedes C220","BMW X5","Mazda CX5","Mazda Axela","Subaru Forester","Subaru Legacy","Subaru Outback"};

    private String[] yearOfRelease =new String[]{"2019","2012","2012","2010","2015","2016","2017","2012","2015"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availablecar);

        ButterKnife.bind(this);

        AvailableCarArrayArrapter adapter = new AvailableCarArrayArrapter(this, android.R.layout.simple_list_item_1, carsAvailable, yearOfRelease);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AvailableCar_activity.this, individual_details_activity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String name =intent.getStringExtra("name");
        mNameTextView.setText("Hello " +name +",\n" +"Here are some of vehicles you can hire.");

    }

}
