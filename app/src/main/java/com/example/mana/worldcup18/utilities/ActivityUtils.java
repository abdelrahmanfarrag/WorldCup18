package com.example.mana.worldcup18.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;

public class ActivityUtils {

  public static void IntentHandler(final Context context, final Class<?> destination,
      Handler handler, long duration) {
    handler.postDelayed(() -> normalIntent(context, destination), duration);
  }

  public static void normalIntent(Context context, Class<?> destination) {
    context.startActivity(new Intent(context, destination));
  }

  public static void browserIntent(Context ctx, String url) {
    Intent in = new Intent(Intent.ACTION_VIEW);
    in.setData(Uri.parse(url));
    ctx.startActivity(in);
  }



  public static void dataIntent(Context context, Intent intent) {
    context.startActivity(intent);
  }
}
