package com.moringa.gohire.ui.main;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringa.gohire.models.Player;
import com.moringa.gohire.R;
import com.moringa.gohire.models.Scorer;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    @BindView(R.id.scorerImageView) ImageView mScorerImageView;
    @BindView(R.id.scorersNameTextView) TextView mScorerNameTextView;
    @BindView(R.id.nationalityTextView) TextView mScorerNationalityTextView;
    @BindView(R.id.dateOfBirthTextView) TextView mDateOfBirthTextView;
    @BindView(R.id.countryBirthTextVIew) TextView mCountryTextView;
    @BindView(R.id.shirtNumberTextView) TextView mShirtNumberTextView;
    @BindView(R.id.positionTextVIew) TextView mPositionTextView;

    private Scorer mScorer;

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
        mScorerNameTextView.setText(mScorer.getPlayer().getName());
        mScorerNationalityTextView.setText(mScorer.getPlayer().getNationality());
        mDateOfBirthTextView.setText(mScorer.getPlayer().getDateOfBirth());
        mCountryTextView.setText(mScorer.getPlayer().getCountryOfBirth());
        mShirtNumberTextView.setText(mScorer.getPlayer().getShirtNumber());
        mPositionTextView.setText(mScorer.getPlayer().getPosition());
        return view;

    }

}
