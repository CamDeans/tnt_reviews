package deans.cameron.ticks_n_tokens_reviews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShowReviewActivity extends AppCompatActivity {
    // initialize parameters
    ImageView iv;

    // Define a handler on the UI thread.
    Handler handler = new Handler();

    // Define a List object that will contain data retrieved from the database.
    List<AddDetailsData> addDetailsDataList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_review);

        ListView listView = (ListView) findViewById(R.id.listView);

        // Define the runnable that will update the user interface
        Runnable showDataList = ()-> {
            for (AddDetailsData item: addDetailsDataList) {
                // Add the Person object to an ArrayList
                ArrayList<AddDetailsData> childList = new ArrayList<>();
                AddDetailsData isChild = new AddDetailsData(item.getChildName(), item.getChildAge(), item.getChore1(), item.getChore2(), item.getChore3(), item.getTntNumberSelection(), item.getAward(), item.getPunishment());
                childList.add(isChild);
                ChildListAdapter childListAdapter = new ChildListAdapter(this, R.layout.activity_review, childList);
                listView.setAdapter(childListAdapter);
            }
        };

        iv = findViewById(R.id.homeBtn);

        // set event to handle user input
        iv.setOnClickListener(view -> startActivity(new Intent(ShowReviewActivity.this, HomeActivity.class)));

        // post the showDataList Runnable to the UI thread.
            Runnable updateUI = ()->{
                AddDetailsDataDB addDetailsDataDB = AddDetailsDataDB.getInstance(this);
                addDetailsDataList = (List<AddDetailsData>) addDetailsDataDB.addDetailsDataDAO().findAllData();
                handler.post(showDataList);
            };
            Thread thread = new Thread(updateUI);
            thread.start();
    }
}