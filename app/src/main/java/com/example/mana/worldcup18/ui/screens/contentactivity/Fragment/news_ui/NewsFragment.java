package com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.news_ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.ui.base.BaseFragment;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.NewsAdapter;
import com.example.mana.worldcup18.ui.screens.contentactivity.adapter.OfflineAdapter;
import com.example.mana.worldcup18.utilities.Common;
import java.util.ArrayList;

public class NewsFragment extends BaseFragment {

  @BindView(R.id.news_list) RecyclerView newsList;


  private NewsViewModel viewModel;

  private OfflineAdapter offlineAdapter;

  public static NewsFragment getInstance() {
    return new NewsFragment();
  }

  @Override protected int setFragmentLayout() {
    return R.layout.fragment_news;
  }

  @Override protected void init(Bundle savedState) {
    viewModel = ViewModelProviders.of(getContext()).get(NewsViewModel.class);
    if (Common.isOnline(getContext())) {
      viewModel.fetchNews();
      if (viewModel.getNews() == null) return;
      if (viewModel.getNews().size() == 0) {
        setData();
      }
    } else {
      setupOfflineNews();
    }
  }

  @Override public void onResume() {
    super.onResume();
    setupOfflineNews();
  }

  private void setData() {
    viewModel.deleteAll();
    Handler handler = new Handler();
    handler.postDelayed(() -> {
      viewModel.fetchNews();
      viewModel.insetOfflineNews();
      setupRecyclerView();
    }, 3000);
  }

  private void setupRecyclerView() {

    newsList.setLayoutManager(new LinearLayoutManager(getContext()));
    newsList.setHasFixedSize(true);
    newsList.setAdapter(new NewsAdapter(viewModel.getNews()));
  }

  private void setupOfflineNews() {
    offlineAdapter = new OfflineAdapter(new ArrayList<>());
    newsList.setLayoutManager(new LinearLayoutManager(getContext()));
    viewModel.getOffline().observe(getContext(), matches -> offlineAdapter.addToAdapter(matches));
    newsList.setAdapter(offlineAdapter);
  }
}
