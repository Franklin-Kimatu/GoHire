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
    @BindView(R.id.headertextView) TextView mHeaderPlayerTextView;
    @BindView(R.id.searchField) EditText mSearchField;
    @BindView(R.id.searcIimageView2) ImageView mSearchImageView;
    @BindView(R.id.recyclerViewResult_List) RecyclerView mRecyclerViewresult_List;
    private DatabaseReference mScorerDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mScorerDatabase = FirebaseDatabase.getInstance().getReference("players");

        ButterKnife.bind(this);
        mSearchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fireBaseUserSearch();
            }
        });
    }

    private void fireBaseUserSearch() {

//        FirebaseRecyclerAdapter<Scorer,ScorersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Scorer, ScorersViewHolder>(
//                Scorer.class,R.layout.searchedlistitem,
//                ScorersViewHolder.class,
//                mScorerDatabase
//        ) {
//            @Override
//            protected void onBindViewHolder(@NonNull ScorersViewHolder scorersViewHolder, int i, @NonNull Scorer scorer) {
//
//            }
//
//            @NonNull
//            @Override
//            public ScorersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return null;
//            }
//        }
    }


    public class ScorersViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public ScorersViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }
//
//        public void setDetails(){
//            TextView
//        }
    }
}
