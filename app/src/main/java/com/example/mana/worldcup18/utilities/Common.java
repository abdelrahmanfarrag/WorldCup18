package com.example.mana.worldcup18.utilities;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.LayoutRes;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Common {

  public static void ToastMsg(Context context, String msg) {
    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
  }

  public static Dialog transparentDialog(Context context, @LayoutRes int layoutId,int style) {
    final Dialog transDialog = new Dialog(context,style);
    transDialog.setContentView(layoutId);
    transDialog.setCancelable(true);
    transDialog.setCanceledOnTouchOutside(true);
    return transDialog;
  }

  public static String convertDateToString(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("LLLL MM ,yyyy", Locale.US);
    String dat = sdf.format(date);
    return dat;
  }
  public static boolean isOnline(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo netInfo = cm.getActiveNetworkInfo();
    return netInfo != null && netInfo.isConnectedOrConnecting();
  }


}
