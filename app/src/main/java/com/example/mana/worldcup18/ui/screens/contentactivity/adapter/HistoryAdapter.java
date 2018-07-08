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
import com.example.mana.worldcup18.data.database.history.History;
import com.example.mana.worldcup18.ui.base.BaseRecyclerAdapter;
import com.example.mana.worldcup18.ui.base.BaseViewHolder;
import java.util.List;

public class HistoryAdapter extends BaseRecyclerAdapter<History, BaseViewHolder> {
  OnViewClicked clicked;
  public HistoryAdapter(
      List<History> listItems,OnViewClicked clicked) {
    super(listItems);
    this.clicked=clicked;
  }

  @NonNull @Override
  public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v =
        getLayoutInflater(parent.getContext()).inflate(R.layout.singe_world_cup_tournament, parent,
            false);
    return new HistoryHolder(v);
  }

  @Override public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    HistoryHolder hold = (HistoryHolder) holder;
    hold.wcLocation.setText(getItemAtPosition(position).getLocation());
    hold.winnerFlag.setBackgroundResource(getItemAtPosition(position).getWinnerFlag());
    hold.winnerName.setText(getItemAtPosition(position).getWinnerName());
    hold.runnerFlag.setBackgroundResource(getItemAtPosition(position).getRunnerFlag());
    hold.runnerName.setText(getItemAtPosition(position).getRunnerName());
    hold.thirdFlag.setBackgroundResource(getItemAtPosition(position).getThirdFlag());
    hold.thirdName.setText(getItemAtPosition(position).getThirdName());
    hold.firstTeam.setBackgroundResource(getItemAtPosition(position).getWinnerFlag());
    hold.firstScore.setText(String.valueOf(getItemAtPosition(position).getWinnerScore()));
    hold.secondTeam.setBackgroundResource(getItemAtPosition(position).getRunnerFlag());
    hold.secondScore.setText(String.valueOf(getItemAtPosition(position).getRunnerScore()));
    hold.stadium.setText(getItemAtPosition(position).getFinalStadium());
    hold.goldenBootWinnerFlag.setBackgroundResource(getItemAtPosition(position).getTopScorerFlag());
    hold.goldenBootWinnerName.setText(getItemAtPosition(position).getTopScorerName());
    hold.goldenBootWinnerGoals.setText(
        String.valueOf(getItemAtPosition(position).getTopScorerGoals()));
    hold.bestPlayerFlag.setBackgroundResource(getItemAtPosition(position).getBestPlayerFlag());
    hold.bestPlayerName.setText(getItemAtPosition(position).getBestPlayerName());
    hold.goldGloveWinnerFlag.setBackgroundResource(
        getItemAtPosition(position).getGoldenGloveFlag());
    hold.goldGloveWinnerName.setText(getItemAtPosition(position).getGoldenGloveName());
    if (getItemAtPosition(position).isPenalities()) {
      hold.drawnMatch.setText(hold.winnerName.getText()+" WON BY PENALTIES");
      hold.drawnMatch.setVisibility(View.VISIBLE);
    }
  }

  public class HistoryHolder extends BaseViewHolder {
    @BindView(R.id.wc_location) TextView wcLocation;
    @BindView(R.id.winner_img) ImageView winnerFlag;
    @BindView(R.id.winner_name) TextView winnerName;
    @BindView(R.id.runner_flag) ImageView runnerFlag;
    @BindView(R.id.runner_name) TextView runnerName;
    @BindView(R.id.third_img) ImageView thirdFlag;
    @BindView(R.id.third_name) TextView thirdName;
    @BindView(R.id.final_match_first_team_img) ImageView firstTeam;
    @BindView(R.id.final_match_first_team_score) TextView firstScore;
    @BindView(R.id.final_match_second_team_img) ImageView secondTeam;
    @BindView(R.id.final_match_second_team_score) TextView secondScore;
    @BindView(R.id.final_match_stadium) TextView stadium;
    @BindView(R.id.golden_boot_winner_flag) ImageView goldenBootWinnerFlag;
    @BindView(R.id.golden_boot_winner_name) TextView goldenBootWinnerName;
    @BindView(R.id.golden_boot_scored_goals) TextView goldenBootWinnerGoals;
    @BindView(R.id.best_player_winner_flag) ImageView bestPlayerFlag;
    @BindView(R.id.best_player_winner_name) TextView bestPlayerName;
    @BindView(R.id.gold_glove_winner_flag) ImageView goldGloveWinnerFlag;
    @BindView(R.id.gold_glove_winner_name) TextView goldGloveWinnerName;
    @BindView(R.id.is_final_drawn) TextView drawnMatch;
    @BindView(R.id.world_cup_btn_recap) Button recapCup;

    public HistoryHolder(View itemView) {
      super(itemView);
    }

    @OnClick({R.id.world_cup_btn_recap})
    public void onClick(View v){
      switch (v.getId()){
        case R.id.world_cup_btn_recap:
          clicked.onRecapClick(getItemAtPosition(getLayoutPosition()).getCupRecaps());
      }
    }
  }


}
