package fr.utt.if26.myaccount;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LineDao {
    @Query("SELECT * FROM account_table")
    List<Line> getAllLines();

    @Insert
    void insertAll(Line line);
}
