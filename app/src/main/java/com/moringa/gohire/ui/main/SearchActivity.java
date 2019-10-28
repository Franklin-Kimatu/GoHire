package com.moringa.gohire.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.gohire.R;
import com.moringa.gohire.models.Scorer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    private EditText mSearchField;
    private ImageView mSearchImageView;
    private RecyclerView mSearchList;
    private DatabaseReference mScorerDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mScorerDatabase = FirebaseDatabase.getInstance().getReference("players");

        mSearchField =(EditText)findViewById(R.id.searchField);
        mSearchImageView =(ImageView) findViewById(R.id.searchIimageView2);
        mSearchList =(RecyclerView) findViewById(R.id.recyclerViewResult_List);


        mSearchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fireBaseUserSearch();
            }
        });
    }

//    private void fireBaseUserSearch() {
//
//        FirebaseRecyclerAdapter<Scorer,ScorerViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Scorer, ScorerViewHolder>(
//               Scorer.class,
//               R.layout.searchedlistitem,
//                ScorerViewHolder.class,
//
//        ) {
//            @Override
//            protected void onBindViewHolder(@NonNull ScorerViewHolder holder, int position, @NonNull Scorer model) {
//
//            }
//
//            @NonNull
//            @Override
//            public ScorerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return null;
//            }
//        }
//    }


    public class ScorerViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public ScorerViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }
//
//        public void setDetails(){
//            TextView
//        }
    }
}
