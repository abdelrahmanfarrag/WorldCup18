package com.example.mana.worldcup18.data.database.knockout;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface KnockDao {
  @Query("SELECT * FROM Knock") LiveData<List<Knock>> knoutMatches();

  @Insert(onConflict = REPLACE) void insertKnockMatch(Knock knock);

  @Query("DELETE FROM Knock") void deleteAll();
}
