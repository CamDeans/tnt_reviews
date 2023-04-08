package deans.cameron.ticks_n_tokens_reviews;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={UserData.class}, version = 1, exportSchema = false)
public abstract class UserDataDB extends RoomDatabase {
    public static  final String DB_NAME = "user_data_db";

    private static UserDataDB  INSTANCE = null;

    public static UserDataDB getInstance(Context context) {
        if (INSTANCE==null) synchronized (UserDataDB.class) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UserDataDB.class,
                            DB_NAME
                    )
                    .allowMainThreadQueries()
                    .build();
        }
        return  INSTANCE;
    }

    public abstract UserDataDAO userDataDAO();
}
