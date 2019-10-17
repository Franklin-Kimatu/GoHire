package com.moringa.gohire.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.ProgressBar;
import android.widget.TextView;


import com.moringa.gohire.R;
import com.moringa.gohire.models.Scorer;
import com.moringa.gohire.ScorersApi;
import com.moringa.gohire.ScorersClient;
import com.moringa.gohire.models.ScorersResponse;
import com.moringa.gohire.adapters.ScorersListAdapter;
;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class StandingsList extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.teamTextView) TextView mTeamTextView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private ScorersListAdapter mAdapter;
    public List<Scorer> scorers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings_list);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String stage = intent.getStringExtra("stage");


        mTeamTextView.setText("These are the top scorers in the year "+ stage);


        ScorersApi  client = ScorersClient.getHttpClient();
        Call<ScorersResponse> call = client.getScorers(stage);

        call.enqueue(new Callback<ScorersResponse>(){


            @Override
            public void onResponse(Call<ScorersResponse> call, Response<ScorersResponse> response) {

                hideProgressBar();
                if (response.isSuccessful()){

                    scorers =response.body().getScorers();

                    mAdapter =new ScorersListAdapter(StandingsList.this,scorers);

                    mRecyclerView.setAdapter(mAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(StandingsList.this);

                    DividerItemDecoration itemDivider = new DividerItemDecoration(StandingsList.this,DividerItemDecoration.HORIZONTAL);


                    mRecyclerView.setLayoutManager(layoutManager);

                    mRecyclerView.setHasFixedSize(true);
                    mRecyclerView.addItemDecoration(itemDivider);
                    showStandings();


                }else{
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<ScorersResponse> call1,Throwable t){
                showFailureMessage();
                hideProgressBar();
            }
        });
   }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong.You are not permitted to this year's data Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showStandings() {
        mRecyclerView.setVisibility(View.VISIBLE);
        ;
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
