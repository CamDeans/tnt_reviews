package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

@Dao
public interface UserDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(UserData userData);
}
