package com.example.mana.worldcup18.data.network;

import android.content.Context;
import com.google.gson.Gson;
import retrofit2.Response;

public class Validate {
  private Services.Transformation2Java response2Java;
  private Context ctx;
  private Gson gson = new Gson();

  public Validate(Context ctx, Services.Transformation2Java response2Java) {
    this.ctx = ctx;
    this.response2Java = response2Java;
  }

  public void transform2Java(Response<?> response) {
    Object model = response.body();
    response2Java.transform2Java(model);
  }




}
