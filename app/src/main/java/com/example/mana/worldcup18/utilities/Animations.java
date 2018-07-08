package com.example.mana.worldcup18.utilities;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.mana.worldcup18.R;

public class Animations {

  public static void makeViewRotate(Context context, View view) {
    Animation animation = AnimationUtils.loadAnimation(context, R.anim.rotate);
    view.startAnimation(animation);
  }

  public static void adapterAnimation(Context context, View animated, int index, int layoutPos) {
    if (index > layoutPos) {
      Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
      animated.startAnimation(animation);
      index = layoutPos;
    }
  }

  public static void fadeAdapterAnimation(Context context, View animated, int index,
      int layoutPos) {
    if (index > layoutPos) {
      Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
      animated.startAnimation(animation);
      index = layoutPos;
    }
  }
}
