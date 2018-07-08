package com.example.mana.worldcup18.data.database.matches;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = MatchDetails.class, version = 1, exportSchema = false)

public abstract class MatchDb extends RoomDatabase {

  private static MatchDb dbInstance;

  public static MatchDb getDbInstance(Context context) {
    if (dbInstance == null) {
      dbInstance = Room.databaseBuilder(context, MatchDb.class, "match.db").build();
    }
    return dbInstance;
  }

  public static void destoryDbInstnace() {
    dbInstance = null;
  }
  public abstract MatchesDao databaseTransactions();
}
