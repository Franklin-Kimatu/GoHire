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
        // mTeamTextView.setText("Here are all standing for this stage" +stage);

//        ScorersApi client = ScorersClient.getHttpClient();
//        Call<StandingsResponse> call = client.getStandings(stage,"standings");
//
//        call.enqueue( new Callback<StandingsResponse>(){
//            @Override
//            public void onResponse(Call<StandingsResponse> call, Response<StandingsResponse> response) {
//
//                hideProgressBar();
//                if (response.isSuccessful()) {
//                    List<Standing> standingList = response.body().getStandings();
//                    String[] standings = new String[standingList.size()];
//                    Integer[] tables = new Integer[standingList.size()];
//
//                    for (int i = 0; i < standings.length; i++) {
//                        standings[i] = standingList.get(i).getStage();
//                    }
//
//                    for (int i = 0; i < tables.length; i++) {
//                        Table table = standingList.get(i).getTable().get(0);
//                        tables[i] = table.getPoints();
//                    }
//
//                    ArrayAdapter adapter = new MyStandingAdapter(StandingsList.this, android.R.layout.simple_list_item_1, standings, tables);
//                    mListViewStandings.setAdapter(adapter);
//
//                    showStandings();
//
//               }else {
//                   showUnsuccessfulMessage();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ScorersResponse> call1, Throwable t){
//                hideProgressBar();
//                showFailureMessage();
//            }
//        });

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

//                    for (Scorer scorer:scorers){
//                        String content ="";
//                        content += scorer.getPlayer().getName() +"\n";
//                        content += scorer.getNumberOfGoals().toString() +"\n";
//                        content +=scorer.getTeam().getName() + "\n";
//
//
//                        mTeamTextView.append(content);
//
//                    }
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
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
