package com.moringa.gohire.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.moringa.gohire.Competition;
import com.moringa.gohire.MyStandingAdapter;
import com.moringa.gohire.Player;
import com.moringa.gohire.R;
import com.moringa.gohire.Scorer;
import com.moringa.gohire.ScorersApi;
import com.moringa.gohire.ScorersClient;
import com.moringa.gohire.ScorersResponse;
import com.moringa.gohire.Team;
;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class StandingsList extends AppCompatActivity {

//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.teamTextView) TextView mTeamTextView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.liistView) ListView mListViewStandings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings_list);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String stage = intent.getStringExtra("stage");


        mTeamTextView.setText("Here are the scorers for the years " +stage);


        ScorersApi  client = ScorersClient.getHttpClient();
        Call<ScorersResponse> call = client.getScorers(stage);

        call.enqueue(new Callback<ScorersResponse>(){


            @Override
            public void onResponse(Call<ScorersResponse> call, Response<ScorersResponse> response) {

                hideProgressBar();
                if (response.isSuccessful()){

                    List<Scorer> scorersList =response.body().getScorers();
                    String[] scorers = new String [scorersList.size()];
                    String[] teams = new String[scorersList.size()];

                    for (int i = 0; i<scorers.length; i++){
                        scorers[i] = scorersList.get(i).getPlayer().getName();

                    }
                    for (int i= 0; i<teams.length; i++){

                        teams[i] =Team.class.getName();

                    }

                    ArrayAdapter adapter = new MyStandingAdapter(StandingsList.this,android.R.layout.simple_list_item_1,scorers,teams);
                    mListViewStandings.setAdapter(adapter);
                    showStandings();

                }else{
                    showFailureMessage();
                }
            }

            @Override
            public void onFailure(Call<ScorersResponse> call1,Throwable t){
                showUnsuccessfulMessage();;
            }
        });
   }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showStandings() {
        mListViewStandings.setVisibility(View.VISIBLE);
        mTeamTextView.setVisibility(View.GONE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
