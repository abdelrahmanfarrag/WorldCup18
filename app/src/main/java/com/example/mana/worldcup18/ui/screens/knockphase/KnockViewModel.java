package com.example.mana.worldcup18.ui.screens.knockphase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.mana.worldcup18.data.database.knockout.Knock;
import com.example.mana.worldcup18.data.database.knockout.KnockDb;
import java.util.List;

public class KnockViewModel extends AndroidViewModel {
  KnockDb db;
  LiveData<List<Knock>> knockMatches;

  public KnockViewModel(@NonNull Application application) {
    super(application);
    db = KnockDb.getInstance(this.getApplication());
    knockMatches = db.getAccessToDatabase().knoutMatches();
  }

  public LiveData<List<Knock>> getKnockMatches() {
    return knockMatches;
  }

  public void insertKnockMatch(Knock knock) {
    new InsertKnockMatch(db).execute(knock);
  }

  public void deleteKnockMatches() {
    new DeleteKnockMatches(db).execute();
  }

  private class InsertKnockMatch extends AsyncTask<Knock, Void, Void> {
    KnockDb db;

    public InsertKnockMatch(KnockDb db) {
      this.db = db;
    }

    @Override protected Void doInBackground(Knock... knocks) {
      db.getAccessToDatabase().insertKnockMatch(knocks[0]);
      return null;
    }
  }

  private class DeleteKnockMatches extends AsyncTask<Void, Void, Void> {
    KnockDb db;

    public DeleteKnockMatches(KnockDb db) {
      this.db = db;
    }

    @Override protected Void doInBackground(Void... voids) {
      db.getAccessToDatabase().deleteAll();
      return null;
    }
  }
}
