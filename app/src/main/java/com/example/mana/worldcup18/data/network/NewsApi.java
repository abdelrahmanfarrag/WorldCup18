package com.example.mana.worldcup18.data.network;

import com.example.mana.worldcup18.data.model.News;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import static com.example.mana.worldcup18.utilities.Constants.EVERY_THING;

public interface NewsApi {
  @GET(EVERY_THING) Observable<Response<News>> getArticles(
      @QueryMap Map<String, String> params
  );
}
