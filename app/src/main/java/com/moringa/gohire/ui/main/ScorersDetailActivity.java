package com.moringa.gohire.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.moringa.gohire.models.Player;
import com.moringa.gohire.R;
import com.moringa.gohire.adapters.ScorersPagerAdapter;
import com.moringa.gohire.models.Scorer;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScorersDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewPager;
    private ScorersPagerAdapter adapterViewPager;
    List<Scorer> mScorers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorers_detail);

        ButterKnife.bind(this);

        mScorers = Parcels.unwrap(getIntent().getParcelableExtra("scorers"));
        int startingPosition = getIntent().getIntExtra("position",0);

        adapterViewPager = new ScorersPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mScorers);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
