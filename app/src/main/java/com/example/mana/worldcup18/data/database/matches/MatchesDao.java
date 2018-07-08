package com.example.mana.worldcup18.data.database.matches;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MatchesDao {

  @Query("SELECT * FROM MatchDetails")
  LiveData<List<MatchDetails>> getMatchesList();

  @Insert(onConflict = REPLACE)
  void insertMatch(MatchDetails matches);

  @Query("DELETE FROM MatchDetails")
  void deleteAll();
}
