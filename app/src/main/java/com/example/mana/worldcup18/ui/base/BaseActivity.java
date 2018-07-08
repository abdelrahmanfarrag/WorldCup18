package com.example.mana.worldcup18.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import com.example.mana.worldcup18.data.network.RetroConnect;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity {

  private Activity context;
  protected CompositeDisposable disposable = new CompositeDisposable();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(setLayoutId());
    context = this;
    ButterKnife.bind(this);
  }

  @Override protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    setupToolbar();
    init();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (disposable.isDisposed()) disposable.clear();
    RetroConnect.clearInstance();
  }

  @Override protected void onPause() {
    super.onPause();
  }

  public abstract @LayoutRes int setLayoutId();

  public abstract void setupToolbar();

  public abstract void init();

  public Activity getContext() {
    return context;
  }
}
