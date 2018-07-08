package com.example.mana.worldcup18.utilities;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FragmentUtils {

  public static void showFragmentOnActivity(Activity host, Fragment guest, @IdRes int container,
      boolean replace) {
    FragmentManager manager = ((FragmentActivity) host).getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    if (replace) {
      transaction.replace(container, guest).commit();
    } else {
      transaction.addToBackStack(null);
      transaction.add(container, guest).commit();
    }
  }
}
