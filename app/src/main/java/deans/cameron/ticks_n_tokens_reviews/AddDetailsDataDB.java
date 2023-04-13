package deans.cameron.ticks_n_tokens_reviews;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={AddDetailsData.class}, version = 1, exportSchema = false)
public abstract class AddDetailsDataDB extends RoomDatabase {
    public static  final String DB_NAME = "add_details_data_db";

    private static AddDetailsDataDB INSTANCE = null;

    public static AddDetailsDataDB getInstance(Context context) {
        if (INSTANCE==null) synchronized (AddDetailsDataDB.class) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AddDetailsDataDB.class,
                            DB_NAME
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return  INSTANCE;
    }

    public abstract AddDetailsDataDAO addDetailsDataDAO();
}
