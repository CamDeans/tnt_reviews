package deans.cameron.ticks_n_tokens_reviews;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class AddReviewDetailsData {
    @PrimaryKey(autoGenerate = true)
    int addReviewDetailsId;
    @ColumnInfo(name="tickCount")
    int tickCount;
    @ColumnInfo(name="tokenCount")
    int tokenCount;
    @ColumnInfo(name="reviewMessage")
    String reviewMessage;

    //
    public AddReviewDetailsData(int tickCount, int tokenCount, String reviewMessage) {
        this.tickCount = tickCount;
        this.tokenCount = tokenCount;
        this.reviewMessage = reviewMessage;
    }

    @Ignore
    public AddReviewDetailsData(){}

    public int getAddDetailsId() {
        return addReviewDetailsId;
    }

    public void setAddDetailsId(int addReviewDetailsId) {
        this.addReviewDetailsId = addReviewDetailsId;
    }

    public int getTickCount() {
        return tickCount;
    }

    public void setTickCount(int tickCount) {
        this.tickCount = tickCount;
    }

    public int getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public String getReviewMessage() {
        return reviewMessage;
    }

    public void setReviewMessage(String reviewMessage) {
        this.reviewMessage = reviewMessage;
    }
}
