package com.moringa.gohire.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;

import android.view.View;

import android.widget.ProgressBar;
import android.widget.TextView;


import com.google.android.material.snackbar.Snackbar;
import com.moringa.gohire.R;
import com.moringa.gohire.models.Scorer;
import com.moringa.gohire.ScorersApi;
import com.moringa.gohire.ScorersClient;
import com.moringa.gohire.models.ScorersResponse;
import com.moringa.gohire.adapters.ScorersListAdapter;
;


import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class StandingsList extends AppCompatActivity {

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.teamTextView) TextView mTeamTextView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.dateTextView) TextView mDateTextView;

    private ScorersListAdapter mAdapter;
    public List<Scorer> scorers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings_list);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String stage = intent.getStringExtra("stage");
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        mDateTextView.setText(currentDate);
        mTeamTextView.setText("Top scorers year, "+ stage);


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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
   }

   Scorer deletedPlayer =null;
    List<Scorer> archievedPlayers = new ArrayList<>();

   ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT) {
       @Override
       public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
           return false;
       }

       @Override
       public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
           int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:

                    deletedPlayer  = scorers.get(position);
                    scorers.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    Snackbar.make(mRecyclerView, "Deleted player",Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    scorers.add(position,deletedPlayer);
                                    mAdapter.notifyItemInserted(position);
                                }
                            }).show();
                  break;
                case ItemTouchHelper.RIGHT:
                    Scorer playerName =scorers.get(position);
                    archievedPlayers.add(playerName);
                    scorers.remove(position);
                    mAdapter.notifyItemRemoved(position);
                    Snackbar.make(mRecyclerView, "Player archived",Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    archievedPlayers.remove(archievedPlayers.lastIndexOf(playerName));
                                    scorers.add(position,playerName);
                                    mAdapter.notifyItemInserted(position);
                                }
                            }).show();
                    break;
            }
       }

       @Override
       public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
           new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                   .addSwipeLeftBackgroundColor(ContextCompat.getColor(StandingsList.this,R.color.accent))
                   .addSwipeLeftActionIcon(R.drawable.ic_delete_black_24dp)
                   .addSwipeRightBackgroundColor(ContextCompat.getColor(StandingsList.this,R.color.accent))
                   .addSwipeRightActionIcon(R.drawable.ic_archive_black_24dp)
                   .create()
                   .decorate();

           super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
       }
   };

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
