package com.example.mana.worldcup18.ui.screens.contentactivity.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.data.database.knockout.Knock;
import com.example.mana.worldcup18.ui.base.BaseRecyclerAdapter;
import com.example.mana.worldcup18.ui.base.BaseViewHolder;
import com.example.mana.worldcup18.utilities.Animations;
import java.util.List;

public class KnockAdapter extends BaseRecyclerAdapter<Knock, BaseViewHolder> {

  private OnViewClicked clicked;
  private int lastPos = -1;

  public KnockAdapter(
      List<Knock> listItems, OnViewClicked clicked) {
    super(listItems);
    this.clicked = clicked;
  }

  @NonNull @Override
  public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = getLayoutInflater(parent.getContext()).inflate(R.layout.single_match, parent, false);
    return new KnockHolder(v);
  }

  @Override public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    KnockHolder hold = (KnockHolder) holder;
    hold.groupName.setText(getItemAtPosition(position).getRound());
    hold.stadiumName.setText(getItemAtPosition(position).getStadiumName());
    hold.matchTime.setText(getItemAtPosition(position).getDate());
    hold.drawnMatch.setText(getItemAtPosition(position).getDrawn());
    hold.drawnMatch.setVisibility(View.VISIBLE);
    hold.homeFlag.setBackgroundResource(getItemAtPosition(position).getHomeFlag());
    hold.homeScore.setText(String.valueOf(getItemAtPosition(position).getHomeScore()));
    hold.homeName.setText(getItemAtPosition(position).getHomeTeam());
    hold.awayFlag.setBackgroundResource(getItemAtPosition(position).getAwayFlag());
    hold.awayScore.setText(String.valueOf(getItemAtPosition(position).getAwayScore()));
    hold.awayName.setText(getItemAtPosition(position).getAwayTeam());
    Animations.fadeAdapterAnimation(hold.itemView.getContext(), hold.itemView, position, lastPos);
    hold.matchDay.setVisibility(View.GONE);

  }

  public class KnockHolder extends BaseViewHolder {
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
    @BindView(R.id.is_match_drawn) TextView drawnMatch;

    @BindColor(R.color.camely) int camely;

    @BindString(R.string.round16) String round16;

    private KnockHolder(View itemView) {
      super(itemView);
    }

    @OnClick({ R.id.matches_recap_matches })
    public void OnClick(View view) {
      switch (view.getId()) {
        case R.id.matches_recap_matches:
          clicked.onRecapClick(getItemAtPosition(getLayoutPosition()).getRecaps());
      }
    }
  }
}
