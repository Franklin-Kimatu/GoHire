package com.moringa.gohire.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.moringa.gohire.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main1Activity extends AppCompatActivity implements View.OnClickListener{

    private static final String[] years =new String[]{"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};

    @BindView(R.id.headertextView) TextView mHeaderTextView;
    @BindView(R.id.descriptionTextView) TextView mdecriptionTextView;


    @BindView(R.id.editTextTeam) AutoCompleteTextView mEditTextTeam;

    @BindView(R.id.buttonPay) Button mNav_Pay;
    private FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFirebaseAuth = FirebaseAuth.getInstance();


       ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,years);
       mEditTextTeam.setAdapter(adapter);


        mNav_Pay.setOnClickListener(this);


    }





    @Override
    public void onClick(View v) {
        if(v==mNav_Pay){
            String stage =mEditTextTeam.getText().toString();
            if(stage.isEmpty() || stage.length() != 4){
                Toast.makeText(Main1Activity.this,"Year value is invalid",Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(Main1Activity.this,StandingsList.class);
                intent.putExtra("stage",stage);
                startActivity(intent);
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dropdown,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logOutMenu :{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void Logout(){

        mFirebaseAuth.signOut();
        finish();
        startActivity(new Intent(Main1Activity.this,LoginActivity.class));

    }
}
