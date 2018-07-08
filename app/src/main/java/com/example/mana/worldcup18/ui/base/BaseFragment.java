package com.example.mana.worldcup18.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.mana.worldcup18.data.network.RetroConnect;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment extends Fragment {

  private FragmentActivity context;
  private Unbinder unbinder;
  protected CompositeDisposable disposable = new CompositeDisposable();

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return setUpFragment(inflater, container);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    init(savedInstanceState);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    if (unbinder != null) {
      unbinder.unbind();
    }
  }

  @Override public void onDestroy() {
    super.onDestroy();
    if (disposable.isDisposed()) disposable.clear();
    RetroConnect.clearInstance();
  }

  private View setUpFragment(LayoutInflater inf, ViewGroup container) {
    View view = inf.inflate(setFragmentLayout(), container, false);
    unbinder = ButterKnife.bind(this, view);
    this.context = (FragmentActivity) view.getContext();
    return view;
  }

  public FragmentActivity getContext() {
    return context;
  }

  protected abstract @LayoutRes int setFragmentLayout();

  protected abstract void init(Bundle savedState);
}
