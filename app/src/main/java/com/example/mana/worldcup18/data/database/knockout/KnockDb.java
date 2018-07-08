package com.example.mana.worldcup18.data.database.knockout;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = Knock.class, version = 3, exportSchema = false)
public abstract class KnockDb extends RoomDatabase {
  private static KnockDb instance;

  public static KnockDb getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context, KnockDb.class, "knock.db")
          .addMigrations(FROM_1_TO_2,FROM_2_TO_3)
          .build();
    }
    return instance;
  }

  static final Migration FROM_1_TO_2 = new Migration(1, 2) {
    @Override public void migrate(@NonNull SupportSQLiteDatabase database) {
      database.execSQL("ALTER TABLE Knock ADD COLUMN round TEXT");
    }
  };
  static final Migration FROM_2_TO_3 = new Migration(2,3) {
    @Override public void migrate(@NonNull SupportSQLiteDatabase database) {
      database.execSQL("ALTER TABLE Knock ADD COLUMN drawn TEXT");
    }
  };


  public static void releaseInstance() {
    instance = null;
  }

  public abstract KnockDao getAccessToDatabase();
}
