package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AddDetailsDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(AddDetailsData addDetailsData);

    @Query("SELECT * FROM adddetailsdata WHERE addDetailsId=:addDetailsId")
    AddDetailsData findDataById(Long addDetailsId);

    @Query("SELECT * FROM adddetailsdata")
    List<AddDetailsData> findAllData();

    @Query("DELETE FROM adddetailsdata")
    void deleteAll();

    @Query("DELETE FROM adddetailsdata WHERE addDetailsId = :addDetailsId")
    void delete(int addDetailsId);
}
