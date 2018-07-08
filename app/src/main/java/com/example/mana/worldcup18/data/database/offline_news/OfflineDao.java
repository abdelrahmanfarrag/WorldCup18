package com.example.mana.worldcup18.data.database.offline_news;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface OfflineDao {

  @Query("SELECT * FROM Offline") LiveData<List<Offline>> getOfflineNews();

  @Insert(onConflict = REPLACE) void insertNews(Offline offline);

  @Query("DELETE FROM Offline") void deleteAll();
}
