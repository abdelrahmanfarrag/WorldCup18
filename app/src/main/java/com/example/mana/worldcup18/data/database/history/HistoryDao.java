package com.example.mana.worldcup18.data.database.history;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface HistoryDao {

  @Query("SELECT * FROM History") LiveData<List<History>> getAllWC();

  @Query("SELECT * FROM History WHERE location=:location") History getSingleWC(String location);

  @Insert(onConflict = REPLACE) void insertWC(History wc);

  @Query("DELETE FROM History") void deleteAll();
}
