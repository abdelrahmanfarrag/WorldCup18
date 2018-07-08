package com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.news_ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.mana.worldcup18.data.database.offline_news.Offline;
import com.example.mana.worldcup18.data.database.offline_news.OfflineDb;
import com.example.mana.worldcup18.data.model.News;
import com.example.mana.worldcup18.data.network.Services;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.mana.worldcup18.utilities.Constants.APIK_KEY_STR;
import static com.example.mana.worldcup18.utilities.Constants.API_KEY;
import static com.example.mana.worldcup18.utilities.Constants.PUBLISHED_AT;
import static com.example.mana.worldcup18.utilities.Constants.Q;
import static com.example.mana.worldcup18.utilities.Constants.SORT_BY;
import static com.example.mana.worldcup18.utilities.Constants.TOPIC;

public class NewsViewModel extends AndroidViewModel implements Services.Transformation2Java {

  private List<News.Article> news = new ArrayList<>();
  private LiveData<List<Offline>> offline;
  private Services services;
  private OfflineDb offlineDatabase;
  private CompositeDisposable disposable = new CompositeDisposable();

  public NewsViewModel(@NonNull Application application) {
    super(application);

    services = new Services(this.getApplication(), disposable, this);
    offlineDatabase = OfflineDb.getInstance(this.getApplication());
    offline = offlineDatabase.offlineDatabaseAccess().getOfflineNews();
  }

  public LiveData<List<Offline>> getOffline() {
    return offline;
  }

  private void insertOffline(Offline offline) {
    new InsertOffline(offlineDatabase).execute(offline);
  }

  public void insetOfflineNews() {
    Offline offline;
    for (int i = 0; i < 20; i++) {
      String author = getNews().get(i).getAuthor();
      String description = getNews().get(i).getTitle();
      String urlToNews = getNews().get(i).getUrl();
      String urlToImage = getNews().get(i).getUrlToImage();
      String publishDate = getNews().get(i).getPublishedAt();
      String url = getNews().get(i).getUrl();
      offline = new Offline(author, description, urlToNews, urlToImage, publishDate, url);
      insertOffline(offline);
    }
  }

  public void deleteAll() {
    new DelteOffline(offlineDatabase).execute();
  }

  public void fetchNews() {
    Map<String, String> newsMap = new HashMap<>();
    newsMap.put(Q, TOPIC);
    newsMap.put(SORT_BY, PUBLISHED_AT);
    newsMap.put(API_KEY, APIK_KEY_STR);
    services.getNews(newsMap);
  }

  private void setNews(List<News.Article> news) {
    this.news = news;
  }

  public List<News.Article> getNews() {
    return news;
  }

  @Override public void transform2Java(Object model) {
    News news = (News) model;
    List<News.Article> articles = news.getArticles();
    setNews(articles);
  }

  private class InsertOffline extends AsyncTask<Offline, Void, Void> {

    OfflineDb db;

    public InsertOffline(OfflineDb db) {
      this.db = db;
    }

    @Override protected Void doInBackground(Offline... offlines) {
      db.offlineDatabaseAccess().insertNews(offlines[0]);
      return null;
    }
  }

  private class DelteOffline extends AsyncTask<Void, Void, Void> {
    OfflineDb db;

    public DelteOffline(OfflineDb db) {
      this.db = db;
    }

    @Override protected Void doInBackground(Void... voids) {
      db.offlineDatabaseAccess().deleteAll();
      return null;
    }
  }
}
