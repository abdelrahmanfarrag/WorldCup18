package com.example.mana.worldcup18.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import java.util.List;

public abstract class BaseRecyclerAdapter<T, H extends BaseViewHolder>
    extends RecyclerView.Adapter<H> {
  private List<T> listItems;

  public BaseRecyclerAdapter(List<T> listItems) {
    this.listItems = listItems;
  }

  protected LayoutInflater getLayoutInflater(Context context) {

    return LayoutInflater.from(context);
  }

  protected T getItemAtPosition(int pos){
    return listItems.get(pos);
  }

  @Override public int getItemCount() {
    return listItems.size();
  }
  protected List<T> getItemsList(){
    return listItems;
  }

  public void addToAdapter(List<?> list){
    listItems= (List<T>) list;
    notifyDataSetChanged();
  }

}
