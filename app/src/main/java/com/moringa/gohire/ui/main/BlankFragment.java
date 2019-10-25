package com.moringa.gohire.ui.main;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringa.gohire.models.PPlayer;
import com.moringa.gohire.models.Player;
import com.moringa.gohire.R;
import com.moringa.gohire.models.Scorer;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements View.OnClickListener{
//    @BindView(R.id.scorerImageView) ImageView mScorerImageView;
    @BindView(R.id.scorersNameTextView) TextView mScorerNameTextView;
    @BindView(R.id.firstNameTextView) TextView mFirstNameTextView;
    @BindView(R.id.nationalityTextView) TextView mScorerNationalityTextView;
    @BindView(R.id.dateOfBirthTextView) TextView mDateOfBirthTextView;
    @BindView(R.id.countryBirthTextVIew) TextView mCountryTextView;
    @BindView(R.id.shirtNumberTextView) TextView mShirtNumberTextView;
    @BindView(R.id.positionTextVIew) TextView mPositionTextView;
    @BindView(R.id.rateSpinnerRate ) Spinner mRateSpinner;
    @BindView(R.id.savePlayerButton) Button mSavePlayerButton;

    private Scorer mScorer;
    DatabaseReference databasePlayers;
    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(Scorer scorer){
        BlankFragment blankFragment = new BlankFragment();
        Bundle args  =new Bundle();

        args.putParcelable("scorer", Parcels.wrap(scorer));

        blankFragment.setArguments(args);
        return blankFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScorer = Parcels.unwrap(getArguments().getParcelable("scorer"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);

        ButterKnife.bind(this,view);

        //List<String> scorer = new ArrayList<>();
        mFirstNameTextView.setText("Firstname: "+mScorer.getPlayer().getFirstName());
        mScorerNameTextView.setText("Common name: "+mScorer.getPlayer().getName());
        mScorerNationalityTextView.setText("Nationality: "+mScorer.getPlayer().getNationality());
        mDateOfBirthTextView.setText("DOB: "+mScorer.getPlayer().getDateOfBirth());
        mCountryTextView.setText("Country of birth: "+mScorer.getPlayer().getCountryOfBirth());
       mShirtNumberTextView.setText("Shirt number: "+String.valueOf(mScorer.getPlayer().getShirtNumber()));
        mPositionTextView.setText("Position: "+mScorer.getPlayer().getPosition());
        mSavePlayerButton.setOnClickListener(this);

        return view;

    }


    @Override
    public void onClick(View v) {
        if (v==mSavePlayerButton){
            databasePlayers = FirebaseDatabase.getInstance().getReference("players");
            databasePlayers.push().setValue(mScorer);
            Toast.makeText(getContext(),"Player added",Toast.LENGTH_SHORT).show();

        }

    }
}
