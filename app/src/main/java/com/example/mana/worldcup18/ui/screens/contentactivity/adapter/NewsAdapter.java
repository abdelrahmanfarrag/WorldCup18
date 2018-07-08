package com.example.mana.worldcup18.ui.screens.contentactivity.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.data.model.News;
import com.example.mana.worldcup18.ui.base.BaseRecyclerAdapter;
import com.example.mana.worldcup18.ui.base.BaseViewHolder;
import com.example.mana.worldcup18.utilities.ActivityUtils;
import com.example.mana.worldcup18.utilities.Animations;
import com.squareup.picasso.Picasso;
import java.util.List;

public class NewsAdapter extends BaseRecyclerAdapter<News.Article, BaseViewHolder> {

  private int lastPos = -1;

  public NewsAdapter(List<News.Article> listItems) {
    super(listItems);
  }

  @NonNull @Override
  public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View newsView =
        getLayoutInflater(parent.getContext()).inflate(R.layout.single_news, parent, false);
    return new NewsHolder(newsView);
  }

  @Override public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    NewsHolder hold = (NewsHolder) holder;

    String date = getItemAtPosition(position).getPublishedAt().replace("Z", "");
    String[] firstDate = date.split("T");
    Picasso.with(hold.itemView.getContext())
        .load(getItemAtPosition(position).getUrlToImage())
        .placeholder(R.drawable.single_match_bg)
        .into(hold.imageNews);
  //  hold.authorNews.setText(getItemAtPosition(position).getAuthor());
    hold.authorTitle.setText(getItemAtPosition(position).getTitle());
    hold.dateNews.setText(firstDate[0] + ", " + firstDate[1]);
    hold.sourceNews.setText(getItemAtPosition(position).getSources().getName());
    //  hold.setColor();
    Animations.fadeAdapterAnimation(hold.itemView.getContext(), hold.itemView, position, lastPos);
  }

  public class NewsHolder extends BaseViewHolder {
    @BindView(R.id.news_img) ImageView imageNews;
    @BindView(R.id.date_news) TextView dateNews;
   // @BindView(R.id.news_author) TextView authorNews;
    @BindView(R.id.title_news) TextView authorTitle;
    @BindView(R.id.source_news) TextView sourceNews;

    @BindColor(R.color.white) int white;
    @BindColor(R.color.grey) int grey;

    public NewsHolder(View itemView) {
      super(itemView);
    }

    @OnClick()
    public void onClick(View v) {
      ActivityUtils.browserIntent(itemView.getContext(),
          getItemAtPosition(getLayoutPosition()).getUrl());
    }
/*
    public void setColor() {
      if (getLayoutPosition() % 2 == 0) {
        newsContainer.setCardBackgroundColor(white);
      } else {
        newsContainer.setCardBackgroundColor(grey);
      }
    }*/
  }
}
