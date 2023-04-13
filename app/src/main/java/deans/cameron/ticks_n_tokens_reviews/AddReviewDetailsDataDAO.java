package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AddReviewDetailsDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(AddReviewDetailsData addReviewDetailsData);

    @Query("SELECT * FROM addreviewdetailsdata WHERE addReviewDetailsId=:addReviewDetailsId")
    AddReviewDetailsData findDataById(Long addReviewDetailsId);

    @Query("SELECT * FROM addreviewdetailsdata")
    List<AddReviewDetailsData> findAllData();

    @Query("DELETE FROM addreviewdetailsdata")
    void deleteAll();

    @Query("UPDATE AddReviewDetailsData SET tickCount = :tickCount")
    void updateTickCount(int tickCount);

    @Query("UPDATE AddReviewDetailsData SET tokenCount = :tokenCount")
    void updateTokenCount(int tokenCount);

    @Query("UPDATE AddReviewDetailsData SET reviewMessage = :reviewMessage")
    void updateReviewMessage(String reviewMessage);
}
