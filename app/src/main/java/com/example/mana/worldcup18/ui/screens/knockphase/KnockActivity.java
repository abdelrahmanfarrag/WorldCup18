package com.example.mana.worldcup18.ui.screens.knockphase;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.data.database.knockout.Knock;
import com.example.mana.worldcup18.ui.base.BaseActivity;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.KnockAdapter;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.OnViewClicked;
import com.example.mana.worldcup18.ui.screens.youtubeactivity.YoutubeVideos;
import com.example.mana.worldcup18.utilities.ActivityUtils;
import com.example.mana.worldcup18.utilities.Common;
import com.example.mana.worldcup18.utilities.Constants;
import java.util.ArrayList;

public class KnockActivity extends BaseActivity implements OnViewClicked {

  //Teams Name
  @BindString(R.string.russia) String russia;
  @BindString(R.string.uruguay) String uruguay;
  @BindString(R.string.portugal) String portugal;
  @BindString(R.string.spain) String spain;
  @BindString(R.string.france) String france;
  @BindString(R.string.denmark) String denmark;
  @BindString(R.string.argentina) String argentina;
  @BindString(R.string.croatia) String croatia;
  @BindString(R.string.brazil) String brazil;
  @BindString(R.string.switherland) String swith;
  @BindString(R.string.mexico) String mexico;
  @BindString(R.string.sweden) String sweden;
  @BindString(R.string.belguim) String belguim;
  @BindString(R.string.england) String england;
  @BindString(R.string.colombia) String colombia;
  @BindString(R.string.japan) String japan;
  @BindString(R.string.round16) String round16;
  @BindString(R.string.quarterfinal) String quarterFinal;

  @BindString(R.string.kaliningrad) String kaliningrad;
  @BindString(R.string.spartak) String spartak;
  @BindString(R.string.volgograd) String volvograd;
  @BindString(R.string.saransk) String saransk;
  @BindString(R.string.samara) String samara;
  @BindString(R.string.rostov) String rostov;
  @BindString(R.string.nizhny) String nizhny;
  @BindString(R.string.kazan) String kazan;
  @BindString(R.string.ekater) String ekater;
  @BindString(R.string.fisht) String fisht;
  @BindString(R.string.peters) String peterspurg;
  @BindString(R.string.moscow) String luMoscow;

  @BindDrawable(R.drawable.fisht_stadium) Drawable fishtStadium;

  @BindView(R.id.knock_matches) RecyclerView knockMatches;

  private KnockViewModel viewModel;
  private KnockAdapter adapter;

  @Override public int setLayoutId() {
    return R.layout.knock_activity;
  }

  @Override protected void onPause() {
    super.onPause();
    viewModel.deleteKnockMatches();
  }

  @Override protected void onResume() {
    super.onResume();
    insertRound16Matches();
    insertRoundQuarterFinal();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    viewModel.deleteKnockMatches();
  }

  @Override public void setupToolbar() {

  }

  private void setupRecycler() {
    adapter = new KnockAdapter(new ArrayList<>(), this);
    knockMatches.setLayoutManager(new LinearLayoutManager(getContext()));
    viewModel.getKnockMatches().observe(this, matches -> adapter.addToAdapter(matches));
    knockMatches.setAdapter(adapter);
  }

  @Override public void init() {
    viewModel = ViewModelProviders.of(this).get(KnockViewModel.class);
    setupRecycler();
    viewModel.deleteKnockMatches();
  }

  private void insertRound16Matches() {
    Knock firstMatch =
        new Knock(france, 4, R.drawable.france, argentina, 3, R.drawable.argentina, kazan,
            "Sat, 6/30", "6C6oOcDFmLY", R.drawable.kazan, round16, "");

    Knock secondMatch =
        new Knock(uruguay, 2, R.drawable.uruguay, portugal, 1, R.drawable.portugal, fisht,
            "Sat, 6/30", "auqyXFLZ_zw", R.drawable.fisht_stadium, round16, "");

    Knock thirdMatch = new Knock(spain, 1, R.drawable.spain, russia, 1, R.drawable.russia, luMoscow,
        "Sun, 7/1", "gHPke43iqNg", R.drawable.luzinkhi, round16, "Russia win on penalties (3 - 4)");

    Knock fourthMatch =
        new Knock(croatia, 1, R.drawable.croatia, denmark, 1, R.drawable.denmark, nizhny,
            "Sun, 7/1", "5_iIW2DZ8nc", R.drawable.niznhy, round16,
            "Croatia win on penalties (3 - 2)");

    Knock fifthMatch =
        new Knock(brazil, 2, R.drawable.brazil, mexico, 0, R.drawable.mexico, samara, "Mon, 7/2",
            "kYIf8I1dvdo", R.drawable.samara, round16, "");
    Knock sexthMatch =
        new Knock(belguim, 3, R.drawable.belgium, japan, 2, R.drawable.japan, rostov, "Mon, 7/2",
            "fJeJuc27ggE", R.drawable.rostov, round16, "");
    Knock seventhMatch =
        new Knock(sweden, 1, R.drawable.sweden, swith, 0, R.drawable.switzerland, peterspurg,
            "Tues, 7/3", "012FkPcI1uE", R.drawable.perterspurg, round16, "");
    Knock eighthMatch =
        new Knock(colombia, 1, R.drawable.colombia, england, 1, R.drawable.england, spartak,
            "Tues, 7/3", "RbmaLT320hw", R.drawable.spartak, round16,
            "England win on penalties (3 - 4)");

    viewModel.insertKnockMatch(firstMatch);
    viewModel.insertKnockMatch(secondMatch);
    viewModel.insertKnockMatch(thirdMatch);
    viewModel.insertKnockMatch(fourthMatch);
    viewModel.insertKnockMatch(fifthMatch);
    viewModel.insertKnockMatch(sexthMatch);
    viewModel.insertKnockMatch(seventhMatch);
    viewModel.insertKnockMatch(eighthMatch);
  }

  private void insertRoundQuarterFinal() {
    Knock firstMatch =
        new Knock(uruguay, 0, R.drawable.uruguay, france, 2, R.drawable.france, nizhny
            , "Fri, 7/6", "_YK4o-Gbppg", 0, quarterFinal, "");
    Knock secondMatch =
        new Knock(brazil, 1, R.drawable.brazil, belguim, 2, R.drawable.belgium, kazan
            , "Fri, 7/6", "t8IK0ZqfxNI", 0, quarterFinal, "");
    Knock thirdMatch =
        new Knock(sweden, 0, R.drawable.sweden, england, 2, R.drawable.england, samara, "Sat, 7/7",
            "Wr7-HtVlAdI", 0, quarterFinal, "");
    Knock fourthMatch =
        new Knock(russia, 2, R.drawable.russia, croatia, 2, R.drawable.croatia, fisht,
            "Sat, 7/7", "wjU8j2bj3RY", 0, quarterFinal, "Croatia win on penalties (3 - 4)");

    viewModel.insertKnockMatch(firstMatch);
    viewModel.insertKnockMatch(secondMatch);
    viewModel.insertKnockMatch(thirdMatch);
    viewModel.insertKnockMatch(fourthMatch);
  }

  @Override public void onRecapClick(String id) {
    if (id.equalsIgnoreCase("")) {
      Common.ToastMsg(getContext(),"NOT READY YET");
    } else {
      Intent intent = new Intent(getContext(), YoutubeVideos.class);
      intent.putExtra(Constants.EXTRA_VIDEO_ID, id);
      ActivityUtils.dataIntent(getContext(), intent);
    }
  }
}
