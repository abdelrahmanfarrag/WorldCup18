package com.example.mana.worldcup18.data.database.offline_news;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = Offline.class, version = 2, exportSchema = false)

public abstract class OfflineDb extends RoomDatabase {
  private static OfflineDb instance;

  public static OfflineDb getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context, OfflineDb.class, "offline.db").
          addMigrations(FROM_1_TO_2).build();
    }
    return instance;
  }

  public static void releaseInstance() {
    instance = null;
  }

  static final Migration FROM_1_TO_2 = new Migration(1, 2) {
    @Override public void migrate(@NonNull SupportSQLiteDatabase database) {
      database.execSQL("ALTER TABLE Offline ADD COLUMN url TEXT");
    }
  };

  public abstract OfflineDao offlineDatabaseAccess();
}
