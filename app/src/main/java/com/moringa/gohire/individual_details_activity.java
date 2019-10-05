package com.moringa.gohire;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.moringa.gohire.ui.main.SectionsPagerAdapter;

public class individual_details_activity extends AppCompatActivity {
    private String[] carsAvailable =new String[]{"Ranger rover","Toyota V8","Mercedes C220","BMW X5","Mazda CX5","Mazda Axela","Subaru Forester","Subaru Legacy","Subaru Outback"};
    private String[] insuranceCover =new String[]{"Comprehensive","Comprehensive","Comprehensive","Comprehensive","Comprehensive","Third party and theft","Comprehensive","Third party only","Comprehensive","Third party"};
    private String[] vehicleCondtion = new String[]{"Good","Good","Good","Good","Okay","Good","Okay","Good","Good","Good"};
    private String[] availableDriver =new String[]{"Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes","Yes"};
    private String[] amountPerDay=new String[]{"Kshs.100,000/day","Kshs.80,000/day","Kshs.70,000/day","Kshs.30,000/day","Kshs.10,000/day","Kshs.10,000/day","Kshs.15,000/day","Kshs.25,000/day","Kshs.9,000/day","Kshs.10,000/day"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_details_activity);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}