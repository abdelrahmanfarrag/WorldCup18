package com.example.mana.worldcup18.ui.screens.contentactivity.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.data.database.matches.MatchDetails;
import com.example.mana.worldcup18.ui.base.BaseRecyclerAdapter;
import com.example.mana.worldcup18.ui.base.BaseViewHolder;
import com.example.mana.worldcup18.utilities.Animations;
import java.util.List;

public class MatchesAdapter extends BaseRecyclerAdapter<MatchDetails, BaseViewHolder> {

  OnViewClicked click;
  private int lastPos = -1;

  public MatchesAdapter(
      List<MatchDetails> listItems, OnViewClicked click) {
    super(listItems);
    this.click = click;
  }

  @NonNull @Override
  public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = getLayoutInflater(parent.getContext()).inflate(R.layout.single_match, parent, false);
    return new MatchesHolder(v);
  }

  @Override public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    MatchesHolder hold = (MatchesHolder) holder;
    hold.groupName.setText("Group " + getItemAtPosition(position).getGroupName());
    hold.stadiumName.setText(getItemAtPosition(position).getStadiumName());
    hold.matchTime.setText(getItemAtPosition(position).getMatchTime());
    hold.homeFlag.setBackgroundResource(getItemAtPosition(position).getHomeFlag());
    hold.homeScore.setText(String.valueOf(getItemAtPosition(position).getHomeScore()));
    hold.homeName.setText(getItemAtPosition(position).getHomeTeam());
    hold.awayFlag.setBackgroundResource(getItemAtPosition(position).getAwayFlag());
    hold.awayScore.setText(String.valueOf(getItemAtPosition(position).getAwayScore()));
    hold.awayName.setText(getItemAtPosition(position).getAwayTeam());
    hold.matchDay.setText("Match " + getItemAtPosition(position).getMatchNumber());
    Animations.adapterAnimation(hold.itemView.getContext(), hold.itemView, position, lastPos);
  }

  public class MatchesHolder extends BaseViewHolder {

    @BindView(R.id.match_group_name) TextView groupName;
    @BindView(R.id.match_stadium_name) TextView stadiumName;
    @BindView(R.id.match_time) TextView matchTime;
    @BindView(R.id.matches_home_flag) ImageView homeFlag;
    @BindView(R.id.matches_home_score) TextView homeScore;
    @BindView(R.id.matches_home_name) TextView homeName;
    @BindView(R.id.matches_away_flag) ImageView awayFlag;
    @BindView(R.id.matches_away_score) TextView awayScore;
    @BindView(R.id.matches_away_name) TextView awayName;
    @BindView(R.id.matches_day_number) TextView matchDay;
    @BindView(R.id.matches_recap_matches) Button recapMatch;


    public MatchesHolder(View itemView) {
      super(itemView);
    }

    @OnClick({ R.id.matches_recap_matches })
    public void onClick(View v) {
      switch (v.getId()) {
        case R.id.matches_recap_matches:
          click.onRecapClick(getItemAtPosition(getLayoutPosition()).getRecapId());
          break;
      }
    }
  }
}
