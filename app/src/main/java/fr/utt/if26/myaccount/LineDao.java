package fr.utt.if26.myaccount;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LineDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(LineEntity lineEntity);

    @Query("DELETE FROM account_table WHERE id= :id")
    void delete(String id);

    @Query("SELECT * from account_table WHERE month=:month  ORDER BY year DESC, month DESC,day DESC ")
    List<LineEntity> getAllLinesOneMonth(int month);

    @Query("SELECT * FROM account_table ORDER BY year DESC, month DESC,day DESC ")
    LiveData<List<LineEntity>> getAllLines();

    @Query("DELETE FROM account_table")
    void deleteAll();

}
