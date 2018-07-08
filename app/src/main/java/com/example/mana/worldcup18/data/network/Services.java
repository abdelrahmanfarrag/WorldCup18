package com.example.mana.worldcup18.data.network;

import android.content.Context;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import retrofit2.Response;

public class Services {
  CompositeDisposable disposables;
  private Context context;
  private Validate validate;

  NewsApi api = RetroConnect.getInstance();

  public Services(Context context, CompositeDisposable disposables,
      Transformation2Java response2Java) {
    this.context = context;
    this.disposables = disposables;
    validate = new Validate(context, response2Java);
  }

  public void getNews(Map<String, String> query) {
    Disposable disposable = api.getArticles(query)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::valideResponse);
    disposables.add(disposable);
  }

  private void valideResponse(Response<?> response) {
    validate.transform2Java(response);
  }

  public interface Transformation2Java {
    void transform2Java(Object model);
  }
}
