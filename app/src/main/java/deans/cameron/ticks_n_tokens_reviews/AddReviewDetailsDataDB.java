package deans.cameron.ticks_n_tokens_reviews;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={AddReviewDetailsData.class}, version = 1, exportSchema = false)
public abstract class AddReviewDetailsDataDB extends RoomDatabase {
    public static  final String DB_NAME = "add_review_details_data_db";

    private static AddReviewDetailsDataDB INSTANCE = null;

    public static AddReviewDetailsDataDB getInstance(Context context) {
        if (INSTANCE==null) synchronized (AddReviewDetailsDataDB.class) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AddReviewDetailsDataDB.class,
                            DB_NAME
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  INSTANCE;
    }

    public abstract AddReviewDetailsDataDAO addReviewDetailsDataDAO();
}
