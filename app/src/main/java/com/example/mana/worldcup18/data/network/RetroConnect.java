package com.example.mana.worldcup18.data.network;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mana.worldcup18.utilities.Constants.BASE_URL;

public class RetroConnect {
  private static NewsApi api;

  public static NewsApi getInstance() {
    api = new RetroConnect().initRetrofit();
    return api;
  }

  public static void clearInstance() {
    api = null;
  }

  private NewsApi initRetrofit() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
        .build();
    return retrofit.create(NewsApi.class);
  }
}
