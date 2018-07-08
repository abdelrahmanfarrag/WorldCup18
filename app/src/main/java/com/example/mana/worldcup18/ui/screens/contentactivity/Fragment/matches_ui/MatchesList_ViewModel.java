package com.example.mana.worldcup18.ui.screens.contentactivity.Fragment.matches_ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.mana.worldcup18.data.database.matches.MatchDb;
import com.example.mana.worldcup18.data.database.matches.MatchDetails;
import java.util.List;

public class MatchesList_ViewModel extends AndroidViewModel {

  private LiveData<List<MatchDetails>> matchesList;
  private MatchDb db;

  public MatchesList_ViewModel(@NonNull Application application) {
    super(application);
    db = MatchDb.getDbInstance(this.getApplication());
    matchesList = db.databaseTransactions().getMatchesList();
  }

  public LiveData<List<MatchDetails>> getMatchesList() {
    return matchesList;
  }

  public void insertMatch(MatchDetails match) {
    new InsertMatch(db).execute(match);
  }

  public void deleteAll() {
    new DeleteAllMatches(db).execute();
  }

  public class InsertMatch extends AsyncTask<MatchDetails, Void, Void> {

    MatchDb db;

    public InsertMatch(MatchDb db) {
      this.db = db;
    }

    @Override protected Void doInBackground(MatchDetails... matches) {
      db.databaseTransactions().insertMatch(matches[0]);
      return null;
    }
  }

  public class DeleteAllMatches extends AsyncTask<Void, Void, Void> {
    MatchDb db;

    public DeleteAllMatches(MatchDb db) {
      this.db = db;
    }

    @Override protected Void doInBackground(Void... voids) {
      db.databaseTransactions().deleteAll();
      return null;
    }
  }
}
