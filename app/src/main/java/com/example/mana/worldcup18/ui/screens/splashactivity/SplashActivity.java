package com.example.mana.worldcup18.ui.screens.splashactivity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import butterknife.BindView;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.ui.base.BaseActivity;
import com.example.mana.worldcup18.ui.screens.contentactivity.ContentActivity;
import com.example.mana.worldcup18.utilities.ActivityUtils;
import com.example.mana.worldcup18.utilities.Animations;

public class SplashActivity extends BaseActivity {

  @BindView(R.id.world_cup_logo) ImageView worldCupLogo;

  @Override public int setLayoutId() {
    return R.layout.splash_activity;
  }

  @Override public void setupToolbar() {

  }

  @Override public void init() {
    Animations.makeViewRotate(getContext(), worldCupLogo);
    Handler h = new Handler();
    ActivityUtils.IntentHandler(getContext(), ContentActivity.class, h, 5000);
  }
}
