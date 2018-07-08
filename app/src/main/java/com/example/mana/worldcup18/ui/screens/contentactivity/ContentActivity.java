package com.example.mana.worldcup18.ui.screens.contentactivity;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.ui.base.BaseActivity;
import com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.history_ui.HistoryFragment;
import com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.matches_ui.MatchesFragment;
import com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.news_ui.NewsFragment;
import com.example.mana.worldcup18.utilities.FragmentUtils;

public class ContentActivity extends BaseActivity {

  @BindView(R.id.partic_cont) FrameLayout participantsContainer;
  @BindView(R.id.matchces_cont) FrameLayout matchesContainer;
  @BindView(R.id.history_cont) FrameLayout historyContainer;
  @BindView(R.id.main_contaienr) FrameLayout container;

  @Override public int setLayoutId() {
    return R.layout.content_activity;
  }

  @Override public void setupToolbar() {

  }

  @Override public void init() {
  }
  @OnClick({ R.id.partic_cont, R.id.matchces_cont, R.id.history_cont })
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.partic_cont:
        FragmentUtils.showFragmentOnActivity(getContext(), NewsFragment.getInstance(),
            R.id.main_contaienr, false);
        break;
      case R.id.matchces_cont:
        FragmentUtils.showFragmentOnActivity(getContext(), MatchesFragment.getInstance(),
            R.id.main_contaienr, false);
        break;
      case R.id.history_cont:
        FragmentUtils.showFragmentOnActivity(getContext(), HistoryFragment.getInstance(),
            R.id.main_contaienr, false);
        break;
    }
  }
}
