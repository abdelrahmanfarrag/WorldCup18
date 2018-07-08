package com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.matches_ui;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.data.database.matches.MatchDetails;
import com.example.mana.worldcup18.ui.base.BaseFragment;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.MatchesAdapter;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.OnViewClicked;
import com.example.mana.worldcup18.ui.screens.knockphase.KnockActivity;
import com.example.mana.worldcup18.ui.screens.youtubeactivity.YoutubeVideos;
import com.example.mana.worldcup18.utilities.ActivityUtils;
import com.example.mana.worldcup18.utilities.Common;
import com.example.mana.worldcup18.utilities.Constants;
import java.util.ArrayList;

public class MatchesFragment extends BaseFragment
    implements OnViewClicked {

  @BindView(R.id.matches_list) RecyclerView matchesList;
  @BindView(R.id.view_knock_phase) Button viewKnock;
  //Teams Name
  @BindString(R.string.russia) String russia;
  @BindString(R.string.ksa) String ksa;
  @BindString(R.string.egypt) String egypt;
  @BindString(R.string.uruguay) String uruguay;
  @BindString(R.string.portugal) String portugal;
  @BindString(R.string.spain) String spain;
  @BindString(R.string.morocco) String morocco;
  @BindString(R.string.iran) String iran;
  @BindString(R.string.france) String france;
  @BindString(R.string.australia) String australia;
  @BindString(R.string.peru) String peru;
  @BindString(R.string.denmark) String denmark;
  @BindString(R.string.argentina) String argentina;
  @BindString(R.string.iceland) String iceland;
  @BindString(R.string.croatia) String croatia;
  @BindString(R.string.nigeria) String nigeria;
  @BindString(R.string.brazil) String brazil;
  @BindString(R.string.switherland) String swith;
  @BindString(R.string.costa) String costaRica;
  @BindString(R.string.serbia) String serbia;
  @BindString(R.string.germany) String germany;
  @BindString(R.string.mexico) String mexico;
  @BindString(R.string.sweden) String sweden;
  @BindString(R.string.southkorea) String southKorea;
  @BindString(R.string.belguim) String belguim;
  @BindString(R.string.panama) String panama;
  @BindString(R.string.tunisia) String tunisia;
  @BindString(R.string.england) String england;
  @BindString(R.string.colombia) String colombia;
  @BindString(R.string.senegal) String senegal;
  @BindString(R.string.japan) String japan;
  @BindString(R.string.poland) String poland;

  //Stadiums name
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

  //String
  @BindString(R.string.no_url_msg) String noUrl;

  private MatchesList_ViewModel viewModel;
  private MatchesAdapter adapter;

  public static MatchesFragment getInstance() {
    return new MatchesFragment();
  }

  @Override protected int setFragmentLayout() {
    return R.layout.fragment_matches;
  }

  @Override protected void init(Bundle savedState) {
    viewModel = ViewModelProviders.of(getContext()).get(MatchesList_ViewModel.class);
    setupRecyclerData();
  }

  @Override public void onPause() {
    super.onPause();
    viewModel.deleteAll();
  }

  @Override public void onResume() {
    super.onResume();
    insertMatchesDay1(1);
    insertMachesDay2(2);
    inseryMachesDay3(3);
  }

  @Override public void onDestroy() {
    super.onDestroy();
    viewModel.deleteAll();
  }

  private void setupRecyclerData() {
    adapter = new MatchesAdapter(new ArrayList<>(), this);
    matchesList.setLayoutManager(new LinearLayoutManager(getContext()));
    viewModel.getMatchesList().observe(getContext(), matches -> adapter.addToAdapter(matches));

    matchesList.setAdapter(adapter);
  }

  private void insertMatchesDay1(int day) {
    MatchDetails rusVsksa =
        new MatchDetails(day, 5, R.drawable.russia, 0, R.drawable.ksa, "A", luMoscow
            , russia, ksa,
            "Fri, 6/15", "SDY1N-IJOA8");

    MatchDetails egyVsuru =
        new MatchDetails(day, 0, R.drawable.egypt, 1, R.drawable.uruguay, "A", ekater
            , egypt, uruguay,
            "Thu, 6/14", "LPzZa-Btx6I");

    MatchDetails spnVspor =
        new MatchDetails(day, 3, R.drawable.portugal, 3, R.drawable.spain, "B", fisht,
            portugal, spain, "Fri, 6/15", "4rp2aLQl7vg");

    MatchDetails morVsirn =
        new MatchDetails(day, 0, R.drawable.morroco, 1, R.drawable.iran, "B", peterspurg, morocco,
            iran
            , "Fri, 6/15", "rG6hK0eZ_Ys");

    MatchDetails frnVsaus =
        new MatchDetails(day, 2, R.drawable.france, 1, R.drawable.australia, "C", kazan, france,
            australia, "Sat, 6/16", "SXeQdIJo");
    MatchDetails perVsden =
        new MatchDetails(day, 0, R.drawable.peru, 1, R.drawable.denmark, "C", saransk, peru,
            denmark,
            "Sat, 6/16", "O4odLCih0Os");
    MatchDetails argVsice =
        new MatchDetails(day, 1, R.drawable.argentina, 1, R.drawable.iceland, "D", spartak,
            argentina,
            iceland, "Sat, 6/16", "Xvarnwv6hRk");
    MatchDetails croVsngr =
        new MatchDetails(day, 2, R.drawable.croatia, 0, R.drawable.nigeria, "D", kaliningrad,
            croatia,
            nigeria, "Sat, 6/16", "V5h0wKr8");
    MatchDetails brzVsswi =
        new MatchDetails(day, 1, R.drawable.brazil, 1, R.drawable.switzerland, "E", rostov, brazil,
            swith, "Sun, 6/17", "3dWrKNrWbWQ");
    MatchDetails serVscrc =
        new MatchDetails(day, 0, R.drawable.costarica, 1, R.drawable.serbia, "E", samara,
            costaRica,
            serbia, "Sun, 6/17", "bA6_7wFvG0E");
    MatchDetails gerVsmex =
        new MatchDetails(day, 0, R.drawable.germany, 1, R.drawable.mexico, "F", luMoscow, germany,
            mexico, "Sun, 6/17", "6BSeFs40QOI");
    MatchDetails sweVssko =
        new MatchDetails(day, 1, R.drawable.sweden, 0, R.drawable.southkorea, "F", nizhny, sweden,
            southKorea, "Mon, 6/18", "hUl5UU");
    MatchDetails belVspan =
        new MatchDetails(day, 3, R.drawable.belgium, 0, R.drawable.panama, "G", fisht, belguim,
            panama, "Mon, 6/18", "XCr1xpwEuZQ");
    MatchDetails tunVseng =
        new MatchDetails(day, 1, R.drawable.tunisia, 2, R.drawable.england, "G", volvograd, tunisia,
            england, "Mon, 6/18", "u3wfrhjoIJg");
    MatchDetails colVsjpn =
        new MatchDetails(day, 1, R.drawable.colombia, 2, R.drawable.japan, "H", saransk, colombia,
            japan, "Tues, 6/19", "y4SeAfCg7");
    MatchDetails senVspol =
        new MatchDetails(day, 1, R.drawable.poland, 2, R.drawable.senegal, "H", spartak, poland,
            senegal, "Tues, 6/19", "SXkg_12ukOk");

    viewModel.insertMatch(rusVsksa);
    viewModel.insertMatch(egyVsuru);
    viewModel.insertMatch(spnVspor);
    viewModel.insertMatch(morVsirn);
    viewModel.insertMatch(frnVsaus);
    viewModel.insertMatch(perVsden);
    viewModel.insertMatch(argVsice);
    viewModel.insertMatch(croVsngr);
    viewModel.insertMatch(brzVsswi);
    viewModel.insertMatch(serVscrc);
    viewModel.insertMatch(gerVsmex);
    viewModel.insertMatch(sweVssko);
    viewModel.insertMatch(belVspan);
    viewModel.insertMatch(tunVseng);
    viewModel.insertMatch(colVsjpn);
    viewModel.insertMatch(senVspol);
  }

  private void insertMachesDay2(int day) {
    MatchDetails rusVsegy =
        new MatchDetails(day, 3, R.drawable.russia, 1, R.drawable.egypt, "A", peterspurg, russia,
            egypt, "Tues, 6/19", "AygUlfmQgBs");

    MatchDetails ksaVsuru =
        new MatchDetails(day, 1, R.drawable.uruguay, 0, R.drawable.ksa, "A", rostov, uruguay, ksa,
            "Wed, 6/20", "ZxEMQTAGYzI");

    MatchDetails morVspor =
        new MatchDetails(day, 1, R.drawable.portugal, 0, R.drawable.morroco, "B", luMoscow,
            portugal, morocco, "Wed, 6/20", "sEtVNlzYAqQ");

    MatchDetails spnVsirn =
        new MatchDetails(day, 0, R.drawable.iran, 1, R.drawable.spain, "B", kazan, iran, spain,
            "Wed, 6/20", "_3C6DK8n0mQ");

    MatchDetails frnVsper =
        new MatchDetails(day, 1, R.drawable.france, 0, R.drawable.peru, "C", ekater, france, peru,
            "Thur, 6/21", "9-QIE-xaueo");
    MatchDetails ausVsden =
        new MatchDetails(day, 1, R.drawable.denmark, 1, R.drawable.australia, "C", samara, denmark,
            australia, "Thur, 6/21", "24m_D5EFb-A");

    MatchDetails argVscro =
        new MatchDetails(day, 0, R.drawable.argentina, 3, R.drawable.croatia, "D", nizhny,
            argentina, croatia, "Thur, 6/21", "hcM5n71XmBo");
    MatchDetails ngrVsice =
        new MatchDetails(day, 2, R.drawable.nigeria, 0, R.drawable.iceland, "D", volvograd, nigeria,
            iceland, "Fri, 6/22", "KIk9avLQSds");
    MatchDetails braVscrc =
        new MatchDetails(day, 2, R.drawable.brazil, 0, R.drawable.costarica, "E", peterspurg,
            brazil, costaRica, "Fri, 6/21", "u2v_mb5Xx00");
    MatchDetails serVsswi =
        new MatchDetails(day, 1, R.drawable.serbia, 2, R.drawable.switzerland, "E", kaliningrad,
            serbia, swith, "Fri, 6/21", "0O3CbugZtTg");
    MatchDetails gerVsswe =
        new MatchDetails(day, 2, R.drawable.germany, 1, R.drawable.sweden, "F", fisht, germany,
            sweden, "Sat, 6/22", "4e9a3KptfC0");
    MatchDetails mexVssko =
        new MatchDetails(day, 1, R.drawable.southkorea, 2, R.drawable.mexico, "F", rostov,
            southKorea, mexico, "Sat, 6/22", "UOSg165xRTw");

    MatchDetails tunVsbel =
        new MatchDetails(day, 5, R.drawable.belgium, 2, R.drawable.tunisia, "G", spartak, belguim,
            tunisia, "Sat, 6/22", "RKuQ8zDo0Lw");
    MatchDetails engVspan =
        new MatchDetails(day, 6, R.drawable.england, 1, R.drawable.panama, "G", nizhny, england,
            panama, "Sun, 6/23", "kPAIcIBtCtE");
    MatchDetails jpnVssen =
        new MatchDetails(day, 2, R.drawable.japan, 2, R.drawable.senegal, "H", ekater, japan,
            senegal, "Sun, 6/23", "TLS1JQ7qtpI");
    MatchDetails polVscol =
        new MatchDetails(day, 0, R.drawable.poland, 3, R.drawable.colombia, "H", kazan, poland,
            colombia, "Sun, 6/23", "wa974tOozEI");

    viewModel.insertMatch(rusVsegy);
    viewModel.insertMatch(ksaVsuru);
    viewModel.insertMatch(morVspor);
    viewModel.insertMatch(spnVsirn);
    viewModel.insertMatch(frnVsper);
    viewModel.insertMatch(ausVsden);
    viewModel.insertMatch(argVscro);
    viewModel.insertMatch(ngrVsice);
    viewModel.insertMatch(braVscrc);
    viewModel.insertMatch(serVsswi);
    viewModel.insertMatch(gerVsswe);
    viewModel.insertMatch(mexVssko);
    viewModel.insertMatch(tunVsbel);
    viewModel.insertMatch(engVspan);
    viewModel.insertMatch(jpnVssen);
    viewModel.insertMatch(polVscol);
  }

  private void inseryMachesDay3(int day) {
    MatchDetails rusVsuru = new MatchDetails(day, 3, R.drawable.uruguay, 0, R.drawable.russia, "A"
        , samara, uruguay, russia, "Mon, 6/25", "I_YrTEiOVGo");
    MatchDetails ksaVsegy =
        new MatchDetails(day, 2, R.drawable.ksa, 1, R.drawable.egypt, "A", volvograd
            , ksa, egypt, "Mon, 6/25", "lEzuFPeSBcA");
    MatchDetails spnVsmro =
        new MatchDetails(day, 2, R.drawable.spain, 2, R.drawable.morroco, "B", kaliningrad
            , spain, morocco, "Mon, 6/25", "cIOqidBVnO4");
    MatchDetails irnVspor =
        new MatchDetails(day, 1, R.drawable.iran, 1, R.drawable.portugal, "B", saransk
            , iran, portugal, "Mon, 6/25", "JlPIrEKFCeo");
    MatchDetails ausVsper = new MatchDetails(day, 0, R.drawable.australia, 2, R.drawable.peru, "C",
        fisht, australia, peru, "Tues, 6/26", "fR-txBJG-B4");
    MatchDetails frnVsden = new MatchDetails(day, 0, R.drawable.denmark, 0, R.drawable.france, "C",
        luMoscow, denmark, france, "Tues, 6/26", "UvFP1ITZ7To");
    MatchDetails ngrVsarg =
        new MatchDetails(day, 1, R.drawable.nigeria, 2, R.drawable.argentina, "D",
            peterspurg, nigeria, argentina, "Tues, 6/26", "RmlkAOwJ1gI");
    MatchDetails iceVscro = new MatchDetails(day, 1, R.drawable.iceland, 2, R.drawable.croatia, "D",
        rostov, iceland, croatia, "Tues, 6/26", "wfy1ojdPyzA");
    MatchDetails serVsbrz = new MatchDetails(day, 0, R.drawable.serbia, 2, R.drawable.brazil, "E",
        spartak, serbia, brazil, "Wed, 6/27", "_dusyi-4pMs");
    MatchDetails swiVscrc =
        new MatchDetails(day, 2, R.drawable.switzerland, 2, R.drawable.costarica, "E",
            nizhny, swith, costaRica, "Wed, 6/27", "izvscMabH8o");
    MatchDetails korVsger =
        new MatchDetails(day, 2, R.drawable.southkorea, 0, R.drawable.germany, "F",
            kazan, southKorea, germany, "Wed, 6/27", "OKjV2SQfKrw");
    MatchDetails mexVsswe =
        new MatchDetails(day, 0, R.drawable.mexico, 3, R.drawable.sweden, "F", ekater,
            mexico, sweden, "Wed, 6/27", "BHT6V1SpmNA");
    MatchDetails panVstun =
        new MatchDetails(day, 1, R.drawable.panama, 2, R.drawable.tunisia, "G", saransk,
            panama, tunisia, "Thur, 6/28", "nc9zirKrT0Q");
    MatchDetails engVsbel =
        new MatchDetails(day, 0, R.drawable.england, 1, R.drawable.belgium, "G", kaliningrad,
            england, belguim, "Thur, 6/28", "N5F1hqWW_5w");
    MatchDetails jpnVspol =
        new MatchDetails(day, 0, R.drawable.japan, 1, R.drawable.poland, "H", volvograd,
            japan, poland, "Thur, 6/28", "K7pVlD8Q660");
    MatchDetails colVssen =
        new MatchDetails(day, 0, R.drawable.senegal, 1, R.drawable.colombia, "H", samara,
            senegal, colombia, "Thur, 6/28", "2CRmHuN-O84");

    viewModel.insertMatch(rusVsuru);
    viewModel.insertMatch(ksaVsegy);
    viewModel.insertMatch(spnVsmro);
    viewModel.insertMatch(irnVspor);
    viewModel.insertMatch(ausVsper);
    viewModel.insertMatch(frnVsden);
    viewModel.insertMatch(ngrVsarg);
    viewModel.insertMatch(iceVscro);
    viewModel.insertMatch(serVsbrz);
    viewModel.insertMatch(swiVscrc);
    viewModel.insertMatch(korVsger);
    viewModel.insertMatch(mexVsswe);
    viewModel.insertMatch(panVstun);
    viewModel.insertMatch(engVsbel);
    viewModel.insertMatch(jpnVspol);
    viewModel.insertMatch(colVssen);
  }

  @OnClick({ R.id.view_knock_phase })
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.view_knock_phase:
        ActivityUtils.normalIntent(getContext(), KnockActivity.class);
        break;
    }
  }

  @Override public void onRecapClick(String id) {
    if (id.equals("Empty")) {
      Common.ToastMsg(getContext(), noUrl);
    } else {
      if (Common.isOnline(getContext())) {
        Intent intent = new Intent(getContext(), YoutubeVideos.class);
        intent.putExtra(Constants.EXTRA_VIDEO_ID, id);
        ActivityUtils.dataIntent(getContext(), intent);
      } else {
        Dialog d = Common.transparentDialog(getContext(), R.layout.no_network_dialog, 0);
        Button b = d.findViewById(R.id.check_btn);
        b.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            d.dismiss();
          }
        });
        d.show();
      }
    }
  }
}


