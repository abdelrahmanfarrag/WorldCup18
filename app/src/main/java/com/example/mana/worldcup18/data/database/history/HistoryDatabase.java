package com.example.mana.worldcup18.data.database.history;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = History.class, version = 1, exportSchema = false)
public abstract class HistoryDatabase extends RoomDatabase {
  private static HistoryDatabase instance;

  public static HistoryDatabase getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context, HistoryDatabase.class, "history.db").build();
    }
    return instance;
  }


  public static void releaseInstance() {
    instance = null;
  }

  public abstract HistoryDao getHistoryAccessObject();
}
