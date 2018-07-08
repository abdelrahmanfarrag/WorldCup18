package com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.history_ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.mana.worldcup18.data.database.history.History;
import com.example.mana.worldcup18.data.database.history.HistoryDatabase;
import java.util.ArrayList;
import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
  LiveData<List<History>> wcHistory;
  List<History> singleCup;
  HistoryDatabase db;
  History h = new History();

  public HistoryViewModel(@NonNull Application application) {
    super(application);
    db = HistoryDatabase.getInstance(this.getApplication());
    wcHistory = db.getHistoryAccessObject().getAllWC();
    singleCup = new ArrayList<>();
  }

  public void insertWcDetails(History history) {
    new InsertSingleWolrdCupDetails(db).execute(history);
  }

  public void deleteAll() {
    new DeleteAllDetails(db).execute();
  }

  public History selectCup(String cupLocation) {
    new SelectSpecificCup(db).execute(cupLocation);
    return getH();
  }

  public LiveData<List<History>> getWcHistory() {
    return wcHistory;
  }

  private class DeleteAllDetails extends AsyncTask<Void, Void, Void> {
    HistoryDatabase db;

    public DeleteAllDetails(HistoryDatabase db) {
      this.db = db;
    }

    @Override protected Void doInBackground(Void... voids) {
      db.getHistoryAccessObject().deleteAll();
      return null;
    }
  }

  private class InsertSingleWolrdCupDetails extends AsyncTask<History, Void, Void> {

    HistoryDatabase db;

    public InsertSingleWolrdCupDetails(HistoryDatabase db) {
      this.db = db;
    }

    @Override protected Void doInBackground(History... histories) {
      db.getHistoryAccessObject().insertWC(histories[0]);
      return null;
    }
  }

  private class SelectSpecificCup extends AsyncTask<String, Void, History> {
    HistoryDatabase db;

    public SelectSpecificCup(HistoryDatabase db) {
      this.db = db;
    }

    @Override protected History doInBackground(String... strings) {
    History hist= db.getHistoryAccessObject().getSingleWC(strings[0]);
      return hist;
    }

    @Override protected void onPostExecute(History history) {
      super.onPostExecute(history);
      setH(history);
    }
  }

  public History getH() {
    return h;
  }

  public void setH(History h) {
    this.h = h;
  }
}
