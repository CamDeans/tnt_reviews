package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DataDAO {
    @Query("SELECT * FROM data")
    List<Data> findAllData();

    @Query("SELECT * FROM data WHERE id=:id")
    Data findDataById(Long id);

    @Query("SELECT id FROM data WHERE id=:id")
    Data findIdById(Long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert (Data data);

    @Query ("DELETE FROM data WHERE id=:id")
    void deleteById(Long id);

    @Query ("DELETE FROM data")
    void deleteAll();

    @Delete
    int delete (Data data);
}
