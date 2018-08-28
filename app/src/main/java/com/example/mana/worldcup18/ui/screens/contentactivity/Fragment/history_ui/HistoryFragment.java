package com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.history_ui;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.data.database.history.History;
import com.example.mana.worldcup18.ui.base.BaseFragment;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.HistoryAdapter;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.OnViewClicked;
import com.example.mana.worldcup18.ui.screens.youtubeactivity.YoutubeVideos;
import com.example.mana.worldcup18.utilities.ActivityUtils;
import com.example.mana.worldcup18.utilities.Common;
import com.example.mana.worldcup18.utilities.Constants;
import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends BaseFragment implements OnViewClicked {

  @BindView(R.id.wc_list) RecyclerView wcList;
  @BindView(R.id.included_layout) View singleLayout;
  @BindView(R.id.floating_btn) FloatingActionButton button;
  @BindView(R.id.cup_container) FrameLayout frame;

  private HistoryViewModel viewModel;
  private HistoryAdapter adapter;
  private IncludeLayout includeLayout;
  private Dialog d;
  @BindString(R.string.no_url_msg) String noUrl;

  public static HistoryFragment getInstance() {
    return new HistoryFragment();
  }

  @Override protected int setFragmentLayout() {
    return R.layout.fragment_history;
  }

  @Override protected void init(Bundle savedState) {
    viewModel = ViewModelProviders.of(getContext()).get(HistoryViewModel.class);
    instantiateList();
    viewModel.getWcHistory().observe(getContext(),
        (List<History> matches) -> adapter.addToAdapter(matches));
    includeLayout = new IncludeLayout();
    ButterKnife.bind(includeLayout, singleLayout);
  }

  @Override public void onResume() {
    super.onResume();
    insertCup();
  }

  @Override public void onPause() {
    super.onPause();
    deleteAll();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    deleteAll();
  }

  @OnClick({ R.id.floating_btn })
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.floating_btn:
        d = Common.transparentDialog(getContext(), R.layout.search_dialog, R.style.dialog_sty);
        AutoCompleteTextView autoCompleteTextView = d.findViewById(R.id.auto_complete_wc_search_tv);
        String[] data = getContext().getResources().getStringArray(R.array.cup2);
        setupAutoComplete(autoCompleteTextView, data);
        Button b = d.findViewById(R.id.perform_search);
        b.setOnClickListener(v1 -> {
          Handler h = new Handler();
          getSingleCup(autoCompleteTextView.getText().toString(), h);
          d.dismiss();
        });
        d.show();
        break;
    }
  }

  private void deleteAll() {
    viewModel.deleteAll();
  }

  private void getSingleCup(String searchWord, Handler handler) {
    History history = viewModel.selectCup(searchWord);
    handler.postDelayed(() -> {
      History h = viewModel.selectCup(searchWord);
      frame.setVisibility(View.VISIBLE);
      wcList.setVisibility(View.INVISIBLE);
      wcList.setClickable(false);
      includeLayout.wcLocation.setText(h.getLocation());
      includeLayout.winnerFlag.setBackgroundResource(h.getWinnerFlag());
      includeLayout.winnerName.setText(h.getWinnerName());
      includeLayout.runnerFlag.setBackgroundResource(h.getRunnerFlag());
      includeLayout.runnerName.setText(h.getRunnerName());
      includeLayout.thirdName.setText(h.getThirdName());
      includeLayout.thirdFlag.setBackgroundResource(h.getThirdFlag());
      includeLayout.firstTeam.setBackgroundResource(h.getWinnerFlag());
      includeLayout.firstScore.setText(String.valueOf(h.getWinnerScore()));
      includeLayout.secondTeam.setBackgroundResource(h.getRunnerFlag());
      includeLayout.secondScore.setText(String.valueOf(h.getRunnerScore()));
      includeLayout.stadium.setText(h.getFinalStadium());
      includeLayout.goldenBootWinnerName.setText(h.getTopScorerName());
      includeLayout.goldenBootWinnerFlag.setBackgroundResource(h.getTopScorerFlag());
      includeLayout.goldenBootWinnerGoals.setText(String.valueOf(h.getTopScorerGoals()));
      includeLayout.bestPlayerName.setText(h.getBestPlayerName());
      includeLayout.bestPlayerFlag.setBackgroundResource(h.getBestPlayerFlag());
      includeLayout.goldGloveWinnerName.setText(h.getGoldenGloveName());
      includeLayout.goldGloveWinnerFlag.setBackgroundResource(h.getGoldenGloveFlag());
      includeLayout.recapCup.setOnClickListener(v -> {
        Intent intent = new Intent(getContext(), YoutubeVideos.class);
        intent.putExtra(Constants.EXTRA_VIDEO_ID, h.getCupRecaps());
        ActivityUtils.dataIntent(getContext(), intent);
      });
      if (h.isPenalities()) {
        includeLayout.drawnMatch.setVisibility(View.VISIBLE);
        includeLayout.drawnMatch.setText(h.getWinnerName() + " WON BY PENALTIES");
      }
    }, 1000);
  }

  private void insertCup() {

    History uru1930 = new History("Uruguay 1930", "URUGUAY", R.drawable.uruguay, 4, "ARGENTINA",
        R.drawable.argentina, 2, "UNITED STATES", R.drawable.usa,
        "Estadio Centenario, Montevideo", "Guillermo Stábile", R.drawable.argentina, 8,
        "José Nasazzi", R.drawable.uruguay, "Enrique Ballestrero", R.drawable.uruguay,
        "m073U0j4bqE", false);

    History italy1934 = new History("Italy 1934", "ITALY", R.drawable.italy, 2, " Czechoslovakia"
        , R.drawable.szeck, 1, "GERMANY", R.drawable.germany, "Stadio Nazionale PNF, Rome",
        "Oldřich Nejedlý", R.drawable.szeck, 5, "Giuseppe Meazza", R.drawable.italy,
        " Ricardo Zamora",
        R.drawable.spain, "EqLQJq3HbWE", false);

    History france1938 =
        new History("France 1938", "ITALY", R.drawable.italy, 4, "HUNGARY", R.drawable.hungary,
            2, "BRAZIL", R.drawable.brazil, "Stade de Colombes, Paris", "Leônidas",
            R.drawable.brazil, 7, "Leônidas", R.drawable.brazil, "František Plánička",
            R.drawable.szeck, "9s4FTKz5gVs", false);

    History brazile1950 =
        new History("Brazil 1950", "URUGUAY", R.drawable.uruguay, 2, "BRAZIL", R.drawable.brazil
            , 1, "SWEDEN", R.drawable.sweden, "Maracanã, Rio de Janeiro", "Ademir",
            R.drawable.brazil, 8, "Zizinho", R.drawable.brazil, "Roque Máspoli", R.drawable.uruguay,
            "-_wwxwaUqQk",
            false);

    History switherland1954 =
        new History("Switzerland 1954", "WEST GERMANY", R.drawable.germany, 3, "HUNGARY",
            R.drawable.hungary, 2, "AUSTRIA", R.drawable.austria, "Wankdorfstadion, Bern",
            "Sándor Kocsis", R.drawable.hungary, 11, "Ferenc Puskás", R.drawable.hungary,
            "Gyula Grosics", R.drawable.hungary, "maOccqMzJTw", false);

    History sweden1958 = new History("Sweden 1958", "BRAZIL", R.drawable.brazil, 5, "SWEDEN",
        R.drawable.sweden, 2, "FRANCE", R.drawable.france, "Råsundastadion, Solna", "Just Fontaine",
        R.drawable.france, 13, "Didi", R.drawable.brazil, "Harry Gregg",
        R.drawable.northern_ireland, "5ibbmjIqLss", false);

    History chile1962 = new History("Chile 1962", "BRAZIL", R.drawable.brazil, 3, "Czechoslovakia",
        R.drawable.szeck, 1, "CHILE", R.drawable.chile, "Estadio Nacional, Santiago", "Garrincha",
        R.drawable.brazil, 4, "Garrincha", R.drawable.brazil, "Viliam Schrojf", R.drawable.szeck,
        "FnV_ezpSMI0", false);

    History england1966 =
        new History("England 1966", "ENGLAND", R.drawable.england, 4, "WEST GERMANY",
            R.drawable.germany, 2, "PORTUGAL", R.drawable.portugal, "Wembley Stadium, London",
            "Eusébio", R.drawable.portugal, 9, "Bobby Charlton", R.drawable.england, "Gordon Banks",
            R.drawable.england
            , "FMDuHPvNtgg", false);
    History mexico1970 =
        new History("Mexico 1970", "BRAZIL", R.drawable.brazil, 4, "ITALY", R.drawable.italy, 1,
            "WEST GERMANY", R.drawable.germany, "Estadio Azteca, Mexico City", "Gerd Müller",
            R.drawable.germany, 10, "Pelé", R.drawable.brazil, "Ladislao Mazurkiewicz",
            R.drawable.uruguay, "z2PJnLgOPyo", false);

    History westGermany1974 =
        new History("West Germany 1974", "WEST GERMANY", R.drawable.germany, 2, "NETHERLANDS",
            R.drawable.netherlands, 1, "POLAND", R.drawable.poland, "Olympiastadion, Munich",
            "Grzegorz Lato", R.drawable.poland, 7, "Johan Cruyff", R.drawable.netherlands,
            "Sepp Maier", R.drawable.germany, "AtLdz22fNZo", false);

    History argentina1978 =
        new History("Argentina 1978", "ARGENTINA", R.drawable.argentina, 3, "NETHERLANDS",
            R.drawable.netherlands, 1, "BRAZIL", R.drawable.brazil,
            "Monumental de Nuñez, Buenos Aires", "Mario Kempes", R.drawable.argentina, 6,
            "Mario Kempes", R.drawable.argentina, "Ubaldo Fillol", R.drawable.argentina,
            "Pe1se2P6sxI", false);

    History spain1982 =
        new History("Spain 1982", "ITALY", R.drawable.italy, 3, "WEST GERMANY", R.drawable.germany,
            1, "POLAND", R.drawable.poland, "Santiago Bernabéu, Madrid", "Paolo Rossi",
            R.drawable.italy, 6, "Paolo Rossi", R.drawable.italy, "Dino Zoff", R.drawable.italy,
            "Tv4SDyOBB9E",
            false);

    History mexico1986 =
        new History("Mexico 1986", "ARGENTINA", R.drawable.argentina, 3, "WEST GERMANY",
            R.drawable.germany, 2, "POLAND", R.drawable.poland, "Estadio Azteca, Mexico City",
            "Gary Lineker", R.drawable.england, 6, "Diego Maradona", R.drawable.argentina,
            "Jean-Marie Pfaff", R.drawable.belgium, "uPtCxH7tuKo", false);

    History italy1990 =
        new History("Italy 1990", "WEST GERMANY", R.drawable.germany, 1, "ARGENTINA",
            R.drawable.argentina, 0, "ITALY", R.drawable.italy, "Stadio Olimpico, Rome",
            "Salvatore Schillaci", R.drawable.italy, 6, "Salvatore Schillaci", R.drawable.italy,
            "Sergio Goycochea", R.drawable.argentina, "De04MGVT2AA", false);

    History usa1994 =
        new History("United states 1994", "BRAZIL", R.drawable.brazil, 0, "ITALY", R.drawable.italy,
            0, "SWEDEN", R.drawable.sweden, "Rose Bowl, Pasadena", "Hristo Stoichkov",
            R.drawable.bulgaria, 6, "Romário", R.drawable.brazil, "Michel Preud'homme",
            R.drawable.belgium, "pLPM_JSbGvI", true);
    History france1998 =
        new History("France 1998", "FRANCE", R.drawable.france, 3, "BRAZIL", R.drawable.brazil, 0,
            "CROATIA", R.drawable.croatia, "Stade de France, Saint-Denis", "Davor Šuker",
            R.drawable.croatia, 6, "Ronaldo", R.drawable.brazil, "Fabien Barthez",
            R.drawable.france, "iWZeyPBVd4U", false);
    History korJpn2002 =
        new History("South korea and Japan 2002", "BRAZIL", R.drawable.brazil, 2, "GERMANY",
            R.drawable.germany, 0, "TURKEY", R.drawable.turkey, "International Stadium, Yokohama",
            "Ronaldo", R.drawable.brazil, 8, "Oliver Kahn", R.drawable.germany, "Oliver Kahn",
            R.drawable.germany, "UC5cpMRXQxY", false);
    History germany2006 =
        new History("Germany 2006", "ITALY", R.drawable.italy, 1, "FRANCE", R.drawable.france, 1,
            "GERMANY", R.drawable.germany, "Olympiastadion, Berlin", "Miroslav Klose",
            R.drawable.germany, 5, "Zinedine Zidane", R.drawable.france,
            "Gianluigi Buffon", R.drawable.italy, "NANr_RQ1AoA", true);

    History rsa2010 = new History("South africa 2010", "SPAIN", R.drawable.spain, 1, "NETHERLANDS",
        R.drawable.netherlands, 0, "GERMANY", R.drawable.germany, "Soccer City, Johannesburg",
        "Thomas Müller", R.drawable.germany, 5, "Diego Forlán", R.drawable.uruguay, "Iker Casillas",
        R.drawable.spain, "xgUnV3E2mh0", false);

    History brazil2014 = new History("Brazil 2014", "GERMANY", R.drawable.germany, 1, "ARGENTINA",
        R.drawable.argentina, 0, "NETHERLANDS", R.drawable.netherlands, "Maracanã, Rio de Janeiro",
        "James Rodríguez", R.drawable.colombia, 6, "Lionel Messi", R.drawable.argentina,
        "Manuel Neuer", R.drawable.germany, "WzhelIPg7po", false);

    History russia2018 = new History("Russia 2018", "FRANCE", R.drawable.france, 4, "CROATIA",
        R.drawable.croatia, 2, "BELGIUM", R.drawable.belgium," Luzhniki Stadium ,Moscow",
        "Harry Kane", R.drawable.england, 6, "Luka Modric", R.drawable.croatia,
        " Thibaut Courtois", R.drawable.belgium, "mL7Ad4JYGeM", false);
    viewModel.insertWcDetails(uru1930);
    viewModel.insertWcDetails(italy1934);
    viewModel.insertWcDetails(france1938);
    viewModel.insertWcDetails(brazile1950);
    viewModel.insertWcDetails(switherland1954);
    viewModel.insertWcDetails(sweden1958);
    viewModel.insertWcDetails(chile1962);
    viewModel.insertWcDetails(england1966);
    viewModel.insertWcDetails(mexico1970);
    viewModel.insertWcDetails(westGermany1974);
    viewModel.insertWcDetails(argentina1978);
    viewModel.insertWcDetails(spain1982);
    viewModel.insertWcDetails(mexico1986);
    viewModel.insertWcDetails(italy1990);
    viewModel.insertWcDetails(usa1994);
    viewModel.insertWcDetails(france1998);
    viewModel.insertWcDetails(korJpn2002);
    viewModel.insertWcDetails(germany2006);
    viewModel.insertWcDetails(rsa2010);
    viewModel.insertWcDetails(brazil2014);
    viewModel.insertWcDetails(russia2018);
  }

  private void instantiateList() {

    adapter = new HistoryAdapter(new ArrayList<>(), this);
    wcList.setLayoutManager(new LinearLayoutManager(getContext()));
    wcList.setHasFixedSize(true);
    wcList.setAdapter(adapter);
  }

  private void setupAutoComplete(AutoCompleteTextView autoCompleteTextView, String[] datas) {
    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, datas);
    autoCompleteTextView.setAdapter(adapter);
    autoCompleteTextView.setThreshold(1);
  }

  @Override public void onRecapClick(String id) {
    if (id.equals("Empty")) {
      Common.ToastMsg(getContext(), noUrl);
    } else {
      Intent intent = new Intent(getContext(), YoutubeVideos.class);
      intent.putExtra(Constants.EXTRA_VIDEO_ID, id);
      ActivityUtils.dataIntent(getContext(), intent);
    }
  }

  static class IncludeLayout {
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
  }
}
