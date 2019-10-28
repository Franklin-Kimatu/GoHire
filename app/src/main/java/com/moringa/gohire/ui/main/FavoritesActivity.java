package com.moringa.gohire.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.moringa.gohire.R;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();
    ListView mFavoriteList;
    Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        Firebase.setAndroidContext(this);
        mFirebase = new Firebase("https://gohire-1b2d9.firebaseio.com/players");

         mFavoriteList =(ListView) findViewById(R.id.listFavoritesView);
        ArrayAdapter<String > adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myArrayList);
        mFavoriteList.setAdapter(adapter);

    }
}
