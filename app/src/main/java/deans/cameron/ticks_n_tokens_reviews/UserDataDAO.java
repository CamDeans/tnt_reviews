package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(UserData userData);

    @Query("UPDATE UserData SET password= :password")
    void update(String password);
}
