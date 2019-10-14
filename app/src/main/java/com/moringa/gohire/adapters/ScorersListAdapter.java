package com.moringa.gohire.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringa.gohire.R;
import com.moringa.gohire.Scorer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScorersListAdapter extends RecyclerView.Adapter<ScorersListAdapter.ScorerViewHolder> {

    private List<Scorer> mScorers;
    private Context mContext;

    public ScorersListAdapter(Context context,List<Scorer> scorers){
        mContext=context;
        mScorers =scorers;
    }

    @NonNull
    @Override
    public ScorerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scorers_list_item,parent,false);
        ScorerViewHolder viewHolder = new ScorerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScorerViewHolder holder, int position) {
        holder.bindScorer(mScorers.get(position));
    }

    @Override
    public int getItemCount() {
        return mScorers.size();
    }

    public class ScorerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.scorerImageView) ImageView ScorerImageView;
        @BindView(R.id.scorersNameTextView) TextView mScorerNameTextView;
        @BindView(R.id.nationalityTextView) TextView mNationalityTextView;

        private Context mContext;

        public ScorerViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext =itemView.getContext();
        }
        public void bindScorer(Scorer player){
            mScorerNameTextView.setText(player.getPlayer().getName());
            mNationalityTextView.setText("Nationality: "+player.getPlayer().getNationality());
        }
    }
}
