package com.moringa.gohire.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringa.gohire.models.Player;
import com.moringa.gohire.models.Scorer;
import com.moringa.gohire.ui.main.BlankFragment;

import java.util.List;

public class ScorersPagerAdapter extends FragmentPagerAdapter {
    private List<Scorer> mScorers;

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return BlankFragment.newInstance(mScorers.get(position));
    }

    @Override
    public int getCount() {
        return mScorers.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mScorers.get(position).getPlayer().getName();
    }

    public ScorersPagerAdapter(FragmentManager fm,int behavoiur,List<Scorer> scorers){
        super(fm,behavoiur);
        mScorers =scorers;
    }
}
